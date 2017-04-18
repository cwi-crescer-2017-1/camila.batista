import java.util.ArrayList;
public class Constelacao{
    private String nomeConstelacao;
    private ArrayList<Integer> golpes = new ArrayList<>();
    
    public Constelacao(String nomeConstelacao){
        this.nomeConstelacao = nomeConstelacao;
    }
    
    public void adicionarGolpe(Golpe golpe){
        for(int a = 0; a < this.golpes.size(); a++){
            Golpe ff = get(a);
            if(ff == null){
                get(a) = golpe;
                break;
            }
        }
    }
    
    public String getConstelacao(){
        return this.nomeConstelacao;
    }
    
    public Golpe[] getGolpes(){
        return this.golpes;
    }
}