public class SorteDoDia{
    private Sorteador sorteador; 
    
    public SorteDoDia(Sorteador sorteador){
        this.sorteador = sorteador;
    }
    
    public boolean estouComSorte(){
        int result = this.sorteador.sortear();
        return result % 2 == 0;
        
    }
}