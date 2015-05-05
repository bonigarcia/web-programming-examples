angular.module("app").controller("NewPostController", NewPostController);

NewPostController.$inject = ["blogService", "$location"];

function NewPostController(blogService, $location) {

	var vm = this;
	
	//View model properties
	
	vm.newPost = {};
	
	//Controller actions

	vm.addPost = function(newPost) {
		
		blogService.newPost(newPost);
		
		vm.newPost = {};
		
		$location.path("/");
	};
};

