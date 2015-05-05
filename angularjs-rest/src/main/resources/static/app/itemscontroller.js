angular.module("app").controller("ItemsController", ItemsController);

ItemsController.$inject = [ "itemsService" ];

function ItemsController(itemsService) {
	var vm = this;

	// View model properties
	vm.items = [];
	vm.newItem = "";

	// Controller logic
	vm.items = itemsService.getItems();

	// Controller actions
	vm.addItem = function(description) {

		itemsService.newItem({
			description : description,
			checked : false
		});

		vm.newItem = "";
	};

	vm.updateItem = function(item) {
		itemsService.updateItem(item);
	};

	vm.deleteItem = function(item) {
		itemsService.deleteItem(item);
	};
};

