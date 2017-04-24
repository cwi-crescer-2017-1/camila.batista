

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VestirArmaduraTest
{

    @Test
    public void vestirArmadura(){
        Saint june = new BronzeSaint("June", "Camaleao");
        Movimento mov = new VestirArmadura(june);
        
        mov.executar();
        assertTrue(june.isVestida());
    }
    
    @Test
    public void naoVestirArmadura(){
        Saint june = new BronzeSaint("June", "Camaleao");
        Movimento mov = new VestirArmadura(june);

        assertFalse(june.isVestida());
    }
    
    @Test(expected = NullPointerException.class)
    public void vestirArmaduraComSaintNull() throws Exception{
        Saint june = null;
        Movimento mov = new VestirArmadura(june);
        
        mov.executar();
    }
}
