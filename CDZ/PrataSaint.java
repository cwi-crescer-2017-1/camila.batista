public class PrataSaint extends Saint{
    
    public PrataSaint(String nome, String constelacao){
        super(nome, new Armadura (new Constelacao(constelacao), Categoria.PRATA));
        this.qtdSentidosDespertos = 6;
    }
}
