import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CategoriaTest{

    @Test
    public void ouroValor3() throws Exception{
        Saint saga = new OuroSaint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
        assertEquals(3, saga.getArmadura().getCategoria().getValor());
    }
    
    @Test
    public void prataValor2(){
        Saint s1 = new PrataSaint("Pudim", new Armadura(new Constelacao("Touro"), Categoria.PRATA));
        assertEquals(2, s1.getArmadura().getCategoria().getValor());
    }
    
    @Test
    public void bronzeValor1(){
        Saint s1 = new BronzeSaint("Pudim", new Armadura(new Constelacao("Touro"), Categoria.BRONZE));
        assertEquals(1, s1.getArmadura().getCategoria().getValor());
    }
}