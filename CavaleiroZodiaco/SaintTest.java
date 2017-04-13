import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;  

public class SaintTest
{
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
}
