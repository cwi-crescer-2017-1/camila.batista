rede.controller('loginController', function($scope, $routeParams, $location, loginService, authConfig, authService, toastr){

    function login(usuario){
        authService.login(usuario)
            .then(
                function(response){
                    $location.path(authConfig.urlPrivado);
                    toastr.sucess('Login realizado com sucesso');
                },
                function(response){
                    toastr.error('Erro ao tentar fazer login. Por favor verifica usuário e senha');
                }
            )
    }

    function novoUsuario(usuario){
        loginService.insert(usuario).then(r => {
            authService.login($scope.usuario).then(response => {
                toastr.sucess('Login realizado com sucesso');
            })
        }, error => {
            toastr.error(error.data.message);
        })
    }

    $scope.login = login;
    $scope.novoUsuario = novoUsuario;
});