modulo.factory('livroService', function($http){
  var url = 'http://localhost:8081';

  return {
    listar: Obter,
    listarPorId: ObterPorId,
    criar: Criar
  }

  function Obter(skip){
    return $http.get(url + '/api/Livro/' + skip);
  }

  function ObterPorId(isbn){
    return $http.get(url + 'api/Livros' + isbn);
  }

  function Criar(livro){
    livro.Isbn = ++IsbnAtual;
    Livros.push(angular.copy(livro));
  }

});
