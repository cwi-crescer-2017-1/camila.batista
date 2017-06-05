modulo.controller('loginController', function($scope, $routeParams, usuarioService, authService, authConfig){
    
    $scope.login = function(usuario){
        authService.login(usuario).then(function(response){
            
        });
    }

});