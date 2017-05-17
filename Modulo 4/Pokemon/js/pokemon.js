document.addEventListener('DOMContentLoaded', function(){
  let numPokemon = document.getElementById('numPok').value;
  let url = 'http://pokeapi.co/api/v2/pokemon/'+ numPokemon;
  let buttonPesquisar = document.getElementById('buttonPesquisar');

  buttonPesquisar.onclick = function() {
    fetch(url).then(response => response.json())
    .then(json => {

      //ESSA COISA NÃO TA FUNCIONANDO
      //Uncaught (in promise) TypeError: Cannot read property 'front_default' of undefined at fetch.then.then.json

      let imgPok = document.createElement('img');
      imgPok.src = json.sprites.front_default;

      let nomePoK = document.createElement('h2');
      nomePoK.innerText = json.name;

      let idPok = document.createElement('h3');
      idPok.innerText = json.id;

      let listaPok = document.createElement('ul');
      json.types.forEach((e) => {
        let liPok = document.createElement('li');
        liPok.innerHTML = e.type.name;
        listaPok.appendChild(e);
      });

    })
  }
});
