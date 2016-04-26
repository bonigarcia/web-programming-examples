angular.module("app").controller("PostController", PostController);

PostController.$inject = [ "blogService", "$routeParams", "$scope" ];

function PostController(blogService, $routeParams, $scope) {

   // Properties
   $scope.post = {};

   // Actions
   $scope.post = blogService.getPost($routeParams.id);

};
