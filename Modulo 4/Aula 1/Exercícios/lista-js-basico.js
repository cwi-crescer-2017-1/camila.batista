//exercicio 1
function daisyGame(a){
  if(a % 2 == 0){
    console.log("Love me not");
  }else{
    console.log("Love me");
  }
}
//
// console.log(daisyGame(1));
// console.log(daisyGame(2));
// console.log(daisyGame(3));
// console.log(daisyGame(4));
// console.log(daisyGame(5));


//Exercício 2
function maiorTexto(array){
  var a = "";
  for(var i = 0; i < array.length; i++){
    if(array[i].length > a.length){
      a = array[i];
    }
  }
  return a;
}

// var array = ["oi", "ssss", "vvf0", "lalala"];
// console.log(maiorTexto(array));

//Exercício 3
function imprime(array, funcao){
  if(typeof funcao != "function"){
    return;
  }
  for(var a = 0; a < array.length; a++){
    funcao(array[a]);
  }
}
