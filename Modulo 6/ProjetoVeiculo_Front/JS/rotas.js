modulo.config(function($routeProvider){
    $routeProvider
        .when('/login',{
            controller: 'loginController',
            templateUrl: 'VIEWS/login.html'
        })
        .when('/telaMenu', {
            controller: 'telaMenuController',
            templateUrl: 'VIEWS/telaMenu.html'
        })
        .when('/cliente',{
            controller: 'cadastrarClienteController',
            templateUrl: 'VIEWS/cliente.html'
        })
        .when('/cliente/:action/:idURL',{
            controller: 'cadastrarClienteController',
            templateUrl: 'VIEWS/cadastrarCliente.html'
        })
        .when('/pedido',{
            controller: 'pedidoController',
            templateUrl: 'VIEWS/pedido.html'
        })
        .when('/pedido/:action/:idURL',{
            controller: 'pedidoController',
            templateUrl: 'VIEWS/pedidoCadastrar.html'
        })
        .when('/relatorio',{
            controller: 'pedidoController',
            templateUrl: 'VIEWS/relatorio.html'
        });
});