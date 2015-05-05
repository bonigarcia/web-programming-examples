angular.module("app").controller("NewPostController", NewPostController);

NewPostController.$inject = ["blogManager", "$location"];

function NewPostController(blogManager, $location) {

	var vm = this;
	
	//View model properties
	
	vm.newPost = {};
	
	//Controller actions

	vm.addPost = function(newPost) {
		
		blogManager.newPost(newPost);
		
		vm.newPost = {};
		
		$location.path("/");
	};
};

