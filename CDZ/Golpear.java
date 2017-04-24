public class Golpear implements Movimento{

    private Saint golpeado, golpeador;
    
    public Golpear(Saint golpeador, Saint golpeado){
        this.golpeado = golpeado;
        this.golpeador = golpeador;
    }
    
    public void executar(){
        if(golpeador.isVestida()){
            golpeado.perderVida((golpeador.getProximoGolpe().getFatorDano()) * (1 + golpeador.getArmadura().getCategoria().getValor()));
        }else{
            golpeado.perderVida(golpeador.getProximoGolpe().getFatorDano());
        }

    }

	public boolean equals(Object outro){
		Golpear outroGolpe = (Golpear)outro;
		return this.golpeador.equals(outroGolpe.golpeador) && this.golpeado.equals(outroGolpe.golpeado);
	}
}