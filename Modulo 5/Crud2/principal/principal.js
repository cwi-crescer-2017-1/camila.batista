console.log('tchau principal');
var a = angular.module('rotas', ['ngRoute']);

a.config(function ($routeProvider) {
  $routeProvider
    .when('/aula', {
      controller: 'aulaController',
      templateUrl: 'aula/aula.html'
    })
    .when('/instrutor', {
      controller: 'instrutorController',
      templateUrl: 'instrutor/instrutor.html'
    })
    .otherwise({redirecTo: '/index.html'});
});

a.controller('principalController', function($scope){

});
