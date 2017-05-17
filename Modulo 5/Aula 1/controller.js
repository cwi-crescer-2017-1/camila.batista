var oi = angular.module('oi', []);

oi.controller('controller1', function($scope, $rootScope){
  $rootScope.texto = 'Heil Joe';
  //rootScope é o scope padrão colocado pelo ng-app
    $scope.texto = 'Heil Rainha!';
});
