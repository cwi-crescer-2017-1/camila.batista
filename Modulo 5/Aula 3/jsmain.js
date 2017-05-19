var app = angular.module('oi', []);

app.controller('mainController', function($scope){
  $scope.nomes = ['Bernardo', 'Nunes'];

  $scope.adicionar = function(novoNome){
    if($scope.meuForm.$invalid){
      return;
    }
    $scope.nomes.push(novoNome);
  }
});
