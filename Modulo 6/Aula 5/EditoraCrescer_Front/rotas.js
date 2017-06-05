modulo.config(function($routeProvider){
  $routeProvider
    .when('/home', {
      controller: 'livroController',
      templateUrl: 'Views/home.html'
    })
    .when('/home/:isbn',{
      controller: 'livroDetalhesController',
      templateUrl: 'Views/livro.html'
    })
    .when('/login',{
      controller: 'loginController',
      templateUrl: 'Views/login.html'
    })
    .when('/Autor', {
      controller: 'autorController',
      templateUrl: 'Views/autor.html'
    })
    .otherwise({redirectTo: 'Views/home.html'});
});
