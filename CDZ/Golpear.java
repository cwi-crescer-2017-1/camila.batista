public class Golpear implements Movimento{
    
    public Golpear(Saint golpeador, Saint golpeado){
        if(golpeador.isVestida()){
            golpeado.perderVida((golpeador.getProximoGolpe().getFatorDano()) * (1 + golpeador.getArmadura().getCategoria().getValor()));
        }else{
            golpeado.perderVida(golpeador.getProximoGolpe().getFatorDano());
        }
    }
    
    public void executar(){}
}