angular.module('aula2', []).controller('exercicio1', function($scope, $filter){

  $scope.converter = converter;
  function converter(){
    let pattern = '/(\d{2})\/(\d{2})\/(\d{4})/';
    let replace = '$1.$2.$3';
    let dataFormatada = $scope.dataDigitada.replace(pattern, replace);
    console.log(dataFormatada);

    let dataObjeto = new Date(dataFormatada);

    $scope.dataObjeto = dataObjeto;
    $scope.dataPronta = $filter('date')(dataObjeto, 'mediumDate')
  }

});
