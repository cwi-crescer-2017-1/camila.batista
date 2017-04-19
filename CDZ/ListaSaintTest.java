import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class ListaSaintTest{
    @Test
    public void buscarSaintPorNome(){
        ListaSaint lista = new ListaSaint();
        Saint tyrion = (new Saint(("Tyrion"), new Armadura(new Constelacao("Libra"), Categoria.OURO)));
        
        lista.adicionarSaint(tyrion);
        
        assertEquals(tyrion, lista.buscaPorNome("Tyrion"));
    }
    
    @Test
    public void buscarSaintComRepeticaoNomes(){
        ListaSaint lista = new ListaSaint();
        Saint tyrion = (new Saint(("Tyrion"), new Armadura(new Constelacao("Libra"), Categoria.OURO)));
        Saint tyrion2 = (new Saint(("Tyrion"), new Armadura(new Constelacao("Libra"), Categoria.OURO)));
        
        lista.adicionarSaint(tyrion);
        lista.adicionarSaint(tyrion2);
        
        assertEquals(tyrion, lista.buscaPorNome("Tyrion"));
    }
    
    @Test
    public void buscarSaintInexistente() throws Exception{
        ListaSaint lista = new ListaSaint();
        Saint tyrion = (new Saint(("Tyrion"), new Armadura(new Constelacao("Libra"), Categoria.OURO)));
        
        lista.adicionarSaint(tyrion);
        
        assertNull(lista.buscaPorNome("Tyrion2"));
    }
    
    @Test
    public void buscarSaintEmListaVazia() throws Exception{
        assertNull(new ListaSaint().buscaPorNome("pudim"));
    }
} 