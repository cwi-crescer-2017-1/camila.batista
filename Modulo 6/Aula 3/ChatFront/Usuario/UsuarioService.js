chat.factory('UsuarioService', function($http){
  const url = 'http://localhost:8080/api/Usuario';

  function get(){
    return $http.get(url);
  }

  function envia(Usuario){
    return $http.post(url, Usuario);
  }

  return {
    listar: get,
    criar: envia
  };
});
