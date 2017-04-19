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
    
   @Test
    public void buscarPorCategoriaListaVazia() {
        ListaSaint listaSaints = new ListaSaint();
        ArrayList<Saint> resultadoBusca = listaSaints.buscarPorCategoria(Categoria.BRONZE);
        assertEquals(new ArrayList<Saint>(), resultadoBusca);
    }

    @Test
    public void buscarPorCategoriaInexistente() throws Exception {
        ListaSaint listaSaints = new ListaSaint();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        listaSaints.adicionarSaint(june);
        ArrayList<Saint> resultadoBusca = listaSaints.buscarPorCategoria(Categoria.PRATA);
        assertEquals(new ArrayList<Saint>(), resultadoBusca);
    }

    @Test
    public void buscarPorCategoriaExistente() throws Exception {
        ListaSaint listaSaints = new ListaSaint();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        Saint misty = new PrataSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA));
        listaSaints.adicionarSaint(misty);
        listaSaints.adicionarSaint(june);
        ArrayList<Saint> resultadoBusca = listaSaints.buscarPorCategoria(Categoria.BRONZE);
        assertEquals(june, resultadoBusca.get(0));
        assertEquals(1, resultadoBusca.size());
    }

    @Test
    public void buscarPorCategoriaComMaisDeUmExistenteNaCategoria() throws Exception {
        ListaSaint listaSaint = new ListaSaint();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        Saint misty = new PrataSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA));
        Saint shun = new Saint("June", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE));
        listaSaint.adicionarSaint(shun);
        listaSaint.adicionarSaint(misty);
        listaSaint.adicionarSaint(june);
        ArrayList<Saint> resultadoBusca = listaSaint.buscarPorCategoria(Categoria.BRONZE);
        assertEquals(shun, resultadoBusca.get(0));
        assertEquals(june, resultadoBusca.get(1));
        assertEquals(2, resultadoBusca.size());
    }
} 