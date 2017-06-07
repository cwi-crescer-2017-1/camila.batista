modulo.config(function($routeProvider){
    $routeProvider
        .when('/login',{
            controller: 'loginController',
            templateUrl: 'VIEWS/login.html'
        })
        .when('/telaMenu', {
            controller: 'telaMenuController',
            templateUrl: 'VIEWS/telaMenu.html'
        });
});