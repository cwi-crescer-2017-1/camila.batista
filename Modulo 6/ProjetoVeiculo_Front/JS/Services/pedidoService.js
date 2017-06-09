modulo.factory('pedidoService', function($http){
    var url = 'http://localhost:50992/api';

    return{
        getAll: Obter,
        getById: ObterPorId,
        insert: Adicionar,
        procurar: Procurar,
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

    function Procurar(mes){
        return $http.get(url + '/pedido/ObterRelatorioMensal/' + mes);
    }

    function Apagar(cliente){
       return $http.delete(url + '/pedido', cliente);
    }
});