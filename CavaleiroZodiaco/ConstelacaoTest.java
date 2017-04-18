import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class ConstelacaoTest
{
    @Test
    public void adicionar1Golpe(){
        Constelacao gemeos = new Constelacao ("Gêmeos");
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        gemeos.adicionarGolpe(outraDimensao);
        
        Golpe[] golpes = gemeos.getGolpes();
        
        assertEquals(outraDimensao, golpes[0]);
        assertNull(golpes[1]);
        assertNull(golpes[2]);
        
    }
    
    @Test
    public void adicionar2Golpes(){
        Constelacao gemeos = new Constelacao ("Gêmeos");
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        gemeos.adicionarGolpe(outraDimensao);
        Golpe explosaoGalatica = new Golpe("Explosao Galatica", 10);
        gemeos.adicionarGolpe(explosaoGalatica);
        
        Golpe[] golpes = gemeos.getGolpes();
        
        assertEquals(explosaoGalatica, golpes[1]);
        assertEquals(outraDimensao, golpes[0]);
        
        assertNull(golpes[2]);
    }
    
    @Test
    public void adicionar3Golpes(){
         Constelacao gemeos = new Constelacao ("Gêmeos");
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        gemeos.adicionarGolpe(outraDimensao);
        Golpe explosaoGalatica = new Golpe("Explosao Galatica", 10);
        gemeos.adicionarGolpe(explosaoGalatica);
        Golpe sataImperial = new Golpe("Sata Imperial", 10);
        gemeos.adicionarGolpe(sataImperial);
        
        Golpe[] golpes = gemeos.getGolpes();
        
        assertEquals(sataImperial, golpes[2]);
        assertEquals(explosaoGalatica, golpes[1]);
        assertEquals(outraDimensao, golpes[0]);

    }
    
    
    
}
