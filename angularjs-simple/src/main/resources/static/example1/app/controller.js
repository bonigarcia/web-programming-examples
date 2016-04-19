angular.module("app").controller("Controller", Controller);

function Controller($scope) {
    $scope.name = "Anybody";

    $scope.setName = function(name) {
        $scope.name = name;
    }
}
