angular.module("app").controller("Controller", Controller);

function Controller() {

	var vm = this;

	// View model properties

	vm.items = [];
	vm.newItem = "";

	// Controller actions

	vm.addItem = function(description) {
		vm.items.push({
			description : description,
			checked : false
		});
		vm.newItem = "";
	};

	vm.deleteItem = function(item) {
		vm.items.splice(vm.items.indexOf(item), 1);
	};
};
