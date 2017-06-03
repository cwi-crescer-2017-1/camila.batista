modulo.config(function($routeProvider){
  $routeProvider
    .when('/home', {
      controller: 'livroController',
      templateUrl: 'Views/home.html'
    })
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
