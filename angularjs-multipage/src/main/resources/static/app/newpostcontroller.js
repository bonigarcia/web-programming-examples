angular.module("app").controller("NewPostController", NewPostController);

NewPostController.$inject = [ "blogService", "$location", "$scope" ];

function NewPostController(blogService, $location, $scope) {

   // Properties
   $scope.newPost = {};

   // Actions
   $scope.addPost = function(newPost) {
      blogService.newPost(newPost);
      $scope.newPost = {};
      $location.path("/");
   };
};
