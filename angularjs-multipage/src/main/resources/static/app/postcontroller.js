angular.module("app").controller("PostController", PostController);

PostController.$inject = [ "blogService", "$routeParams" ];

function PostController(blogService, $routeParams) {

	var vm = this;

	// View model properties

	vm.post = {};

	// Controller logic

	vm.post = blogService.getPost($routeParams.id);

};

