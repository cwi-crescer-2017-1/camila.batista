import java.util.ArrayList;
import java.stream.Collect;
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
        
        // EXPRESSAO LAMBDA
        // return this.saints.stream()
            // .filter(s -> s.getNome().equals(nome))
            // .findFirst()
            // .orElse(null);
    }
    
    public ArrayList<Saint> buscarPorCategoria(Categoria categoria){
        ArrayList<Saint> lista2 = new ArrayList<>();
        for(Saint saint : this.saints){
           if(saint.getArmadura().getCategoria().equals(categoria)){
                lista2.add(saint);
            }
        }
        return lista2;
    }
    
    public ArrayList<Saint> buscaPorStatus(Status status){
        return (ArrayList<Saint>) this.saints.stream()
            .filter(s -> s.getStatus().equals(status))
            .collect(Collectors.toList());
    
    }
   
    public Saint getSaintMaiorVida(){
        Saint maiorVida = this.saints.get(0);
        
    }
}