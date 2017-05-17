var oi = angular.module('oi', []);

oi.controller('pokemon', function($scope, $rootScope){
  $rootScope.nomePok = 'ROOT ROOT ROOT';
  $scope.pokemon = {nome: 'Togepi', tipo: 'Fada'};
});
