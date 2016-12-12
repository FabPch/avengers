/**
 * Created by formation on 28/11/2016.
 */
//var app = angular.module("myApp", ["ngRoute"]);

app.config(function ($routeProvider) {

    console.log('testRoute');
    $routeProvider
        .when('/part1', {
            templateUrl : 'partials/part1.html'
        })
        .when('/part2', {
            templateUrl : 'partials/part2.html'
        })
        .when('/part3', {
            templateUrl : 'partials/part3.html'
        })
        .when('/part4', {
            templateUrl : 'partials/part4.html'
        });
    console.log('testRoute2');
});