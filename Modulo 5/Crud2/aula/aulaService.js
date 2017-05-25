angular.module('rotas').factory('aulaService', function($http){
  let url = 'http://localhost:3000';

  function listar(){
    return $http.get(url + '/aula/');
  }

  function findById(id){
    return $http.get(url + '/aula/' + id)
  }

  function atualizar(aula){
    return $http.put(url + '/aula/' + aula.id, aula);
  }

  function criar(aula){
    aula.id = ++idAtual;
    // aula.push(angular.copy(aula));
    return $http.post(url + '/aula/', aula.push(angular.copy(aula)));
  }

  function deletar(aula){
    return $http.delete(url + '/aula/' + aula.id);
  }

  return{
    listar: listar,
    atualizar: atualizar,
    criar: criar,
    deletar: deletar,
    findById: findById
  }
});
