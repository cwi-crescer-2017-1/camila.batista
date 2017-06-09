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

                $scope.$watch('dateString', function (dateString)
                {
                    $scope.date = new Date(dateString);
                });

debugger;
                $scope.cliente.Sexo = parseInt($scope.cliente.Sexo);

                
                
            });
    }

            // if(Sexo.Equals(1))
            // {
            //     sexo = Genero.FEMININO;
            // }else if (Sexo.Equals(2))
            // {
            //     sexo = Genero.MASCULINO;
            // }

    function excluir(id){
        cadastrarClienteService.getById(id)
            .then(function(respose){
                $scope.clientes = response.data;
            });
    }

    $scope.cadastrar = cadastrar;
    $scope.editar = editar;
    $scope.excluir = excluir;
    
    debugger;
    if($routeParams.action == 'editar'){
        editar($routeParams.idURL);
    }else if($routeParams.action == 'adicionar'){
        
    }else{
        load();
    }
});
