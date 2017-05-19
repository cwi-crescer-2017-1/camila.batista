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

a.filter('exercicio3', function(){
  return function (numAula){
    let num = numAula.toString();
    while(num.length < 3){ num=('0').concat(num)};
    //console.log(num);
    //let b = '000';
    //let aa = num.substring(0, b.length - num.length) + num;
  //  return aa.concat(num);
  return num;
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
