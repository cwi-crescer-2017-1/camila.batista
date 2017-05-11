console.log("carregou!");

// alert("Bem vindo");

if(typeof pi !== 'undefined'){
  cosole.log(pi);
}

function somaSemReturn(a, b){
  return a + b;
}
console.log(typeof somaSemReturn);
console.log("SomaSemReturn ", somaSemReturn(2, 5));

//ecmascript 2015 - ArrowFunction
//var somar = function(a, b){ return a + b;}
var somar = (a, b) => a + b;
console.log(typeof somar);
console.log("Somar ", somar(6, 13));

function soma(a, b, c = 3){
  console.log("C ", c);
  return a + b + c;
}
console.log("Soma com atributo opcional: " + soma(1, 2));

//Não é necessário passar argumentos na function, pois as variaveis estarão disponiveis no array arguments
var soma1 = function(){
  var a = arguments[0], b = arguments[1];
  return a + b;
}

// ERRADO
// undefined + undefined > NaN
// NaN == NaN > false
//
// CERTO
// isNaN(undefined + undefined)


var soma2 = function(){
  var somarInterno = function(a, b){
    return a + b;
  }
  return somarInterno(arguments[0], arguments[1]);
}

var calcular = function(funcao, a, b){
  return typeof funcao === "function" && funcao(a, b);
}
var funcao = (a, b) => a + b;
console.log(calcular(funcao, 3, 1));

//IIFE http://benalman.com/news/2010/11/immediately-invoked-function-expression/
var resultado = (function(a, b){
  return a * b;
}(2, 3));
console.log(resultado);
