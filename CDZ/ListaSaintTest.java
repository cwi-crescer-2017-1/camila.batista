import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class ListaSaintTest{
    
    private ArrayList<Saint> lista = new ArrayList<>();
    @Test
    public void saintCorreto(){
        Saint saga = new Saint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
        
        this.lista.adicionarSaint(saga);
        
        assertEquals(this.saga, this.lista.get(0));
    }
    
}