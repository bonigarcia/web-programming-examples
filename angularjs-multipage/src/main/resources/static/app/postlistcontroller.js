angular.module("app").controller("PostListController", PostListController);

PostListController.$inject = [ "blogManager", "$location" ];

function PostListController(blogManager, $location) {

	var vm = this;

	// View model properties

	vm.posts = []

	// Controller logic

	vm.posts = blogManager.getPosts();

	// Controller actions

	vm.deletePost = function(post) {
		blogManager.deletePost(post);
	};

	vm.viewPost = function(post) {
		$location.path("/post");
	};

};
