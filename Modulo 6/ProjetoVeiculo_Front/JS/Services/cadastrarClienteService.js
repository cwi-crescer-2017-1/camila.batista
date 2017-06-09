modulo.factory('cadastrarClienteService', function($http){
    var url = 'http://localhost:50992/api';

    return{
        getAll: Obter,
        getById: ObterPorId,
        insert: Adicionar,
        delete: Apagar
    }

    function Obter(){
        return $http.get(url + '/cliente');
    }

    function ObterPorId(id){
        return $http.get(url + '/cliente/' + id);
    }

    function Adicionar(cliente){
        return $http.put(url + '/cliente', cliente);
    }

    function Apagar(cliente){
        Cliente.delete(cliente);
    }
});