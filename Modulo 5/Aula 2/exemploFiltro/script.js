var a = angular.module('modulo', []);

function array(arrayInstrutor){
  var novo = [];
  angular.forEach(arrayInstrutor, function(instrutor){
    angular.forEach(instrutor.aula, function(aula){
      novo.push({instrutor: instrutor.nome, aulaNome: aula.nome, numAula: aula.numero});
    });
  });
  return novo;
}

a.filter('exercicio2', function(){
  return function(nome){
    return nome.replace(/(nunes)/i, '$ $1 $');
  }
});


a.controller('mascada', function($scope, $filter){
  var instrutores = [{
    nome: 'Pedro (PHP)',
    aula: [{
      numero: 3,
      nome: 'HTML e CSS'
    }]
  },
  {
    nome: 'Zanatta',
    aula: [{
      numero: 5,
      nome: 'AngularJS'
    }]
  },
  {
    nome: 'Bernardo',
    aula: [{
      numero: 1,
      nome: 'OO'
    },
    {
      numero: 4,
      nome: 'Javascript'
    }]
  },
  {
    nome: 'Nunes',
    aula: [{
      numero: 2,
      nome: 'Banco de Dados I'
    }]
  }];

  $scope.instrutores = instrutores;

  $scope.crescer = array($scope.instrutores);
});
