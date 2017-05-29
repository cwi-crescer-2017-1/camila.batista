chat.config(function ($routeProvider){
  $routeProvider
    .when('Usuario/Usuario',{
      controller: 'UsuarioController',
      templateUrl: 'Usuario/Usuario.html'
    })
    .when('Mensagem/Mensagem', {
      controller: 'MensagemController',
      templateUrl: 'Mensagem/Mensagem.html'
    })
    .otherwise({redirecTo: 'Usuario/Usuario'})
});
