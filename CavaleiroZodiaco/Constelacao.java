public class Constelacao{
    private String nomeConstelacao;
    private int golpes[];
    
    public Constelacao(String nomeConstelacao){
        this.nomeConstelacao = nomeConstelacao;
    }
    
    public void adicionarGolpe(int golpe){
        this.golpes = new int [golpe];
    }
    
    public String getConstelacao(){
        return this.nomeConstelacao;
    }
    
}