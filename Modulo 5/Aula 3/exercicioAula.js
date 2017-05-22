var app = angular.module('oi', []);

app.controller('contro', function ($scope) {
  $scope.instrutores = [{
    id: 0,
    nome: 'Bernardo',
    sobrenome: 'Rezende',
    idade: 30,
    email: 'bernardo@cwi.com.br',
    jaDeuAula: true,
    aula: 'OO'
  }];

  $scope.aulas = [
    'OO',
    'HTML e CSS',
    'Javascript',
    'AngularJS',
    'Banco de Dados I'
  ];

  $scope.cadastrar = function(){

    $scope.instrutores.push(angular.copy($scope.novoInstrutor));

    $scope.novoInstrutor = {};
  }
});
