modulo.factory('livroService', function($http){
  var url = 'http://localhost:8081';

  return {
    listar: Obter,
    lancamento: ObterLancamentos,
    detalhes: ObterPorId,
    criar: Criar
  }

  function Obter(){
    return $http.get(url + '/api/Livro');
  }

  function Obter(skip){
    return $http.get(url + '/api/Livro/' + skip);
  }       

  function ObterLancamentos(){
    return $http.get(url + '/api/Livro/Lancamento');
  }

  function ObterPorId(isbn){
    return $http.get(url + '/api/Livro/Descricao' + isbn);
  }

  function Criar(livro){
    livro.Isbn = ++IsbnAtual;
    Livros.push(angular.copy(livro));
  }

});
