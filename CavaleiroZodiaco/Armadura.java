public class Armadura{
    private String constelacao;
    private Categoria categoria;
    //Se o valor do enum for declarado desta forma, o valor é instanciado quando a variavel é declarada
    
    public Armadura(){}
    public Armadura(String constelacao, Categoria categoria){
        this.constelacao = constelacao;    
        //this.categoria = Categoria.OURO;
        this.categoria = categoria;
    }
    
    
    
}