var c = angular.module('crud', []);

c.controller('crudAula', function($scope){
  let mostrarAula;
  let mostrarInstrutor;
  let edita = false;

  function comparar (array, objeto){
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

  function geradorId(array){
    return array.length > 0 ? array.length : null;
  }

  function verifica(id){
    for(let i = 0; $scope.instrutores.length > i; i++){
      for(let a = 0; a < $scope.instrutores[i].aula.length; a++){
        if (id === $scope.instrutores[i].aula[a]) {
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
  //não ta funcionando, altera apenas a primeira aula cadastrada
  $scope.salvar = function(array){
    if($scope.alteracao.$valid){
      $scope.aulas.splice(array.id, 1, array);
      delete $scope.array;
      $scope.edita = false;
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
    if($scope.formAulas.$valid){
      let compareNome = comparar($scope.aulas, $scope.novaAula);
      if(compareNome){
        // toastr.error('A aula já existe');
        return;
      }

      $scope.novaAula.id = geradorId($scope.aulas);
      $scope.aulas.push($scope.novaAula);
      delete $scope.novaAula;
      // toastr.sucess('Aula adiciona com sucesso');
      $scope.mostrarAula = true;
      console.log($scope.aulas);

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

  console.log($scope.aulas);
  if($scope.aulas.length > 0){
    $scope.mostrarAula = true;
  }
});
