import java.util.ArrayList;
import java.util.stream.Collectors;

public class ListaSaint{
    private ArrayList<Saint> saints = new ArrayList<>();
    
    public ListaSaint(){}
    
    public void adicionaSaint(Saint saint){
        this.saints.add(saint);
    }
    
    public ArrayList<Saint> getListaSaint(){
        return this.saints;
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

    public ArrayList<Saint> buscaPorCategoria(Categoria Categoria){
        return (ArrayList<Saint>) this.saints.stream()
            .filter(s -> s.getArmadura().getCategoria().equals(Categoria))
            .collect(Collectors.toList());
    }

    public ArrayList<Saint> buscaPorStatus(Status Status){
        return (ArrayList<Saint>) this.saints.stream()
            .filter(s -> s.getStatus().equals(Status))
            .collect(Collectors.toList());
    }

    public Saint getSaintMaiorVida(){
        if(saints.isEmpty()){
            return null;
        }
        Saint mVida = saints.get(0);
        for(int a = 1; a < this.saints.size(); a++){
            Saint saint  = this.saints.get(a);
            boolean maior = saint.getVida() > mVida.getVida();

            if(maior){
                mVida = saint;
            }
        }
        return mVida;
    }

    public Saint getSaintMenorVida(){
        if(saints.isEmpty()){
            return null;
        }
        int a = 1;
        Saint mVida = this.saints.get(0);
        while(a < this.saints.size()){
            a++;
            Saint saint = this.saints.get(a);
            boolean menor = saint.getVida() < mVida.getVida();

            if(menor){
                mVida = saint;
            }
        }
        return mVida;
    }

    public void ordenar(){
        this.ordenar(TipoOrdenacao.ASCENDENTE);
    }
    public void ordenar(TipoOrdenacao tipoOrdenacao){

            boolean posicao;
            do{
                posicao = false;
                //for(int a = this.saints.size()-1; a >=0; a--)
                for(int a = 0; a < this.saints.size()-1; a++){
                    Saint atual = this.saints.get(a);
                    Saint proximo = this.saints.get(a+1);
                    
                    boolean tipo = tipoOrdenacao == tipoOrdenacao.ASCENDENTE ? (atual.getVida() > proximo.getVida()) : (atual.getVida() < proximo.getVida());
                    if(tipo){
                        this.saints.set(a, proximo);
                        this.saints.set(a+1, atual);
                        posicao = true;
                    }
                }
            }while(posicao);
       }
   
    public ListaSaint unir(ListaSaint lista){
        ListaSaint resultado = new ListaSaint();
        
        for(Saint saint : this.saints){
            resultado.adicionaSaint(saint);
        }       
        for(Saint saint : lista.todos()){
            resultado.adicionaSaint(saint);
        }

        return resultado;
    }
    
    public ListaSaint diff (ListaSaint lista){
        ListaSaint resultado = new ListaSaint();
        
        for(int a=0; a < this.saints.size(); a++){
            resultado.adicionaSaint(this.saints.get(a));
        }
        
        for(Saint saint : this.saints){
                for(int a = 0; a < lista.todos().size(); a++){
                    if(saints.equals(lista) || lista.equals(saints)){
                        resultado.remover(lista.getListaSaint().get(a));
                    }
                }
            }
        
        return resultado;
    }
    
    public ListaSaint intersec (ListaSaint lista){
        ListaSaint resultado = new ListaSaint();
        
        for(Saint saint : this.saints){
            for(Saint saint1 : lista.todos()){
                if(saints.equals(lista)){
                    resultado.adicionaSaint(saint);;
                }
            }
        }

        return resultado;
    }
}
