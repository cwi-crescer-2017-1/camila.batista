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
        Saint s1 = new Saint ("Pudim", new Armadura("Escorpião", Categoria.OURO));
        assertEquals(false, s1.isVestida());
    }
    
    @Test
    public void aoCriarSaintGenero_generoNaoInformado(){
        Saint s1 = new Saint ("Pudim", new Armadura("Peixe", Categoria.PRATA), Genero.NAO_INFORMADO);
        assertEquals(Genero.NAO_INFORMADO, s1.getGenero());
    }
}
