chat.controller('UsuarioController', function($scope, $routeParams, $localStorage, UsuarioService){
  $scope.cadastrar = function (Usuario) {
    UsuarioService.criar(Usuario).then(function(response){
      localStorage.setItem('nome', Usuario.nome, toString());
      localStorage.setItem('foto', Usuario.foto, toString());
      location.href = '#!/Mensagem'
    });
  }
});
