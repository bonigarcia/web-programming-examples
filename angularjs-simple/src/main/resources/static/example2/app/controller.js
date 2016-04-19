angular.module("app").controller("Controller", Controller);

function Controller($scope) {

    // View model properties
    $scope.items = [];
    $scope.newItem = "";

    // Controller actions
    $scope.addItem = function(description) {
        $scope.items.push({
            description : description,
            checked : false
        });
        $scope.newItem = "";
    };

    $scope.deleteItem = function(item) {
        $scope.items.splice($scope.items.indexOf(item), 1);
    };
};
