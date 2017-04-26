
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SorteDoDiaTest
{
    @Test
    public void algumaCoisa(){
        SorteDoDia sorteDia = new SorteDoDia(new DadoD6());
        boolean sorte = sorteDia.estouComSorte();
        if(sorte){
            assertEquals(true, sorte);
        }else{
            assertEquals(false, sorte);
        }
    }
}
