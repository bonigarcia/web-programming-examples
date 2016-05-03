var myApp = angular.module('myApp', [ 'ionic' ]);

myApp.run(function($ionicPlatform) {
    $ionicPlatform.ready(function() {
        if (window.cordova && window.cordova.plugins.Keyboard) {
            cordova.plugins.Keyboard.hideKeyboardAccessoryBar(true);
        }
        if (window.StatusBar) {
            StatusBar.styleDefault();
        }
    });
});

myApp.config(function($stateProvider, $urlRouterProvider) {
    $stateProvider.state('home', {
        url : '/home',
        templateUrl : 'views/home/home.html'
    }).state('reservation', {
        url : '/reservation',
        controller : 'ReservationController',
        templateUrl : 'views/reservation/reservation.html'
    });

    $urlRouterProvider.otherwise('/home');
});
