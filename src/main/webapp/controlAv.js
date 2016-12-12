var app = angular.module("avenger", ["ngRoute"]);

var xhr = new XMLHttpRequest();

//Fonction init
var init = function(scope, http) {

    var url = 'http://172.28.11.18:8080/avengers/app/rest/avengers';

    http.get(url).then(function (resp) {
        scope.avengers = resp.data;
        console.log(scope.avengers);
        scope.avenger = {};
    });
}

//Fonction delete
var deleteAvenger = function (id, http, scope) {

    var urlDelete = 'http://172.28.11.18:8080/avengers/app/rest/avengers/' + id;

    http.delete(urlDelete).then(function () {
        init(scope, http);
        console.log('delete');
    });
}

//Récupérer un avenger
var getAvenger = function(id, http, scope) {

    var url = 'http://172.28.11.18:8080/avengers/app/rest/avengers/' + id;

    http.get(url).then(function (resp) {
        scope.av = resp.data;
        scope.showok = true;
        console.log(scope.av);
        console.log(scope.showok);
    });
}


//On enregistre l'avenger
var saveAvenger = function(http, scope) {

    console.log(scope.avenger);
    console.log('ok');

    var url = 'http://172.28.11.18:8080/avengers/app/rest/avengers/';

    http.post(url, scope.avenger).then(function () {
        init(scope, http);
    });
}

//On définit le controller
app.controller("controlAv", function ($scope, $http) {

    init($scope, $http);

    $scope.remove = function(id) {
        deleteAvenger(id, $http, $scope);
    };

    $scope.display = function(id) {
        getAvenger(id, $http, $scope);
    };

    $scope.hide = function() {
        $scope.showok = false;
    }

    $scope.save = function(avenger) {
        $scope.avenger = avenger;
        saveAvenger($http, $scope);
    }

    $scope.order = function(prop) {
        $scope.propAv = prop;
    }

})

//Controller 2, pour récupérer un seul avenger
app.controller("controlAv2", function ($scope, $http) {

    getAvenger(220, $scope, $http);
})


//Create directive
app.directive("carteav", function() {

    // console.log('test');
    return {
        template : "<div class='panel panel-success'>" +
            "<div class='panel-heading'>Super Template</div>" +
            "<div class='panel-body'>" +
            "<ul>" +
            "<li>" +
            "<p>First Name : {{av.firstName}}</p>" +
            "<p>Last Name : {{av.lastName}}</p>" +
            "<p>Alias : {{av.alias}}</p>" +
            "</li>" +
            "</ul>" +
            "</div>" +
            "</div>" +
            "<button class='btn btn-warning' ng-click='hide()'>Hide</button>"
    };
});

//Filter
app.filter('myFormat', function () {

    return function(x) {
        var i, c, txt="";
        for (i = 0; i < x.length; i++) {
            c = x[i];
            if (i % 2 == 0) {
                c = c.toUpperCase();
            }
            txt += c;
        }
        return txt;
    };
});

//Route
app.config(function ($routeProvider) {

    console.log($routeProvider);
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