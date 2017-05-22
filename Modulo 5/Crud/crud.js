var c = angular.module('crud', []);

c.controller('crudAula', function($scope){
  let mostrarAula;
  let mostrarInstrutor;
  let edita = false;
  let editaInstrutor = false;

  //Verifica o objeto é igual a algum já existente
  function comparar(array, objeto){
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

  //Verifica se a aula esta ligada a algum instrutor
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
    $scope.editaInstrutor = true;
    $scope.array = angular.copy(edit);
  }
  //não ta funcionando, altera apenas a primeira aula cadastrada
  $scope.salvar = function(novoNome){
    if($scope.alteracao.$valid){
      //$scope.aulas.splice(array.id, 1, array);
      let index = $scope.pegarIndexAulaPorID($scope.array.id);
      $scope.aulas[index].nome = novoNome;

    //  $scope.aulas[array.id] = angular.copy(array);
      delete $scope.array;
      $scope.novoNomeAula ='';
      $scope.edita = false;
      $scope.editaInstrutor = false;
    }
  }
  $scope.pegarIndexAulaPorID = function(idAula){
    for(let i=0; i<$scope.aulas.length; i++){
      if($scope.aulas[i].id === idAula){
        return i;
      }
    }
  }
  $scope.cancelar = function(array){
    delete $scope.array;
    $scope.edita = false;
    $scope.editaInstrutor = false;
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

  $scope.adicionarInstrutor = function(){
    if($scope.formInstrutores.$valid){
      let compareNome = comparar($scope.instrutores, $scope.novoInstrutor);
      if(compareNome){
        return;
      }

      if(typeof $scope.instrutores.urlFoto === 'undefined' | $scope.instrutores.urlFoto === null){
        $scope.instrutores.urlFoto = 'http://fbuzz.net/wp-content/uploads/2012/05/giga-pudding.jpg';
      }

      $scope.novoInstrutor.id = geradorId($scope.instrutores);


        for(let a = 0; a < $scope.novoInstrutor.aula.length; a++){
          if(typeof $scope.novoInstrutor.aula[a] === 'string'){
          $scope.novoInstrutor.aula[a] =  parseInt($scope.novoInstrutor.aula[a]);
        }
      }

      $scope.instrutores.push($scope.novoInstrutor);
      delete $scope.novoInstrutor;
      $scope.mostrarInstrutor = true;

    }
  }
  //Verifica se a aula esta ligada a algum instrutor
  function verificaInstrutor(id){
    if($scope.instrutores[id].aula.length>0){
      return true;
    }else{
      return false;
    }
  }

  $scope.deletarInstrutor = function(instrutor){
    let id = $scope.instrutores.indexOf(instrutor);
    if(verificaInstrutor(instrutor.id)){
      alert('Instrutor dando aula, impossível deletar');
      return;
    }

    $scope.instrutores.splice(id, 1);
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
