[2, 3, 1].forEach(function(a, b){console.log(a,b)});

// [6, 5, 4].forEach(a, b) =>


//Seleciona um seletor
//document.querySelector('h1')
//document.querySelectorAll('h1')

//h1.innerText
//Date().toLocaleString() > pega a data com o locale da máquina

//Atualiza  a hora a partir de um intervalo
var h1 = document.querySelectorAll('h1');
var atualizaHora = () => {h1.innerText = new Date().toLocaleString()}
var intervalo = setInterval(atualizaHora, 1000); // 1000 > intervalo
//clearInterval(intervalo);
