import java.security.InvalidParameterException;
import java.util.ArrayList;
public abstract class Saint{
    private String nome;
    private Armadura armadura;
    private boolean vestida;
    
    private Genero genero = Genero.NAO_INFORMADO;
    private Status status = Status.VIVO;
    private double vida = 100.;
    
    private Categoria categoria;
    protected int qtdSentidosDespertos;
    private int acumuladorProximoGolpe, proximoMovimento; 
    
    private static int qtdSaints = 0, acumuladorSaints = 1;
    private int id;
    
    ArrayList<Movimento> movimentos = new ArrayList<>();
    
    public Saint(String nome, Armadura armadura){
        this.nome = nome;
        this.armadura = armadura;
        this.id = ++Saint.acumuladorSaints;
        qtdSaints++;
    }
    
    protected void finalize() throws Throwable{
        Saint.qtdSaints--;
    }
    
    public void vestir(){
        this.vestida = true;
    }
    
    public void perderVida(double dano){
        if(dano < 0){;  
            throw new InvalidParameterException("dano negativo");
        }
        
        if(this.vida > 1){
            this.vida -= dano;
        }
        if(this.vida < 1){
            this.status = Status.MORTO;
            this.vida = 0;
        }
    }
    
    public void aprenderGolpe(Golpe golpe){
        this.getArmadura().getConstelacao().adicionarGolpe(golpe);
    }

    public Golpe getProximoGolpe(){
        ArrayList<Golpe> golpes = getArmadura().getConstelacao().getGolpes();
        
        int pos = this.acumuladorProximoGolpe % golpes.size(); 
        this.acumuladorProximoGolpe++; 
        return golpes.get(pos);    
    }    
    
    public String getNome(){
        return this.nome;
    }
    
    public Armadura getArmadura(){
        return this.armadura;
    }
    
    public boolean isVestida(){
        return this.vestida;
    }
    
    public Genero getGenero(){
        return this.genero;
    }
    public void setGenero(Genero genero){
        this.genero = genero;
    }
    
    public Status getStatus(){
        return this.status;
    }
    
    public Categoria getCategoria(){
        return this.categoria;
    }
    
    public double getVida(){
        return this.vida;
    }
    
    public int getQtdSentidosDespertos(){
        return this.qtdSentidosDespertos;
    }
    
    public ArrayList<Golpe> getGolpes(){
        return this.getArmadura().getConstelacao().getGolpes();
    }
    
    public String getCSV(){
        return String.format(
            "%s, %s, %s, %s, %s, %s, %s",
            this.nome,
            this.vida,
            this.armadura.getConstelacao().getNome(),
            this.armadura.getCategoria(),
            this.status,
            this.genero,
            this.vestida
        );
    }
    
    public void adicionarMovimento(Movimento movimento){
        this.movimentos.add(movimento);
    }
    
    public Movimento getProximoMovimento(){
        if(this.movimentos.isEmpty()){
            return null;
        }
        
        int pos = this.proximoMovimento % movimentos.size(); 
        this.proximoMovimento++; 
        return movimentos.get(pos);  
    }
    
    public static int getQtdSaints(){
        return Saint.qtdSaints;
    }
    
    public int getId(){
        return this.id;
    }
    
    public static int getAcumuladorSaints(){
        return Saint.acumuladorSaints;
    }
}    