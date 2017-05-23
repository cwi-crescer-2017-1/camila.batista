console.log('oi aula');
a.controller('aulaController', function($scope){
  let mostrar = false;
  $scope.aula=[{id:0,nome:'oi'}];
  $scope.compararNomes = function(array, objeto){
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


});
