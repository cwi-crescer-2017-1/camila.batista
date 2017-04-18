import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;  
import java.security.InvalidParameterException;

public class SaintTest 
{
    private double vida;
    
    @Test
    public void vertirTrue_armaduraVestida() throws Exception{
        //  ARRANGE
        Armadura a1 = new Armadura(new Constelacao ("Touro"), Categoria.BRONZE);
        Saint s1 = new Saint("Pudim", a1);
        
        //ACT
        s1.vestir();
        
        //ASSERT
        boolean result = s1.isVestida();
        assertEquals(true, result);
    }
    @Test
    public void vestirFalse_armaduraNaoVestida() throws Exception{
        Saint s12 = new Saint ("Pudim", new Armadura(new Constelacao ("Touro"), Categoria.OURO));
        assertEquals(false, s12.isVestida());
    }
    
    @Test
    public void aoCriarSaintGenero_generoNaoInformado() throws Exception{
        Saint s13 = new Saint ("Pudim", new Armadura(new Constelacao ("Touro"), Categoria.PRATA));
        assertEquals(Genero.NAO_INFORMADO, s13.getGenero());
    }

    @Test
    public void possivelAlterarGenero() throws Exception{
        Saint s33 = new Saint ("Pudim", new Armadura(new Constelacao ("Touro"), Categoria.PRATA));
        s33.setGenero(Genero.FEMININO);
        assertEquals(Genero.FEMININO, s33.getGenero());
    }    

    @Test
    public void aoCriarSaintVidaCem() throws Exception{
        Saint s = new Saint ("Alguem", new Armadura(new Constelacao ("Touro"), Categoria.PRATA));
        assertEquals(100.0, s.getVida(), 0);        
    }
   
    @Test
    public void iniciarStatusVivo() throws Exception{
        Saint s = new Saint ("Alguem", new Armadura(new Constelacao ("Touro"), Categoria.PRATA));
        assertEquals(Status.VIVO, s.getStatus());
    }

    @Test
    public void danoComValor10() throws Exception{
        Saint s = new Saint ("Alguem", new Armadura(new Constelacao ("Touro"), Categoria.PRATA));
        s.perderVida(10.);
        assertEquals(90, s.getVida(), 0.001);   
    
    }   

    @Test
    public void perderCemVida() throws Exception{
       Saint s = new Saint ("Alguem", new Armadura(new Constelacao ("Touro"), Categoria.PRATA));
        vida = s.getVida();
        s.perderVida(100.0);
        assertEquals(0, s.getVida(), 0);
    }

    @Test(expected=InvalidParameterException.class)
    public void perderVidaNegativa() throws Exception{
        Saint s = new Saint ("Alguem", new Armadura(new Constelacao ("Touro"), Categoria.PRATA));
        s.perderVida(-100.0);
        assertEquals(s.getVida(), s.getVida(), 0);
    }

    @Test
    public void iniciarSaintCom5SentidosDespertos() throws Exception{
        BronzeSaint s = new BronzeSaint ("Alguem", new Armadura(new Constelacao ("Touro"), Categoria.BRONZE));
        assertEquals(5, s.getQtdSentidosDespertos());   
    }

    @Test
    public void saintPrata6Sentidos() throws Exception{
        PrataSaint s = new PrataSaint ("Alguem", new Armadura(new Constelacao ("Touro"), Categoria.PRATA));
        assertEquals(6, s.getQtdSentidosDespertos());
    }

    @Test
    public void saintOuro7Sentidos() throws Exception{
        OuroSaint s = new OuroSaint ("Alguem", new Armadura(new Constelacao ("Touro"), Categoria.PRATA));
        assertEquals(7, s.getQtdSentidosDespertos());
    }

    @Test(expected = Exception.class)
    public void constelacaoInvalidaDeOuroDeveLancarErro() throws Exception{
        new OuroSaint("Bernardo", new Armadura(new Constelacao ("Café"), Categoria.OURO));

    }
    @Test
    public void aprenderGolpe() throws Exception{
        Saint saga = new Saint("Saga", new Armadura (new Constelacao("Gemeos"), Categoria.PRATA));
        Constelacao gemeos = new Constelacao ("Gêmeos");
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        gemeos.adicionarGolpe(outraDimensao);
        saga.aprenderGolpe(outraDimensao);
        Golpe[] golpes = gemeos.getGolpes();
        
        assertEquals(outraDimensao, golpes[0]);
        assertNull(golpes[1]);
        assertNull(golpes[2]);
        
    }
    
    @Test
    public void aprender2Golpes(){
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
    public void aprender3Golpes(){
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
