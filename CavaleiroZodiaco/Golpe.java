public class Golpe{
    private String nomeGolpe;
    private int fatorDano;
    
    public boolean equals(Object object){
        Golpe outroGolpe = (Golpe) object;
        return this.nomeGolpe.equals(outroGolpe.getNomeGolpe()) && this.fatorDano == outroGolpe.getFatorDano();
    }
    
    public Golpe(String nomeGolpe, int fatorDano){
        this.nomeGolpe = nomeGolpe;
        this.fatorDano = fatorDano;
    }
    
    public String getNomeGolpe(){
        return this.nomeGolpe;
    }
    public int getFatorDano(){
        return this.fatorDano = fatorDano;
    }
}