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
      divPok.appendChild(idPok);
      divPok.appendChild(imgPok);
      divPok.appendChild(listaPok);


      json.stats.forEach((e) =>{
        let prog = document.createElement('h4');
        prog.innerText = e.stat.name;
        let progresso = document.createElement('progress');
        progresso.max = 100;
        progresso.value = e.base_stat;

        divPok.appendChild(prog);
        divPok.appendChild(progresso);
      });
    })
  }
});
//
// document.getElementById('labelPesquisar').addEventListener('clicou', function functionName(event) {
//     console.log(event);
// });
