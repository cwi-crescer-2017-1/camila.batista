modulo.controller('cadastrarClienteController', function($scope, $filter, $routeParams, cadastrarClienteService){

    $scope.cliente;

    function load(){
        cadastrarClienteService.getAll()
            .then(function(response){
                $scope.clientes = response.data;
        });
    }

    function cadastrar(){
        cadastrarClienteService.insert($scope.cliente)
            .then(function(response){
        });
    }

    function editar(id){
        debugger;
        cadastrarClienteService.getById(id)
            .then(function(response){
                debugger;

                $scope.cliente = response.data;
               
                $scope.cliente.DataNascimento = new Date();

                // $scope.$watch('dateString', function (dateString)
                // {
                //     $scope.date = new Date(dateString);
                // });

                $scope.cliente.Sexo = parseInt($scope.cliente.Sexo);                
            });
    }

    // function excluir(id){
    //     debugger;
    //     cadastrarClienteService.delete(id)
    //         .then(function(response){
    //             debugger;
    //             $scope.cliente = response.data;

    //             // cadastrarClienteService.load();
    //         });
    // }

    $scope.cadastrar = cadastrar;
    $scope.editar = editar;
    // $scope.excluir = excluir;
    
    debugger;
    if($routeParams.action == 'editar'){
        editar($routeParams.idURL);
    }else if($routeParams.action == 'adicionar'){
        
    }else{
        load();
    }
});
