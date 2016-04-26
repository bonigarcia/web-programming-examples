angular.module("app").controller("PostListController", PostListController);

PostListController.$inject = [ "blogService", "$location", "$scope" ];

function PostListController(blogService, $location, $scope) {

   // Properties
   $scope.posts = [];

   // Actions
   $scope.posts = blogService.getPosts();

   $scope.deletePost = function(post) {
      blogService.deletePost(post);
   };

   $scope.viewPost = function(post) {
      $location.path("/post");
   };

};
