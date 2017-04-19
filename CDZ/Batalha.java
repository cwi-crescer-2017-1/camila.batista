public class Batalha{
    private Saint saint1;
    private Saint saint2;
    private double dano = 10;
    
    public Batalha(Saint saint1, Saint saint2){
        this.saint1 = saint1;
        this.saint2 = saint2;
    }
    
    public void iniciar(){
        if((this.saint1.getArmadura().getCategoria().getValor()) >= (this.saint2.getArmadura().getCategoria().getValor())){
            saint2.perderVida(dano);
        }else if((this.saint2.getArmadura().getCategoria().getValor()) > (this.saint1.getArmadura().getCategoria().getValor())){
            saint1.perderVida(dano);
        }
    }
}