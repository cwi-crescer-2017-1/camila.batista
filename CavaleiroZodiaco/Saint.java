public class Saint{
    private String nome;
    private Armadura armadura;
    
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
  
}