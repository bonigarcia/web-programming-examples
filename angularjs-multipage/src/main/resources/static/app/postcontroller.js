angular.module("app").controller("PostController", PostController);

PostController.$inject = [ "blogManager", "$routeParams" ];

function PostController(blogManager, $routeParams) {

	var vm = this;

	// View model properties
	vm.post = {};

	// Controller logic
	vm.post = blogManager.getPost($routeParams.id);

};
