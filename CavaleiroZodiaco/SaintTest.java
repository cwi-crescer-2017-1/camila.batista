import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;  

public class SaintTest
{
    Saint s = new Saint ("Alguem", new Armadura("Alguma", Categoria.PRATA));
    private double vida;
    
    @Test
    public void vertirTrue_armaduraVestida(){
        //  ARRANGE
        Armadura a1 = new Armadura("Libra", Categoria.BRONZE);
        Saint s1 = new Saint("Pudim", a1);
        
        //ACT
        s1.vestir();
        
        //ASSERT
        boolean result = s1.isVestida();
        assertEquals(true, result);
    }
    @Test
    public void vestirFalse_armaduraNaoVestida(){
        Saint s12 = new Saint ("Pudim", new Armadura("Escorpião", Categoria.OURO));
        assertEquals(false, s12.isVestida());
    }
    
    @Test
    public void aoCriarSaintGenero_generoNaoInformado(){
        Saint s13 = new Saint ("Pudim", new Armadura("Peixe", Categoria.PRATA));
        assertEquals(Genero.NAO_INFORMADO, s13.getGenero());
    }

	@Test
	public void possivelAlterarGenero(){
	    Saint s33 = new Saint ("Pudim", new Armadura("Peixe", Categoria.PRATA));
		s33.setGenero(Genero.FEMININO);
		assertEquals(Genero.FEMININO, s33.getGenero());
	}    

    @Test
    public void aoCriarSaintVidaCem(){
        assertEquals(100.0, s.getVida(), 0);        
    }
   
    @Test
    public void iniciarStatusVivo(){
        assertEquals(Status.VIVO, s.getStatus());
    }

	@Test
	public void danoComValor10(){
		s.perderVida(10.);
		assertEquals(90, s.getVida(), 0.001);   
	
	}   

    @Test
    public void perderCemVida(){
        vida = s.getVida();
        s.perderVida(100.0);
        assertEquals((vida - 100.0), s.getVida(), 0);
    }

    @Test
    public void perderVidaNegativa(){
        vida = s.getVida();
        s.perderVida(-100.0);
        assertEquals((vida + 100.0), s.getVida(), 0);
    }
}
