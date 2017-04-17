

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class CategoriaTest
{
    @Test
    public void categoriaComValorCerto(){
        assertEquals(1, Categoria.BRONZE.getValor());
        assertEquals(2, Categoria.PRATA.getValor());
        assertEquals(3, Categoria.OURO.getValor());
        
    }
    
}
