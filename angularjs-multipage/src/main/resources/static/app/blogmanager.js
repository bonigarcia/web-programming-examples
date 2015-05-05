angular.module("app").factory("blogManager", blogManager);

blogManager.$inject = [ "$resource", "$timeout" ];

function blogManager($resource, $timeout) {

	var PostResource = $resource('/posts/:id', 
		{ id : '@id'}, 
		{ update : {method : "PUT"}}
	);

	var posts = [];

	function autoreload(){
		reload();
		$timeout(autoreload, 5000);
	}
	
	autoreload();
	
	return {
		reload : reload,
		getPosts : getPosts,
		getPost : getPost,		
		newPost : newPost,
		updatePost : updatePost,
		deletePost : deletePost
	}

	function reload(){
		return PostResource.query(function(newposts){
			posts.length = 0;
			posts.push.apply(posts, newposts);
		}).$promise;
	}
	
	function getPosts() {
		return posts;
	}

	function getPost(id) {
		for (var i = 0; i < posts.length; i++) {
			if (posts[i].id.toString() === id) {
				return posts[i];
			}
		}
	}

	function newPost(newPost) {
		new PostResource(newPost).$save(function(post) {
			posts.push(post);
		});
	}

	function updatePost(updatedPost) {
		updatedPost.$update();
	}

	function deletePost(post) {
		post.$remove(function() {
			posts.splice(posts.indexOf(post), 1);
		});
	}	
}