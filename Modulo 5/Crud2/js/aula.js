console.log('oi aula');
angular.module('rotas').controller('aulaController', function($scope){
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

  //Implementar de outro modo (ERRADO)
  function geradorId (array){
    return array.length > 0 ? array.length : null;
  };

  function verifica(id){
    for(let i = 0; $scope.instrutores.length > i; i++){
      for(let a = 0; a < $scope.instrutores[i].aula.length; a++){
        if(id === $scope.instrutores[i].aula[a]){
          return true;
        }
      }
    }
    return false;
  }

  $scope.editar = function(edit){
    $scope.edita = true;
    $scope.array = angular.copy(edit);
  }

  $scope.salvar = function(novoNome){
    if($scope.alteracao.$valid){
      //$scope.aulas.splice(array.id, 1, array);
      let index = $scope.pegarIndexAulaPorID($scope.array.id);
      $scope.aulas[index].nome = novoNome;

    //  $scope.aulas[array.id] = angular.copy(array);
      delete $scope.array;
      $scope.novoNomeAula ='';
      $scope.edita = false;
    }
  }
  $scope.pegarIndexAulaPorID = function(idAula){
    for(let i=0; i < $scope.aulas.length; i++){
      if($scope.aulas[i].id === idAula){
        return i;
      }
    }
  }
  $scope.cancelar = function(array){
    delete $scope.array;
    $scope.edita = false;
  }
  $scope.deletar = function(aula){
    let id = $scope.aulas.indexOf(aula);
    if(verifica(aula.id)){
      return;
    }
    $scope.aulas.splice(id, 1);
  }

  $scope.adicionarAula = function(){
    if($scope.aulaForm.$valid){
      if(compararNomes($scope.aulas, $scope.novaAula)){
        // toastr.error('A aula já existe');
        return;
      }else{
        $scope.novaAula.id = geradorId($scope.aulas);
        $scope.aulas.push($scope.novaAula);
        delete $scope.novaAula;
        // toastr.sucess('Aula adiciona com sucesso');
        $scope.mostrar = true;
        console.log($scope.aulas);
      }
    }
  }

  $scope.aulas = [
    {id: 0, nome: 'POO'},
    {id: 1, nome: 'Banco de Dados I'},
    {id: 2, nome: 'HTML e CSS'}
  ];

  $scope.instrutores = [{
    id: 0,                            // Gerado
    nome: 'Nome',                     // Obrigatório (length = min 3, max 20)
    sobrenome: 'Sobrenome',           // Opcional (length = max 30)
    idade: 25,                        // Obrigatório (max 90)
    email: 'email@cwi.com.br',        // Obrigatório (type=email)
    dandoAula: true,                  // true ou false
    aula: [1, 4],                     // Opcional (array)
    urlFoto: 'http://foto.com/3.png'  // Opcional (porém tem uma default de livre escolha)
  }];

  if($scope.aulas.length > 0){
    $scope.mostrar = true;
  }

});
