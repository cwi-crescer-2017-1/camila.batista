import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.security.InvalidParameterException;
import java.util.ArrayList;
public class SaintTest{
    
    @Test
    public void tearDown(){
        System.gc(); //Chama o garbege collection
    }
    
    @Test
    public void vestirVerdadeiroArmaduraVestida(){
        Saint s1 = new BronzeSaint("Pudim", "Touro");
        
        s1.vestir();
        
        assertEquals(true, s1.isVestida());
    }
    
    @Test
    public void vestisFalsoArmaduraNaoVestida(){
        Saint s1 = new BronzeSaint("Pudim", "Touro");
        
        assertEquals(false, s1.isVestida());
    }
    
    @Test
    public void nascerComGeneroNaoInformado(){
        Saint s1 = new BronzeSaint("Pudim", "Touro");
        assertEquals(Genero.NAO_INFORMADO, s1.getGenero());
    }
    
    @Test
    public void poderAlterarGenero(){
        Saint s1 = new BronzeSaint("Pudim", "Touro");
        s1.setGenero(Genero.MASCULINO);
        assertEquals(Genero.MASCULINO, s1.getGenero());
    }
    
    @Test
    public void nascerVivo(){
        Saint s1 = new BronzeSaint("Pudim", "Touro");
        assertEquals(Status.VIVO, s1.getStatus());
    }
    
    @Test
    public void vidaInicial00(){
        Saint s1 = new BronzeSaint("Pudim", "Touro");
        assertEquals(100, s1.getVida(), 0.001);
    }
    
    @Test
    public void vidaCem(){
        Saint s1 = new BronzeSaint("Pudim", "Touro");
        assertEquals(100., s1.getVida(), 0.001);
    }
    
    @Test
    public void perder10Vida(){
        Saint s1 = new BronzeSaint("Pudim", "Touro");
        s1.perderVida(10);
        assertEquals(90, s1.getVida(), 0.001);
    }
    
    @Test
    public void perder1000Vida(){
        Saint s1 = new BronzeSaint("Pudim", "Touro");
        s1.perderVida(1000);
        assertEquals(0, s1.getVida(), 0.001);
    }
    
    @Test
    public void vidaMenorQue1Morto(){
        Saint s1 = new BronzeSaint("Pudim", "Touro");
    }

    
    @Test(expected=InvalidParameterException.class)
    public void perderDanoComValorMenos1000() throws Exception {
        // Arrange
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        // Act
        shiryu.perderVida(-1000);
        // Assert
        assertEquals(1100, shiryu.getVida(), 0.01);
    }

    @Test
    public void criarSaintNasceCom5SentidosDespertados() throws Exception {
        BronzeSaint seiya = new BronzeSaint("Seiya", "Pégaso");
        assertEquals(5, seiya.getQtdSentidosDespertos());
    }

    @Test
    public void criarSaintPrataNasceCom6SentidosDespertados() throws Exception {
        PrataSaint marin = new PrataSaint("Marin", "Águia");
        assertEquals(6, marin.getQtdSentidosDespertos());
    }

    @Test
    public void criarSaintOuroNasceCom7SentidosDespertados() throws Exception {
        OuroSaint afrodite = new OuroSaint("Afrodite", "Peixes");
        assertEquals(7, afrodite.getQtdSentidosDespertos());
    }

    @Test(expected=Exception.class)
    public void constelacaoInvalidaDeOuroDeveLancarErro() throws Exception {
        new OuroSaint("Bernardo", "Café");
    }

    @Test
    public void aprenderUmGolpe() throws Exception {
        Saint saga = new OuroSaint("Saga", "Gêmeos");
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        saga.aprenderGolpe(new Golpe("Outra dimensão", 10));
       
        ArrayList<Golpe> golpes = saga.getGolpes();
        
        assertEquals(outraDimensao, golpes.get(0));
        // TODO: assert null
    }

    @Test
    public void aprenderDoisGolpes() throws Exception {
        Saint saga = new OuroSaint("Saga", "Gêmeos");
        
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        Golpe explosaoGalatica = new Golpe("Explosão Galáctica", 11);
        saga.aprenderGolpe(outraDimensao);
        saga.aprenderGolpe(explosaoGalatica);
        
        ArrayList<Golpe> golpes = saga.getGolpes();
        
        assertEquals(outraDimensao, golpes.get(0));
        assertEquals(explosaoGalatica, golpes.get(1));
        assertEquals(2, golpes.size());
    }

    @Test
    public void aprenderTresGolpes() throws Exception {
        Saint saga = new OuroSaint("Saga", "Gêmeos");
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        Golpe explosaoGalatica = new Golpe("Explosão Galáctica", 11);
        Golpe sataImperial = new Golpe("Satã Imperial", 42);
        
        saga.aprenderGolpe(outraDimensao);
        saga.aprenderGolpe(explosaoGalatica);
        saga.aprenderGolpe(sataImperial);
        
        ArrayList<Golpe> golpes = saga.getGolpes();
        
        assertEquals(outraDimensao, golpes.get(0));
        assertEquals(explosaoGalatica, golpes.get(1));
        assertEquals(sataImperial, golpes.get(2));
    }

    @Test
    public void aprenderQuatroGolpesLancaErro() throws Exception {
        Saint saga = new OuroSaint("Saga", "Gêmeos");
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        Golpe explosaoGalatica = new Golpe("Explosão Galáctica", 11);
        Golpe sataImperial = new Golpe("Satã Imperial", 42);
        Golpe rasteira = new Golpe("Rasteira", 2);
        
        saga.aprenderGolpe(outraDimensao);
        saga.aprenderGolpe(explosaoGalatica);
        saga.aprenderGolpe(sataImperial);
        saga.aprenderGolpe(rasteira);
    }

    @Test
    public void getProximoGolpeComUm() throws Exception {
        Saint saga = new OuroSaint("Saga", "Gêmeos");
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        saga.aprenderGolpe(new Golpe("Outra dimensão", 10));
        
        assertEquals(outraDimensao, saga.getProximoGolpe());
    }

    @Test
    public void getProximoGolpeComDois() throws Exception {
        Saint saga = new OuroSaint("Saga", "Gêmeos");
        
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        Golpe explosaoGalatica = new Golpe("Explosão Galáctica", 11);
        //saga.aprenderGolpe(outraDimensao);
        //saga.aprenderGolpe(explosaoGalatica);
        
        saga.getArmadura().getConstelacao().adicionarGolpe(outraDimensao);
        saga.getArmadura().getConstelacao().adicionarGolpe(explosaoGalatica);
        
        assertEquals(outraDimensao, saga.getProximoGolpe());
        assertEquals(explosaoGalatica, saga.getProximoGolpe());
    }

    @Test
    public void getProximoGolpeComTres() throws Exception {
        Saint saga = new OuroSaint("Saga", "Gêmeos");
       
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        Golpe explosaoGalatica = new Golpe("Explosão Galáctica", 11);
        Golpe sataImperial = new Golpe("Satã Imperial", 42);
        saga.aprenderGolpe(outraDimensao);
        saga.aprenderGolpe(explosaoGalatica);
        saga.aprenderGolpe(sataImperial);
        
        assertEquals(outraDimensao, saga.getProximoGolpe());
        assertEquals(explosaoGalatica, saga.getProximoGolpe());
        assertEquals(sataImperial, saga.getProximoGolpe());
    }
    
    @Test
    public void getProximoGolpeComQuatroChamadas() throws Exception {
        Saint saga = new OuroSaint("Saga", "Gêmeos");
      
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        Golpe explosaoGalatica = new Golpe("Explosão Galáctica", 11);
        Golpe sataImperial = new Golpe("Satã Imperial", 42);
       
        saga.aprenderGolpe(outraDimensao);
        saga.aprenderGolpe(explosaoGalatica);
        saga.aprenderGolpe(sataImperial);
        
        assertEquals(outraDimensao, saga.getProximoGolpe());
        assertEquals(explosaoGalatica, saga.getProximoGolpe());
        assertEquals(sataImperial, saga.getProximoGolpe());
        assertEquals(outraDimensao, saga.getProximoGolpe());
    }
    //(expected = ArithmeticException.class)
    @Test
    public void getProximoMovimentoListaVazia(){
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        Movimento mov = shiryu.getProximoMovimento();
    }
    
    @Test
    public void getProximoMovimentoComApenasUm(){
        // Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        // Movimento mov = new VestirArmadura(shiryu);
        // shiryu.getProximoMovimento();
        // assertEquals(mov, shiryu.getProximoMovimento());
    }
   
    @Test
    public void criarUmSaintQuantidadeUm() throws Exception{
        int antes = Saint.getQtdSaints();
        Saint albafica = new OuroSaint ("Albafica", "Peixes");
        assertEquals(antes + 1, Saint.getQtdSaints());
        //assertEquals(1, Saint.getQtdSaints()); > se executar desta forma vai da erro, pois o get irá pegar todos os saints já instanciados
    }
    
    @Test
    public void criarCemSaintsQuantidadeCem() throws Exception{
        int antes = Saint.getQtdSaints();
        for(int a = 0; a < 100; a++){
            new OuroSaint("Ouro " + a, "Peixes");
        }
        assertEquals(antes + 100, Saint.getQtdSaints());
    }
    
    @Test
    public void criarUmSaintIdUm() throws Exception{
        int idAntes = Saint.getAcumuladorSaints();
        assertEquals(idAntes + 1, new BronzeSaint("Shun", "Andromeda").getId());
    }
    
    @Test
    public void criarCemSaintsIdCem() throws Exception{
        int idAntes = Saint.getQtdSaints();
        for(int a = 0; a < 100; a++){
            new OuroSaint("Ouro " + a, "Peixes");
        }
        assertEquals(idAntes + 100, Saint.getQtdSaints());
    }
    
}