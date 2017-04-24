import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GolpearTest{
    
    @Test
    public void golpeadorBronzeSemArmadura(){
        Golpe soco = new Golpe("Soco", 10);
        
        Saint misty = new BronzeSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        misty.getArmadura().getConstelacao().adicionarGolpe(soco);
        
        Golpear g = new Golpear(misty, shun);
        g.executar();
        
        assertEquals(100, misty.getVida(), 0.001);
        assertEquals(90, shun.getVida(), 0.001);
    }
    
    @Test
    public void golpeadorOuroSemArmadura() throws Exception{
        Golpe soco = new Golpe("Soco", 10);
        
        Saint misty = new OuroSaint("Misty", "Libra");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        misty.getArmadura().getConstelacao().adicionarGolpe(soco);
        
        Golpear g = new Golpear(misty, shun);
        g.executar();
        
        assertEquals(100, misty.getVida(), 0.001);
        assertEquals(90, shun.getVida(), 0.001);
    }

    @Test
    public void golpeadorPrataSemArmadura(){
        Golpe soco = new Golpe("Soco", 10);
        
        Saint misty = new PrataSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        misty.getArmadura().getConstelacao().adicionarGolpe(soco);
        
        Golpear g = new Golpear(misty, shun);
        g.executar();
        
        assertEquals(100, misty.getVida(), 0.001);
        assertEquals(90, shun.getVida(), 0.001);
    }
    
    @Test
    public void golpeadorBronzeComArmadura(){
        Golpe soco = new Golpe("Soco", 10);
        
        Saint misty = new BronzeSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        misty.vestir();
        misty.getArmadura().getConstelacao().adicionarGolpe(soco);
        
        Golpear g = new Golpear(misty, shun);
        g.executar();
        
        assertEquals(100, misty.getVida(), 0.001);
        assertEquals(80, shun.getVida(), 0.001);
    }
    
    @Test
    public void golpeadorOuroComArmadura() throws Exception{
        Golpe soco = new Golpe("Soco", 10);
        
        Saint misty = new OuroSaint("Misty", "Touro");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        misty.vestir();
        misty.getArmadura().getConstelacao().adicionarGolpe(soco);
        
        Golpear g = new Golpear(misty, shun);
        g.executar();
        
        assertEquals(100, misty.getVida(), 0.001);
        assertEquals(60, shun.getVida(), 0.001);
    }
    
    @Test
    public void golpeadorPrataComArmadura(){
        Golpe soco = new Golpe("Soco", 10);
        
        Saint misty = new PrataSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        misty.vestir();
        misty.getArmadura().getConstelacao().adicionarGolpe(soco);
        
        Golpear g = new Golpear(misty, shun);
        g.executar();
        
        assertEquals(100, misty.getVida(), 0.001);
        assertEquals(70, shun.getVida(), 0.001);
    }
}