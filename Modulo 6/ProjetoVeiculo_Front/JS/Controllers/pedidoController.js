modulo.controller('pedidoController', function($scope, $routeParams, pedidoService){
    $scope.pedido; //nao precisa
    // $scope.clientes = {};
    // $scope.produtos = {};
    // $scope.adicionais = {};
    // $scope.pacotes = {};

    function load(){
        pedidoService.getAll()
            .then(function(response){
                $scope.pedido = response.data;
                debugger;
            });
    }

    function cadastrar(){
        pedidoService.insert($scope.pedido)
            .then(function (response){

            });
    }

    function relatorioMensal(){
        pedidoService.procurar(6)
            .then(function(response){
                $scope.pedido = response.data;
            });
    }

    $scope.cadastrar = cadastrar;
    $scope.relatorioMensal = relatorioMensal;
    debugger;
    relatorioMensal();
    load();
});