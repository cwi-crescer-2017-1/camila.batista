//exercicio 1
function daisyGame(a){
  if(a % 2 == 0){
    return "Love me not";
  }else{
    return "Love me";
  }
}
//   console.log(daisyGame(2));
//   console.log(daisyGame(3));

  //return numero % 2 == 0 ? 'Love me not' : 'Love me';

    //ECMASCRIPT 2015
  //return `Love me ${ numero % 2 !== 0 ? ' ' : ' not'}`


//Exercício 2
function maiorTexto(array){
  var a = "";
  for(let i = 0; i < array.length; i++){
    if(typeof array[i] === "string"){
      if(array[i].length > a.length){
        a = array[i];
      }
    }
  }
  return a;
}

// var array = ["oi", "ssss", "vvf0", "lalala"];
// console.log(maiorTexto(array));

//Exercício 3
function imprime(array, funcao){
  if(typeof funcao === "function"){
    for(a of array){
      funcao(a);
    }
  }
}
//array.forEach(funcao)

//Exercício 4
function somar(a){
  return function (b){
    return a + b;
  }
}

//Exercício 5
function fiboSum(x) {
  var a = 0;
  var b = 1;
  var c = 1;
  var soma = 1;
  for(let i = 1; i < x; i++){
    c = a + b;

    a = b;
    b = c;
    soma += c;
  }
  return soma;
}

//--- Recursivo ---

function fibonacci(valor){
  if(valor === 1 || valor === 2){
    return 1;
  }
  return fibonacci(valor - 1) + fibonacci(valor - 2);
}

function fiboSumRecursivo(valor){
  if(valor === 1){
    return 1;
  }
  return fibonacci(valor) + fiboSumRecursivo(valor - 1);
}

//Exercício 6
function queroCafe(mascada, precos) {
  // let valor = [];
  // precos.forEach(p => {
  //   if(p <= mascada){
  //     valor.push(p);
  //   }
  //return valor.sort((a, b) => a-b).join(', ');
  //});

    //ECMASCRIPT 2015
    return precos
      .filter((a) => a <= mascada)
      .sort((a,b) => a-b)
      .join(', ');

}
