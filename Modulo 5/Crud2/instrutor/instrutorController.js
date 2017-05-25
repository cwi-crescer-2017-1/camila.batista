angular.module('rotas').controller('instrutorController', function($scope){
  let mostrar;
  let edita = false;

  //Verifica o objeto é igual a algum já existente
  function compararNome(array, objeto){
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

  $scope.editarInstrutor = function(edit){
    $scope.edita = true;
    $scope.array = angular.copy(edit);
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

  $scope.salvar = function(novoNome){
    if($scope.alteracao.$valid){
      //$scope.aulas.splice(array.id, 1, array);
      let index = $scope.pegarIndexInstrutorPorID($scope.array.id);
      $scope.instrutores[index].nome = novoNome.nome;

    //  $scope.aulas[array.id] = angular.copy(array);
      delete $scope.array;
      $scope.novoNomeAula ='';
      $scope.edita = false;
    }
  }
  $scope.pegarIndexInstrutorPorID = function(idInstrutor){
    for(let i=0; i<$scope.instrutores.length; i++){
      if($scope.instrutores[i].id === idInstrutor){
        return i;
      }
    }
  }
  $scope.cancelar = function(array){
    delete $scope.array;
    $scope.edita = false;
  }

  $scope.deletar = function(instrutor){
    let id = $scope.instrutores.indexOf(instrutor);
    if(verifica(instrutores.id)){
      return;
    }
    $scope.aulas.splice(id, 1);
  }

  $scope.adicionarInstrutor = function(){
    if($scope.formInstrutores.$valid){
      let compareNome = compararNome($scope.instrutores, $scope.novoInstrutor);
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
      $scope.mostrar = true;

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

  if($scope.instrutores.length > 0){
    $scope.mostrar = true;
  }
});
