modulo.controller('livroController', function($scope, livroService){

    $scope.livro;


    $scope.obterPagina = function(num){
        livroService.listar(num).then(function(livros){
            $scope.livro = livros.data.dados;
            $scope.paginas = livros.data.paginas;
            debugger;
        });
    }
    $scope.obterPagina(1);
});
