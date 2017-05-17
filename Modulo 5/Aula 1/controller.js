var oi = angular.module('oi', []);

oi.controller('controller1', function($scope, $rootScope){
  $rootScope.texto = 'Heil Joe';
  //rootScope é o scope padrão colocado pelo ng-app
    $scope.texto = 'Heil Rainha!';
});


oi.controller('exemplo2', function($scope){
  let pokemons = [
    {nome: 'pikachu', tipo: 'elétrico'},
    {nome: 'charmander', tipo: 'fogo'},
    {nome: 'pokemon 1', tipo: 'agua'},
    {nome: 'pokemon 2', tipo: 'terra'},
    {nome: 'pokemon 3', tipo: 'default'},
    {nome: 'pokemon 4', tipo: 'ar'}
  ];
  $scope.pokemons = pokemons;
});
