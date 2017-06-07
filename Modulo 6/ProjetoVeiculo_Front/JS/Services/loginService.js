modulo.factory('loginService', function($http){
    var url = 'http://localhost:50992/api';

    return{
        getAll: Obter,
        getById: ObterPorId,
        insert: Adicionar,
        delete: Apagar
    }

    function Obter(){
        return $http.get(url + '/funcionario');
    }

    function ObterPorId(id){
        return $http.get(url + '/funcionario/' + id);
    }

    function Adicionar(funcionario){
        Funcionarios.Id = ++idAtual;
        Funcionarios.push(angular.copy(funcionario));
    }

    function Apagar(funcionario){
        Funcionarios.delete(funcionario);
    }
});