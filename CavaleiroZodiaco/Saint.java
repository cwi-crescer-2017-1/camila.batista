import java.security.InvalidParameterException;
public class Saint{
    private String nome;
    private Armadura armadura;
    
    private Genero genero = Genero.NAO_INFORMADO;
    private Status status = Status.VIVO;
    private boolean vestida;
    
    private double vida = 100.0;
    protected int qtdSentidosDespertos;
    private int acumuladorProximoGolpes = 0;
    
    public void vestir(){
        this.vestida = true;
    }
    
    public void perderVida(double dano) throws Exception{
        if(dano < 0){
            throw new InvalidParameterException("dano negativo");
        }
        if(vida - dano < 1){
            this.status = status.MORTO;
            this.vida = 0;
        }else{
            this.vida -= dano;
        }
    }
    
    public Saint(){}
    public Saint(String nome, Armadura armadura) throws Exception{
        this.nome = nome;
        this.armadura = armadura;
    }
    
    public boolean isVestida(){
        return this.vestida;
    }
    public void setVestida(boolean vestida){
        this.vestida = vestida;
    }
    
    public Armadura getArmadura(){
        return this.armadura;
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
    
    public double getVida(){
        return this.vida;
    }
    public void setVida(double vida){
        this.vida = vida;
    }
    public int getQtdSentidosDespertos(){
        return this.qtdSentidosDespertos;
    }
    
    public Golpe[] getGolpe(){
        return this.armadura.getConstelacao().getGolpes();
    }
    
    public void aprenderGolpe(Golpe golpe){
        this.armadura.getConstelacao().getGolpes();
    }
    
    public Golpe getProximoGolpe(){
        Golpe[] golpes = getGolpes();
        int posicao = (this.acumuladorProximoGolpes++) % golpes.length;
        return golpes[posicao];
    }
}