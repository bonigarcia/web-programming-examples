angular.module("app").service("blogService", BlogService);

BlogService.$inject = [ "$resource" ];

function BlogService($resource) {

   var that = this;

   this.posts = [];

   var PostResource = $resource('/posts/:id', 
      {id : '@id'},
      {update : {method : "PUT"}}
   );

   this.getPosts = function() {
      this.posts = PostResource.query();
      return this.posts;
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
