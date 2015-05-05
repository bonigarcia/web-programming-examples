angular.module("app").service("blogService", BlogService);

BlogService.$inject = [ "$resource" ];

function BlogService($resource) {

	var that = this;
	
	this.posts = [];
	
	var PostResource = $resource('/posts/:id', 
		{ id : '@id'}, 
		{ update : { method : "PUT"}}
	);
	
	this.getPosts = function(){
		this.posts = PostResource.query();
		return this.posts;
	}

	this.getPost = function(id) {
		for (var i = 0; i < this.posts.length; i++) {
			if (this.posts[i].id.toString() === id) {
				return this.posts[i];
			}
		}
	}

	this.newPost = function(newPost) {
		new PostResource(newPost).$save(function(post) {
			that.posts.push(post);
		});
	}

	this.updatePost = function(updatedPost) {
		updatedPost.$update();
	}

	this.deletePost = function(post) {
		post.$remove(function() {
			that.posts.splice(that.posts.indexOf(post), 1);
		});
	}	
}