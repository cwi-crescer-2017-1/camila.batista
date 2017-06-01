modulo.factory('livroService', function($http){
  var url = 'http://localhost:8080';

  return {
    listar: Obter,
    findById: ObterPorId,
    criar: Criar
  }

  function Obter(){
    return $http.get(url + '/Livros');
  }

  function ObterPorId(isbn){
    return $http.get(url + '/Livros' + isbn);
  }

  function Criar(livro){
    livro.Isbn = ++IsbnAtual;
    Livros.push(angular.copy(livro));
  }

});
