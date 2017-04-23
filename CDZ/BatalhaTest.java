

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BatalhaTest{

    @Test
    public void maiorContraMenor(){
        Saint s1 = new PrataSaint("Pudim", "Touro");
        Saint s2 = new BronzeSaint("Pudim", "Touro");
        
        new Batalha(s1, s2).iniciar();
        
        assertEquals(100, s1.getVida(), 0.001);
        assertEquals(90., s2.getVida(), 0.001);
        
    }
    
    @Test
    public void menorContraMaior(){
        Saint s1 = new PrataSaint("Pudim", "Touro");
        Saint s2 = new BronzeSaint("Pudim", "Touro");
        
        new Batalha(s2, s1).iniciar();
        
        assertEquals(100, s1.getVida(), 0.001);
        assertEquals(90, s2.getVida(), 0.001);
    }
    
    @Test
    public void oponentesIguais(){
        Saint s1 = new PrataSaint("Pudim", "Touro");
        Saint s2 = new PrataSaint("Pudim", "Touro");
        
        new Batalha(s1, s2).iniciar();
        
        assertEquals(90, s2.getVida(), 0.001);
        assertEquals(100, s1.getVida(), 0.001);
    }
    
}
