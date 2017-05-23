angular.module('rotas').factory('instrutorService', function($http){
  let url = 'http://localhost:3000';

  return{
    listar: listar,
    findById: findById,
    atualizar: atualizar,
    criar: criar,
    deletar: deletar
  }

  function listar(){
    return $http.get(url + '/instrutor');
  }

  function findById(id){
    return $http.get(url + '/instrutor/' + id);
  }

  function atualizar(instrutor){
    return $http.put(url + '/instrutor/' + instrutor.id, instrutor);
  }

  function criar(instrutor){
    instrutor.id = ++idAtual;
    instrutores.push(angular.copy(instrutor));
  }

  function deletar(instrutor){
    return;
  }
});
