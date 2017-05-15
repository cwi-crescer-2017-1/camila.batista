// Exercício 1
//
// Séries Inválidas
//
// Nesse exercício deverá ser implementada uma função chamada seriesInvalidas(series) que recebe o array de séries, verifica quais são as séries inválidas e retorna o título das séries inválidas em formato String.
//
// Exemplo:
//
// seriesInvalidas(series); // retorna "Séries Inválidas: Série 1 - Série 2 ..."
// Condições para as séries serem inválidas:
//
// Ano de estreia maior que o ano atual;
// Possuir algum campo que seja undefined ou null.

function seriesInvalidas(series){
  var anoAtual = (new Date()).getFullYear();
  var seriesInvalidas = [];

  for(let s of series){
    var itens = Object.values(s);

    for(item of itens){
      if((typeof item === 'undefined' || item === null) || s.anoEstreia > anoAtual){
        seriesInvalidas.push(s.titulo);
      }
    }

  }
  return seriesInvalidas.join(' - ');
}

// Exercício 2
//
// Séries a partir de um determinado ano
//
// Nesse exercício deverá ser implementada uma função chamada filtrarSeriesPorAno(series, ano) que recebe o array de séries e devolve um outro array contendo apenas as séries com ano maior ou igual ao ano passado por parâmetro.

function filtrarSeriesPorAno(series, ano){
  return series.filter((s) => s.anoEstreia >= ano);
}

// Exercício 3
//
// Média de Episódios
//
// Crie uma função chamada mediaDeEpisodios(series) que recebe o array de séres e retorna a média dos episódios de todas as séries contidas no array.

function mediaDeEpisodios(series){
  let soma = 0;
  series.forEach((s) => soma+=s.numeroEpisodios);
  return soma / series.length;
}

// Exercício 4
//
// Eu sou um ator de séries?
//
// Crie uma função chamada procurarPorNome(series, nome) que recebe um array de séries e um nome e caso esse nome possua no elenco das séries, retorna true.

function procurarPorNome(series, nome){
  let nn = false;
  for(let s of series){
    for(let n of s.elenco){
      if(n.includes(nome)){
        nn = true;
        break;
      }
    }
  }
  return nn;
}

// Exercício 5
//
// Mascada em Série
//
// Uma série tem seu elenco e diretor(es), mas para ela acontecer, eles devem ser pagos. Crie uma função chamada mascadaEmSerie que retornará o valor total do salário a ser pago por mês para determinada série. Para isso, suponha que os Big-Bosses, os Diretores, ganhem R$ 100.000; Enquanto os operarios os peões o pessoal do elenco ganha R$ 40.000;

function mascadaEmSerie(series){
  let numDiretores = series.diretor.length;
  let numElenco = series.elenco.length;
  return (numDiretores * 100000) + (numElenco * 40000);
}

// Exercício 6
//
// Buscas!
//
// A) Não sei o que quero assitir, mas quero ver CAOS! Escreva uma função chamada queroGenero que retorne um array, com os títulos das séries que são correspondentes com o genero do parâmetro.

function queroGenero(genero){
  let arraySerie = new Array();
  for(s of series){
    for(g of s.genero){
      if(g.toLowerCase() === genero.toLowerCase()){
        arraySerie.push(s.titulo);
      }
    }
  }
  return arraySerie;
}

// B) Sei exatamente o que quero assisitir! Escreva uma função chamada queroTitulo que retorne um array, com os títulos das séries que tem título semelhante ao passado

function queroTitulo(titulo){
  let arraySerie = new Array();
  for(s of series){
    if(s.titulo.toLowerCase().includes(titulo.toLowerCase())){
      arraySerie.push(s.titulo);
    }
  }
  return arraySerie;
}

// Exercício 7
//
// Créditos
//
// Ao final de um episódio, temos os créditos do episódio. Para isso vamos implementar uma função, chamada de creditosIlluminatis que recebe uma série como parâmetro e imprima os créditos a partir dela. Deverá ser impresso, o Título da serie, os Diretores, avisando com um título que é o bloco deles. Em seguida vem o elenco, também com um título de Elenco.
//
// Tranquilo né? Easy! MAS, tem o seguinte: Os créditos são sempre ordenados alfabeticamente, mas pelo ÚLTIMO NOME!! Faça os ajustes necessários para que isso seja possível.


// Exercício 8 - Serie Illuminati
//
// Escondemos um pequeno easter egg neste exercicio!
//
// Para que ele seja descoberto, será necessário algumas informações; Quando abreviamos um nome colocamos a primeira letra do nome seguida de um ponto final
//
// Exemplo:
// Bernardo Bosak Rezende -> Bernardo B. Rezende
// Augusto Schiller Wartchow -> Augusto S. Wartchow
//
// Essa é a informação básica! Construa uma função que identificará aquela série que tem TODOS do elenco com nomes abreviados.
//
// Dica: Construa uma função separada para identificar se aquela String tem a abreviação;
//
// Show de bola, estamos quase lá!
//
// Uma vez achada a série, vamos modificar um pouquinho a implementação. Coloque todas as palavras abreviadas (de preferência sem os pontos finais) em uma string que será retornada ao final do método.
// Forme uma hashtag com a palavra! #PALAVRA
