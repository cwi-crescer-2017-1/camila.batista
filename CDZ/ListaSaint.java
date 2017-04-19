import java.util.ArrayList;
public class ListaSaint{
    private ArrayList<Saint> saints = new ArrayList<Saint>();
    
    public void adicionarSaint(Saint saint){
        this.saints.add(saint);
    }

    public Saint get(int indice){
        return this.saints.get(indice);
    }
    
    public ArrayList<Saint> todos(){
        return this.saints;
    }
    
    public void remover(Saint saint){
        this.saints.remove(saint);
    }
    
    public Saint buscaPorNome(String nome){
        for(Saint saint : this.saints){
            if(saint.getNome().equals(nome)){
                return saint;
            }
        }
        return null;
    }
}