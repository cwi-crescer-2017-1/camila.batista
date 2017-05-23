console.log('oi aula');
a.controller('aulaController', function($scope){
  let mostrar;
  let edita = false;

  function compararNomes (array, objeto){
    let c = false;
    for(let i = 0; i < array.length; i++){
      if(array[i].nome.localeCompare(objeto.nome) === 0){
        c = true;
      }else{
        c = false;
      }
    }
    return c;
  }

  $scope.editar = function(edit){
    $scope.edita = true;
    $scope.array = angular.copy(edit);
  }

  $scope.salvar = function(novoNome){
    if($scope.alteracao.$valid){
      //$scope.aulas.splice(array.id, 1, array);
      let index = $scope.pegarIndexAulaPorID($scope.array.id);
      $scope.aula[index].nome = novoNome;

    //  $scope.aulas[array.id] = angular.copy(array);
      delete $scope.array;
      $scope.novoNomeAula ='';
      $scope.edita = false;
    }
  }
  $scope.pegarIndexAulaPorID = function(idAula){
    for(let i=0; i<$scope.aula.length; i++){
      if($scope.aula[i].id === idAula){
        return i;
      }
    }
  }
  $scope.cancelar = function(array){
    delete $scope.array;
    $scope.edita = false;
  }
  $scope.deletar = function(aula){
    let id = $scope.aula.indexOf(aula);
    if(verifica(aula.id)){
      return;
    }
    $scope.aula.splice(id, 1);
  }

  $scope.adicionarAula = function(){
    if($scope.aulaForm.$valid){
      if(compararNomes($scope.aula, $scope.novaAula)){
        // toastr.error('A aula já existe');
        return;
      }else{
        $scope.novaAula.id = geradorId($scope.aula);
        $scope.aula.push($scope.novaAula);
        delete $scope.novaAula;
        // toastr.sucess('Aula adiciona com sucesso');
        $scope.edita = true;
        console.log($scope.aula);
      }
    }
  }

  $scope.aula = [
    {id: 0, nome: 'POO'},
    {id: 1, nome: 'Banco de Dados I'},
    {id: 2, nome: 'HTML e CSS'}
  ];

  if($scope.aula.length > 0){
    $scope.mostrar = true;
  }

});
