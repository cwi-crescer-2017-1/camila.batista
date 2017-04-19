import java.util.ArrayList;
public class Constelacao{
    private String nome;
    private ArrayList<Golpe> golpes = new ArrayList<>();
    
    public Constelacao(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void adicionarGolpe(Golpe golpe){
        this.golpes.add(golpe);
    }
    
    public ArrayList<Golpe> getGolpes(){
        return this.golpes;
    }
    
}
