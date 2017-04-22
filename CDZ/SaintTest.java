import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.security.InvalidParameterException;
import java.util.ArrayList;
public class SaintTest{
    
    @Test
    public void vestirVerdadeiroArmaduraVestida(){
        Armadura a1 = new Armadura (new Constelacao("Touro"), Categoria.BRONZE);
        Saint s1 = new Saint("Pudim", a1);
        
        s1.vestir();
        
        assertEquals(true, s1.isVestida());
    }
    
    @Test
    public void vestisFalsoArmaduraNaoVestida(){
        Saint s1 = new Saint("Pudim", new Armadura(new Constelacao("Touro"), Categoria.BRONZE));
        
        assertEquals(false, s1.isVestida());
    }
    
    @Test
    public void nascerComGeneroNaoInformado(){
        Saint s1 = new Saint("Pudim", new Armadura(new Constelacao("Touro"), Categoria.BRONZE));
        assertEquals(Genero.NAO_INFORMADO, s1.getGenero());
    }
    
    @Test
    public void poderAlterarGenero(){
        Saint s1 = new Saint("Pudim", new Armadura(new Constelacao("Touro"), Categoria.BRONZE));
        s1.setGenero(Genero.MASCULINO);
        assertEquals(Genero.MASCULINO, s1.getGenero());
    }
    
    @Test
    public void nascerVivo(){
        Saint s1 = new Saint("Pudim", new Armadura(new Constelacao("Touro"), Categoria.BRONZE));
        assertEquals(Status.VIVO, s1.getStatus());
    }
    
    @Test
    public void vidaInicial00(){
        Saint s1 = new Saint("Pudim", new Armadura(new Constelacao("Touro"), Categoria.BRONZE));
        assertEquals(100, s1.getVida(), 0.001);
    }
    
    @Test
    public void vidaCem(){
        Saint s1 = new Saint("Pudim", new Armadura(new Constelacao("Touro"), Categoria.BRONZE));
        assertEquals(100., s1.getVida(), 0.001);
    }
    
    @Test
    public void perder10Vida(){
        Saint s1 = new Saint("Pudim", new Armadura(new Constelacao("Touro"), Categoria.BRONZE));
        s1.perderVida(10);
        assertEquals(90, s1.getVida(), 0.001);
    }
    
    @Test
    public void perder1000Vida(){
        Saint s1 = new Saint("Pudim", new Armadura(new Constelacao("Touro"), Categoria.BRONZE));
        s1.perderVida(1000);
        assertEquals(-900, s1.getVida(), 0.001);
    }
    
    @Test
    public void vidaMenorQue1Morto(){
        Saint s1 = new Saint("Pudim", new Armadura(new Constelacao("Touro"), Categoria.BRONZE));
    }

    
    @Test(expected=InvalidParameterException.class)
    public void perderDanoComValorMenos1000() throws Exception {
        // Arrange
        Saint shiryu = new Saint("Shiryu", new Armadura(new Constelacao("Dragão"), Categoria.BRONZE));
        // Act
        shiryu.perderVida(-1000);
        // Assert
        assertEquals(1100, shiryu.getVida(), 0.01);
    }

    @Test
    public void criarSaintNasceCom5SentidosDespertados() throws Exception {
        BronzeSaint seiya = new BronzeSaint("Seiya", new Armadura(new Constelacao("Pégaso"), Categoria.BRONZE));
        assertEquals(5, seiya.getQtdSentidosDespertos());
    }

    @Test
    public void criarSaintPrataNasceCom6SentidosDespertados() throws Exception {
        PrataSaint marin = new PrataSaint("Marin", new Armadura(new Constelacao("Águia"), Categoria.PRATA));
        assertEquals(6, marin.getQtdSentidosDespertos());
    }

    @Test
    public void criarSaintOuroNasceCom7SentidosDespertados() throws Exception {
        OuroSaint afrodite = new OuroSaint("Afrodite", new Armadura(new Constelacao("Peixes"), Categoria.OURO));
        assertEquals(7, afrodite.getQtdSentidosDespertos());
    }

    @Test(expected=Exception.class)
    public void constelacaoInvalidaDeOuroDeveLancarErro() throws Exception {
        new OuroSaint("Bernardo", new Armadura(new Constelacao("Café"), Categoria.OURO));
    }

    @Test
    public void aprenderUmGolpe() throws Exception {
        Saint saga = new Saint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        saga.aprenderGolpe(new Golpe("Outra dimensão", 10));
       
        ArrayList<Golpe> golpes = saga.getGolpes();
        
        assertEquals(outraDimensao, golpes.get(0));
        // TODO: assert null
    }

    @Test
    public void aprenderDoisGolpes() throws Exception {
        Saint saga = new Saint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
        
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
        Saint saga = new Saint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
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
        Saint saga = new Saint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
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
        Saint saga = new Saint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        saga.aprenderGolpe(new Golpe("Outra dimensão", 10));
        
        assertEquals(outraDimensao, saga.getProximoGolpe());
    }

    /*@Test
    public void getProximoGolpeComDois() throws Exception {
        Saint saga = new Saint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
        
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        Golpe explosaoGalatica = new Golpe("Explosão Galáctica", 11);
        saga.aprenderGolpe(outraDimensao);
        saga.aprenderGolpe(explosaoGalatica);
        
        assertEquals(outraDimensao, saga.getProximoGolpe());
        assertEquals(explosaoGalatica, saga.getProximoGolpe());
    }*/

    /*@Test
    public void getProximoGolpeComTres() throws Exception {
        Saint saga = new Saint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
       
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        Golpe explosaoGalatica = new Golpe("Explosão Galáctica", 11);
        Golpe sataImperial = new Golpe("Satã Imperial", 42);
        saga.aprenderGolpe(outraDimensao);
        saga.aprenderGolpe(explosaoGalatica);
        saga.aprenderGolpe(sataImperial);
        
        assertEquals(outraDimensao, saga.getProximoGolpe());
        assertEquals(explosaoGalatica, saga.getProximoGolpe());
        assertEquals(sataImperial, saga.getProximoGolpe());
    }*/
    
    /*@Test
    public void getProximoGolpeComQuatroChamadas() throws Exception {
        Saint saga = new Saint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
      
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
    }*/

    
}