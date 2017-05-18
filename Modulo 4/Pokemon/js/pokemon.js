document.addEventListener('DOMContentLoaded', function(){
  let buttonPesquisar = document.getElementById('buttonPesquisar');

  buttonPesquisar.onclick = function() {
	let url = `http://pokeapi.co/api/v2/pokemon/${document.getElementById('numPok').value}/`;
    fetch(url).then(response => response.json())
    .then(json => {

      let divPok = document.getElementById('divPokemon')

      let nomePoK = document.createElement('h2');
      nomePoK.innerText = json.name;


      let imgPok = document.createElement('img');
      imgPok.src = json.sprites.front_default;

      let idPok = document.createElement('h3');
      idPok.innerText = json.id;

      let listaPok = document.createElement('ul');
      json.types.forEach((e) => {
        let liPok = document.createElement('li');
        liPok.innerHTML = e.type.name;
        listaPok.append(liPok);
      });

      divPok.appendChild(nomePoK);
      divPok.appendChild(imgPok);
      divPok.appendChild(idPok);
      divPok.appendChild(listaPok);
    })
  }
});
// 
// document.getElementById('labelPesquisar').addEventListener('clicou', function functionName(event) {
//     console.log(event);
// });
