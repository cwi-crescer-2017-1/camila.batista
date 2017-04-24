public class Batalha{
    private Saint saint1;
    private Saint saint2;
    private double dano = 10;
    
    public Batalha(Saint saint1, Saint saint2){
        this.saint1 = saint1;
        this.saint2 = saint2;
    }
    
    public void iniciar(){
        Movimento mov;
        Saint ataca = saint1;;
        Saint ataca2 = saint2;
        
        if((this.saint1.getArmadura().getCategoria().getValor()) >= (this.saint2.getArmadura().getCategoria().getValor())){
            ataca = this.saint1;
            ataca2 = this.saint2;
        }else{
            ataca = this.saint2;
            ataca2 = this.saint1;
        }
        
        while(saint1.getStatus().equals(Status.VIVO) || saint2.getStatus().equals(Status.VIVO)){
            mov = ataca.getProximoMovimento();
            mov.executar();
            
            if(ataca2.getStatus().equals(Status.VIVO)){
                mov = ataca2.getProximoMovimento();
                mov.executar();
            }
            
            if(ataca.getStatus().equals(Status.MORTO) || (ataca2.getStatus().equals(Status.MORTO))){
                break;
            }
        }    
   }
}