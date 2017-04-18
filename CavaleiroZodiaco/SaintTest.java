import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;  

public class SaintTest 
{
    private double vida;
    
    @Test
    public void vertirTrue_armaduraVestida() throws Exception{
        //  ARRANGE
        Armadura a1 = new Armadura(new Constelacao("Touro"), Categoria.BRONZE);
        Saint s1 = new Saint("Pudim", a1);
        
        //ACT
        s1.vestir();
        
        //ASSERT
        boolean result = s1.isVestida();
        assertEquals(true, result);
    }
    @Test
    public void vestirFalse_armaduraNaoVestida() throws Exception{
        Saint s12 = new Saint ("Pudim", new Armadura(new Constelacao("Touro"),Categoria.OURO));
        assertEquals(false, s12.isVestida());
    }
    
    @Test
    public void aoCriarSaintGenero_generoNaoInformado() throws Exception{
        Saint s13 = new Saint ("Pudim", new Armadura(new Constelacao("Touro"), Categoria.PRATA));
        assertEquals(Genero.NAO_INFORMADO, s13.getGenero());
    }

    @Test
    public void possivelAlterarGenero() throws Exception{
        Saint s33 = new Saint ("Pudim", new Armadura(new Constelacao("Touro"), Categoria.PRATA));
        s33.setGenero(Genero.FEMININO);
        assertEquals(Genero.FEMININO, s33.getGenero());
    }    

    @Test
    public void aoCriarSaintVidaCem() throws Exception{
        Saint s = new Saint ("Alguem", new Armadura(new Constelacao("Touro"), Categoria.PRATA));
        assertEquals(100.0, s.getVida(), 0);        
    }
   
    @Test
    public void iniciarStatusVivo() throws Exception{
        Saint s = new Saint ("Alguem", new Armadura(new Constelacao("Touro"), Categoria.PRATA));
        assertEquals(Status.VIVO, s.getStatus());
    }

    @Test
    public void danoComValor10() throws Exception{
        Saint s = new Saint ("Alguem", new Armadura(new Constelacao("Touro"), Categoria.PRATA));
        s.perderVida(10.);
        assertEquals(90, s.getVida(), 0.001);   
    
    }   

    @Test
    public void perderCemVida() throws Exception{
       Saint s = new Saint ("Alguem", new Armadura(new Constelacao("Touro"), Categoria.PRATA));
        vida = s.getVida();
        s.perderVida(100.0);
        assertEquals((vida - 100.0), s.getVida(), 0);
    }

    @Test
    public void perderVidaNegativa() throws Exception{
        Saint s = new Saint ("Alguem", new Armadura(new Constelacao("Touro"), Categoria.PRATA));
        vida = s.getVida();
        s.perderVida(-100.0);
        assertEquals(s.getVida(), s.getVida(), 0);
    }

    @Test
    public void iniciarSaintCom5SentidosDespertos() throws Exception{
        BronzeSaint s = new BronzeSaint ("Alguem", new Armadura(new Constelacao("Touro"), Categoria.BRONZE));
        assertEquals(5, s.getQtdSentidosDespertos());   
    }

    @Test
    public void saintPrata6Sentidos() throws Exception{
        PrataSaint s = new PrataSaint ("Alguem", new Armadura(new Constelacao("Touro"), Categoria.PRATA));
        assertEquals(6, s.getQtdSentidosDespertos());
    }

    @Test
    public void saintOuro7Sentidos() throws Exception{
        OuroSaint s = new OuroSaint ("Alguem", new Armadura(new Constelacao("Touro"), Categoria.PRATA));
        assertEquals(7, s.getQtdSentidosDespertos());
    }

    @Test(expected = Exception.class)
    public void constelacaoInvalidaDeOuroDeveLancarErro() throws Exception{
        new OuroSaint("Bernardo", new Armadura(new Constelacao ("Café"), Categoria.OURO));

    }
    
    @Test
    public void vidaMenorQue1StatusMorto() throws Exception{
        PrataSaint s = new PrataSaint ("Alguem", new Armadura(new Constelacao("Touro"), Categoria.PRATA));
        s.perderVida(110.);
        assertEquals(Status.MORTO, s.getStatus());
    }
}
