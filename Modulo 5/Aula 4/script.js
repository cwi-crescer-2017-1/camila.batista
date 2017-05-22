var rota = angular.module('rota', ['ngRoute']);

rota.config(function ($routeProvider) {
  $routeProvider
    .when('/pagina1',{
      controller: 'Pagina1Controler',
      templateUrl: 'pagina1.html'
    })
    .when('/pagina2', {
        controller: 'Pagina2Controller',
        templateUrl: 'pagina2.html'
    })
    .otherwise({redirectTo: '/pagina1'});
});

rota.controller('Pagina1Controler', function($scope){

});

rota.controller('Pagina2Controller', function($scope){

});
