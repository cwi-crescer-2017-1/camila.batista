modulo.controller('loginController', function($scope, $routeParams, $location, $modal, loginService, authService, authConfig, toastr){

    function login(funcionario){
        console.log("oi");
        
        authService.login(funcionario)
            .then(
                function(response){
                    $location.path(authConfig.urlPrivado);
                },
                function(response){
                    toastr.error('Erro no Login! Verifique seu usuário e senha');
                }
            );
    }

    function cadastrar(funcionario){
        console.log("tchau");
        var modalInstance = $modal.open({
            templateUrl: 'index.html',
            controller: 'cadastrarController'
        });

    }
    $scope.login = login;
    $scope.cadastrar = cadastrar;
});