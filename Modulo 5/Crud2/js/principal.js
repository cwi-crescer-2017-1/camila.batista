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
      templateUrl: '/aula.html'
    })
    .when('/instrutor', {
      controller: 'intrutorController',
      templateUrl: 'instrutor.html'
    })
    .otherwise({redirecTo: '/index'});
});

a.controller('principalController', function($scope){

  //Implementar de outro modo (ERRADO)
  $scope.geradorId = function(array){
    return array.length > 0 ? array.length : null;
  };

  $scope.verificar = function(id){
    for(let i = 0; $scope.instrutores.length > i; i++){
      for(let a = 0; a < $scope.instrutores[i].aula.length; a++){
        if(id === $scope.instrutores[i].aula[a]){
          return true;
        }
      }
    }
    return false;
  }
});
