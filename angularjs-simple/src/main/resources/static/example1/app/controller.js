angular.module("app").controller("Controller", Controller);

function Controller() {
	var vm = this;
	vm.name = "Anybody";

	vm.setName = function(name) {
		vm.name = name;
	}
}
