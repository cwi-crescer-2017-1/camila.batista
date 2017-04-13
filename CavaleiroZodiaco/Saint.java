public class Saint{
    private String nome;
    private Armadura armadura;
    private Genero genero = Genero.NAO_INFORMADO;
    private boolean vestida;
    
    
    
    public void vestir(){
        this.vestida = true;
    }
    
    public Saint(){}
    public Saint(String nome, Armadura armadura){
        this.nome = nome;
        this.armadura = armadura;
    }
    
    public boolean isVestida(){
        return this.vestida;
    }
    public void setVestida(boolean vestida){
        this.vestida = vestida;
    }
  
    public Genero getGenero(){
        return this.genero;
    }
    public void setGenero(Genero genero){
        this.genero = genero;
    }
}