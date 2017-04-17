

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class BatalhaTest
{
    private double v;
    
    @Test
    public void categoriaIgual() throws Exception{
        Saint s1 = new Saint("Saint1", new Armadura("A1", Categoria.OURO));
        Saint s2 = new Saint("Saint2", new Armadura("A2", Categoria.OURO));
        
       
        new Batalha(s1, s2).iniciar();
        
        assertEquals(90.0, s2.getVida(), 0.001);
         assertEquals(100.0, s1.getVida(), 0.001);
    }
    
    @Test
    public void maiorContraMenor() throws Exception{
        Saint s11 = new Saint("Saint1", new Armadura("A1", Categoria.OURO));
        Saint s22 = new Saint("Saint2", new Armadura("A2", Categoria.PRATA));
       
        new Batalha(s11, s22).iniciar();
        assertEquals(90.0, s22.getVida(), 0.001);
         assertEquals(100.0, s11.getVida(), 0.001);  
    }
    
    @Test
    public void menorContraMaior() throws Exception{
        Saint s4 = new Saint("Saint1", new Armadura("A1", Categoria.BRONZE));
        Saint s5 = new Saint("Saint2", new Armadura("A2", Categoria.PRATA));
        
        v = s4.getVida();
        new Batalha(s4,s5).iniciar();
        assertEquals((v - 10.0), s4.getVida(), 0.001);
       assertEquals(100.0, s5.getVida(), 0.001); 
    }
}
