let a = angular.module('rotas', ['ngRoute']);

a.config(function ($routeProvider) {
  $routeProvider
    .when('/index', {
      controller: 'principalController',
      templateUrl: 'index.html'
    })
    .when('/aula', {
      controller: 'aulaController',
      templateUrl: '/aula.html'
    })
    .when('/instrutor', {
      controller: 'intrutorController',
      templateUrl: 'instrutor.html'
    })
    .otherwise({redirecTo: '/index'});
});
