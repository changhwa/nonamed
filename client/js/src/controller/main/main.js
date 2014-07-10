var app = angular.module('nonamed',['ngRoute']);

app.controller('MainCtrl', ['$scope','$route', function($scope,$route) {

}]);


app.config(['$routeProvider', function ($routeProvider) {

    $routeProvider
        .when('/login', {
            templateUrl: 'template/login.html'

        })
        .otherwise({
            redirectTo: '/login'
        });

}]);