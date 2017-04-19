import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CategoriaTest{

    @Test
    public void ouroValor3(){
        Saint s1 = new Saint("Pudim", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        assertEquals(3, s1.getArmadura().getCategoria().getValor());
    }
    
    @Test
    public void prataValor2(){
        Saint s1 = new Saint("Pudim", new Armadura(new Constelacao("Touro"), Categoria.PRATA));
        assertEquals(2, s1.getArmadura().getCategoria().getValor());
    }
    
    @Test
    public void bronzeValor1(){
        Saint s1 = new Saint("Pudim", new Armadura(new Constelacao("Touro"), Categoria.BRONZE));
        assertEquals(1, s1.getArmadura().getCategoria().getValor());
    }
}