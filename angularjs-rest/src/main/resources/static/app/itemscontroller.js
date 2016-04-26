angular.module("app").controller("ItemsController", ItemsController);

ItemsController.$inject = [ "$scope", "itemsService" ];

function ItemsController($scope, itemsService) {
   // Properties
   $scope.items = [];
   $scope.newItem = "";

   // Actions
   $scope.items = itemsService.getItems();

   $scope.addItem = function(description) {
      itemsService.newItem({
         description : description,
         checked : false
      });

      $scope.newItem = "";
   };

   $scope.updateItem = function(item) {
      itemsService.updateItem(item);
   };

   $scope.deleteItem = function(item) {
      itemsService.deleteItem(item);
   };
};
