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
        Saint saint1;;
        Saint saint2;
       
        Saint ataca = null;
        if((this.saint1.getArmadura().getCategoria().getValor()) >= (this.saint2.getArmadura().getCategoria().getValor())){
            ataca = this.saint1;
            this.saint2.perderVida(dano);
        }else{
            ataca = this.saint2;
            this.saint1.perderVida(dano);
        }
        
        boolean morto = true;
        
        do{
            ataca = ataca == this.saint1 ? this.saint2 : this.saint1;
            
            mov = ataca.getProximoMovimento();
            mov.executar();
            morto = this.saint1.getStatus() != (Status.MORTO) && this.saint2.getStatus() != (Status.MORTO);
        }while(morto);    
   }
}