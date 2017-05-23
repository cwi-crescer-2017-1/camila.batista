console.log('tchau principal');
var a = angular.module('rotas', ['ngRoute']);

a.config(function ($routeProvider) {
  $routeProvider
    .when('/index', {
      controller: 'principalController',
      templateUrl: 'index.html'
    })
    .when('/aula', {
      controller: 'aulaController',
      templateUrl: 'aula/aula.html'
    })
    .when('/instrutor', {
      controller: 'intrutorController',
      templateUrl: 'instrutor/instrutor.html'
    })
    .otherwise({redirecTo: '/index'});
});

a.controller('principalController', function($scope){

});
