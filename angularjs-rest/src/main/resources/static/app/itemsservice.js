angular.module("app").service("itemsService", ItemsService);

ItemsService.$inject = [ "$resource" ];

function ItemsService($resource) {

   var that = this;

   this.items = [];

   var ItemResource = $resource('/items/:id', 
      {id : '@id'}, 
      {update : { method : "PUT" }}
   );

   this.getItems = function() {
      this.items = ItemResource.query();
      return this.items;
   }

   this.newItem = function(newItem) {
      new ItemResource(newItem).$save(function(item) {
         that.items.push(item);
      });
   }

   this.updateItem = function(updatedItem) {
      updatedItem.$update();
   }

   this.deleteItem = function(item) {
      item.$remove(function() {
         that.items.splice(that.items.indexOf(item), 1);
      });
   }
}
