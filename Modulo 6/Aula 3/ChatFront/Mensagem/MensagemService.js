chat.factory('MensagemService', function($http){
  const url = 'http://localhost:8080/api/Mensagem';

  function get(){
    return $http.get(url);
  }
  function criar(Mensagem) {
    return $http.post(url, Mensagem);
  }

  return{
    listar: get,
    criar: criar
  }
});
