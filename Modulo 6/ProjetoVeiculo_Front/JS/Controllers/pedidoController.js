modulo.controller('pedidoController', function($scope, $routeParams, pedidoService){
    $scope.pedido;

    function load(){
        pedidoService.getAll()
            .then(function(response){
                $scope.pedido = response.data;
            });
    }

    function cadastrar(){
        pedidoService.insert($scope.pedido)
            .then(function (response){

            });
    }

    $scope.cadastrar = cadastrar;
    load();
});