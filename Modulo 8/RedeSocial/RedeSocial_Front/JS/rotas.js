rede.config(function($routeProvider){
    $routeProvider
        .when('/login',{
            controller: 'loginController',
            templateUrl: 'View/login.html'
        });
});