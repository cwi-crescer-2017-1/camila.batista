modulo.factory('pedidoService', function($http){
    var url = 'http://localhost:50992/api';

    return{
        getAll: Obter,
        getById: ObterPorId,
        insert: Adicionar,
        delete: Apagar
    }

    function Obter(){
        return $http.get(url + '/pedido');
    }

    function ObterPorId(id){
        return $http.get(url + '/pedido/' + id);
    }

    function Adicionar(cliente){
        return $http.put(url + '/pedido', cliente);
    }

    function Apagar(cliente){
       return $http.delete(url + '/pedido', cliente);
    }
});