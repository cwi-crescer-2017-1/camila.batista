// function SerieDeTv(nome, anoEstreia){
//   this.nome = nome || 'NI';
//   this.anoEstreia = anoEstreia;
// }
//
// SerieDeTv.prototype.imprimirNome = function(){
//   console.log(this.nome.toUpperCase());
// }

//ECMASCRIPT 2015
class SerieDeTv{
  constructor(nome, anoEstreia){
    this.nome = nome || 'NI';
    this.anoEstreia = anoEstreia;
  }
  imprimirNome(){
    console.log(this.nome.toUpperCase());
  }
}
