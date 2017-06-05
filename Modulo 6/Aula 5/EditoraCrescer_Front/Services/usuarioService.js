modulo.factory('usuarioService', function($http){
  var url = 'http://localhost:8081';

  return{
    listar: Obter,
    listarPorId: ObterPorId
  }

  function Obter(){
      return $http.get(url + '/usuario');
  }

  function ObterPorId(id){
      return $http.get(url + '/usuario/' + id);
  }

  function Criar(usuario){
      usuario.Id = ++idAtual;
      return Usuarios.push(angular.copy(usuario)); 
  }
});