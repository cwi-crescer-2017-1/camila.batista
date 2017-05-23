angular.module('rotas').factory('aulaService', function($http){
  let url = 'http://localhost:3000';

  return{
    listar: listar,
    findById: findById,
    atualizar: atualizar,
    criar: criar,
    deletar: deletar
  }

  function listar(){
    return $http.get(url + '/aula');
  }

  function findById(id){
    return $http.get(url + '/aula/' + id)
  }

  function atualizar(aula){
    return $http.put(url + '/aula/' + aula.id, aula);
  }

  function criar(aula){
    aula.id = ++idAtual;
    aulas.push(angular.copy(aula));
  }

  function deletar(aula){
    return;
  }
});
