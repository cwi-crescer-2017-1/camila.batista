function arredonda(numero, numCasas){
    return numero.toFixed(2);
}

function arredonda1(numero, numCasas = 2){
  return Math.round(numero * (Math.pow(10, numCasas))) / 100;
}

function arredonda2(numero, numCasas){
  let partes = numero.toString().split(".");

  let tamanho = partes[1].length;

  if(tamanho !== numCasas){
    for(let a = 0; a < partes[1].length; a++){
      for(let b = 0; b < numCasas; b++){

      }
    }
  }
}
