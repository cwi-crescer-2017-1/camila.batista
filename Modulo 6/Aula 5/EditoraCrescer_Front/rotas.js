modulo.config(function($routeProvider){
  $routeProvider
    .when('/Livros',{
      controller: 'livroController',
      templateUrl: 'Views/livro.html'
    })
    .when('/Autor', {
      controller: 'autorController',
      templateUrl: 'Views/autor.html'
    })
    .otherwise({redirectTo: 'index.html'});
});
