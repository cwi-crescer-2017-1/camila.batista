import java.util.Random;

public class DadoD6 implements Sorteador{
    public int sortear(){
       final Random random = new Random();
       final int max = 6, min = 1;
       return random.nextInt(max - min +1) + min;
    }
}