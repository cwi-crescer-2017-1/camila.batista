console.log('oi aula');
angular.module('rotas').controller('aulaController', function($scope, aulaService, $location){

  $scope.visualizar = function(aula){
    $location.path('/aula/' + aula.id);
  }

  $scope.editar = function(aula){
    $scope.novaAula = angular.copy(aula);
  }

  $scope.salvar = function(aula){
    if($scope.aulaForm.$valid){
      let promise = angular.isDefined(aula.id) ? aulaService.atualizar(aula) : aulaService.criar(aula);

      promise.then(function(response){
        carregar();
      });

      $scope.novaAula = {};
    }else{
      return;
    }
  }

  $scope.excluir = function (aula) {
    let promise = aulaService.excluir(aula);
    promise.then(function (response) {
      carregar();
    });
  }

  function carregar(){
    let promise = aulaService.listar();

    promise.then(function (response){
      $scope.aulas = response.data;
    });
  }
});
