modulo.controller('livroController', function($scope, livroService){

    $scope.livro;
    $scope.livroLancamento;

    $scope.obterPagina = function(num){
        livroService.listar(num).then(function(livros){
            $scope.livro = livros.data.dados;
            $scope.paginas = livros.data.paginas;
            debugger;
        });
    }
    $scope.obterPagina(1);

    $scope.obterLancamentos = function(){
        livroService.lancamento().then(function(livros){
            $scope.livroLancamento = livros.data.dados;
            debugger;
        });
    }
    $scope.obterLancamentos();
});
