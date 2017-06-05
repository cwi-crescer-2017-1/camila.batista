modulo.controller('livroDetalhesController', function($scope, $location, $routeParams, livroService){
    
    $scope.livroId;
    $scope.obterLivro = obterLivro;
    function obterLivro(isbn){        
        livroService.detalhes(isbn).then(function(livros){
            $scope.livroId = livros.data.dados;
            debugger;
            console.log(livros);
        });
    }
    $scope.obterLivro($routeParams.isbn);
});


