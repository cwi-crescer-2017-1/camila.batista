

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConstelacaoTest{
    @Test
    public void adicionarUmGolpe() {
       Constelacao gemeos = new Constelacao("Gemeos");
       
       Golpe g1 = new Golpe("Golpe 1", 10);
       gemeos.adicionarGolpe(g1);
       
       assertEquals(g1, gemeos.getGolpes().get(0));
       assertEquals(1, gemeos.getGolpes().size());
    }

    @Test
    public void adicionarDoisGolpes() {
       Constelacao gemeos = new Constelacao("Gemeos");
       
       Golpe g1 = new Golpe("Golpe 1", 10);
       gemeos.adicionarGolpe(g1);
       Golpe g2 = new Golpe("Golpe 2", 10);
       gemeos.adicionarGolpe(g2);
       
       assertEquals(g1, gemeos.getGolpes().get(0));
       assertEquals(g2, gemeos.getGolpes().get(1));
       assertEquals(2, gemeos.getGolpes().size());
    }

    @Test
    public void adicionarTresGolpes() {
       Constelacao gemeos = new Constelacao("Gemeos");
       
       Golpe g1 = new Golpe("Golpe 1", 10);
       gemeos.adicionarGolpe(g1);
       Golpe g2 = new Golpe("Golpe 2", 10);
       gemeos.adicionarGolpe(g2);
       Golpe g3 = new Golpe("Golpe 3", 10);
       gemeos.adicionarGolpe(g3);
       
       assertEquals(g1, gemeos.getGolpes().get(0));
       assertEquals(g2, gemeos.getGolpes().get(1));
       assertEquals(g3, gemeos.getGolpes().get(2));
       assertEquals(3, gemeos.getGolpes().size());
    }

    
}