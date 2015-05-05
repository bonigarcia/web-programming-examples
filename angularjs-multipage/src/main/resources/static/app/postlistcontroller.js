angular.module("app").controller("PostListController", PostListController);

PostListController.$inject = [ "blogService", "$location" ];

function PostListController(blogService, $location) {

	var vm = this;

	// View model properties

	vm.posts = []

	// Controller logic

	vm.posts = blogService.getPosts();

	// Controller actions

	vm.deletePost = function(post) {
		blogService.deletePost(post);
	};

	vm.viewPost = function(post) {
		$location.path("/post");
	};

};

