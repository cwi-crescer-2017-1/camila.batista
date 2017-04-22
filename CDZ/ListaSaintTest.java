import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class ListaSaintTest{
    
    @Test
    public void buscarPorNomeExistente(){
        ListaSaint lista = new ListaSaint();
        Saint june = new Saint("June", new Armadura(new Constelacao("camaleao"), Categoria.BRONZE));
        lista.adicionaSaint(june);
        assertEquals(june, lista.buscaPorNome("June"));
    }    

    @Test
    public void buscaSaintInexistente(){
        ListaSaint lista = new ListaSaint();
        Saint june = new Saint("June", new Armadura(new Constelacao("camaleao"), Categoria.BRONZE));
        lista.adicionaSaint(june);

        assertNull(lista.buscaPorNome("pudim"));
    }

    @Test
    public void comRepeticaoNomes(){
        ListaSaint lista = new ListaSaint();
        Saint june = new Saint("June", new Armadura(new Constelacao("camaleao"), Categoria.BRONZE));
        lista.adicionaSaint(june);

        Saint june2 = new Saint("June", new Armadura(new Constelacao("camaleao"), Categoria.BRONZE));
        lista.adicionaSaint(june2);

        assertEquals(june, lista.buscaPorNome("June"));
    }

    @Test
    public void saintComListaVazia(){
        assertNull(new ListaSaint().buscaPorNome("pudim"));
    }

    @Test
    public void categoriaListaVazia(){
        ListaSaint lista = new ListaSaint();
        ArrayList<Saint> result = lista.buscaPorCategoria(Categoria.BRONZE);
        assertEquals(new ArrayList<Saint>(), result);
    }

    @Test
    public void categoriaInexistente(){
        ListaSaint lista = new ListaSaint();
        Saint june = new Saint("June", new Armadura(new Constelacao("camaleao"), Categoria.BRONZE));
        lista.adicionaSaint(june);

        ArrayList<Saint> result = lista.buscaPorCategoria(Categoria.OURO);
        
        assertEquals(new ArrayList<Saint>(), result);
    }

    @Test
    public void categoriaExistente(){
        ListaSaint lista = new ListaSaint();
        Saint june = new Saint("June", new Armadura(new Constelacao("camaleao"), Categoria.OURO));
        lista.adicionaSaint(june);
        Saint june2 = new Saint("June", new Armadura(new Constelacao("camaleao"), Categoria.PRATA));
        lista.adicionaSaint(june2);

        ArrayList<Saint> result = lista.buscaPorCategoria(Categoria.OURO);
        assertEquals(june, result.get(0));
        assertEquals(1, result.size());
    }

    @Test
    public void statusVazio(){
        ListaSaint lista = new ListaSaint();
        Saint june = new Saint("June", new Armadura(new Constelacao("camaleao"), Categoria.OURO));
        lista.adicionaSaint(june);

        ArrayList<Saint> result = lista.buscaPorStatus(Status.MORTO);
        assertEquals(new ArrayList<Saint>(), result);
    }

    @Test
    public void statusInexistente(){
        ListaSaint lista = new ListaSaint();
        Saint june = new Saint("June", new Armadura(new Constelacao("camaleao"), Categoria.OURO));
        lista.adicionaSaint(june);

        ArrayList<Saint> result = lista.buscaPorStatus(Status.MORTO);
        assertEquals(new ArrayList<Saint>(), result);
    }

    @Test
    public void statusExistente(){
        ListaSaint lista = new ListaSaint();
        Saint june = new Saint("June", new Armadura(new Constelacao("camaleao"), Categoria.OURO));
        lista.adicionaSaint(june);

        ArrayList<Saint> result = lista.buscaPorStatus(Status.VIVO);
        assertEquals(june.getStatus(), result.get(0).getStatus());
    }

     @Test
    public void getSaintMaiorVidaComApenasUm() throws Exception {
        ListaSaint listaSaint = new ListaSaint();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        listaSaint.adicionaSaint(june);
        assertEquals(june, listaSaint.getSaintMaiorVida());
    }

    @Test
    public void getSaintMaiorVidaComApenasTres() throws Exception {
        ListaSaint listaSaint = new ListaSaint();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        Saint misty = new PrataSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA));
        Saint shun = new Saint("June", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE));
        listaSaint.adicionaSaint(shun);
        listaSaint.adicionaSaint(misty);
        listaSaint.adicionaSaint(june);
        shun.perderVida(10);
        june.perderVida(20);
        assertEquals(misty, listaSaint.getSaintMaiorVida());
    }

    @Test
    public void getSaintMaiorVidaComListaVazia() {
        ListaSaint listaSaint = new ListaSaint();
        Saint maiorVida = listaSaint.getSaintMaiorVida();
        assertNull(maiorVida);
    }

    @Test
    public void getSaintMenorVidaComApenasUm() throws Exception {
        ListaSaint listaSaint = new ListaSaint();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        listaSaint.adicionaSaint(june);
        assertEquals(june, listaSaint.getSaintMenorVida());
    }

    /*@Test
    public void getSaintMenorVidaComApenasTres() throws Exception {
        ListaSaint listaSaint = new ListaSaint();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        Saint misty = new PrataSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA));
        Saint shun = new Saint("June", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE));
        listaSaint.adicionaSaint(shun);
        listaSaint.adicionaSaint(misty);
        listaSaint.adicionaSaint(june);
        shun.perderVida(30);
        june.perderVida(20);
        assertEquals(shun, listaSaint.getSaintMenorVida());
    }*/

    @Test
    public void getSaintMenorVidaComListaVazia() {
        ListaSaint listaSaints = new ListaSaint();
        Saint menorVida = listaSaints.getSaintMenorVida();
        assertNull(menorVida);
    }

    @Test
    public void ordenarComListaTotalmenteDesordenada() throws Exception {
        ListaSaint listaSaints = new ListaSaint();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        Saint misty = new PrataSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA));
        Saint shun = new Saint("Shun", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE));
        listaSaints.adicionaSaint(shun);
        listaSaints.adicionaSaint(misty);
        listaSaints.adicionaSaint(june);
        shun.perderVida(10);
        misty.perderVida(20);
        june.perderVida(30);
        listaSaints.ordenar();
        ArrayList<Saint> resultado = listaSaints.todos();
        assertEquals(june, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(shun, resultado.get(2));
    }
    
    @Test
    public void ordenarComListaTotalmenteOrdenada() throws Exception {
        ListaSaint listaSaint = new ListaSaint();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        Saint misty = new PrataSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA));
        Saint shun = new Saint("Shun", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE));
        listaSaint.adicionaSaint(shun);
        listaSaint.adicionaSaint(misty);
        listaSaint.adicionaSaint(june);
        shun.perderVida(30);
        misty.perderVida(20);
        june.perderVida(10);
        listaSaint.ordenar();
        ArrayList<Saint> resultado = listaSaint.todos();
        assertEquals(shun, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(june, resultado.get(2));
    }
    
    @Test
    public void ordenarComListaVazia() throws Exception {
        ListaSaint listaSaint = new ListaSaint();
        listaSaint.ordenar();
        ArrayList<Saint> resultado = listaSaint.todos();
        assertEquals(new ArrayList<Saint>(), resultado);
    }
    
    @Test
    public void ordenarComListaApenasUm() throws Exception {
        ListaSaint listaSaint = new ListaSaint();
        Saint shun = new Saint("Shun", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE));
        listaSaint.adicionaSaint(shun);
        shun.perderVida(30);
        listaSaint.ordenar();
        ArrayList<Saint> resultado = listaSaint.todos();
        assertEquals(shun, resultado.get(0));
        assertEquals(1, resultado.size());
    }
    
    @Test
    public void ordenarComListaDeValoresIguais() throws Exception {
        ListaSaint listaSaints = new ListaSaint();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        Saint misty = new PrataSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA));
        Saint shun = new Saint("Shun", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE));
        listaSaints.adicionaSaint(shun);
        listaSaints.adicionaSaint(misty);
        listaSaints.adicionaSaint(june);
        listaSaints.ordenar();
        ArrayList<Saint> resultado = listaSaints.todos();
        assertEquals(shun, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(june, resultado.get(2));
    }
    
    @Test
    public void ordenarAscendente() throws Exception{
        ListaSaint lista = new ListaSaint();
        Saint june = new Saint ("june", new Armadura(new Constelacao("Camaleao"), Categoria.BRONZE));
        Saint misty = new Saint ("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA));
        misty.perderVida(20);
        
        lista.adicionaSaint(june);
        lista.adicionaSaint(misty);
        
        ArrayList<Saint> result = lista.todos();
        lista.ordenar();

        assertEquals(misty, result.get(0));
        assertEquals(june, result.get(1));
    }
    
    @Test
    public void ordenarDescendente(){
        ListaSaint lista = new ListaSaint();
        Saint june = new Saint ("june", new Armadura(new Constelacao("Camaleao"), Categoria.BRONZE));
        Saint misty = new Saint ("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA));
        misty.perderVida(20);
        
        lista.adicionaSaint(june);
        lista.adicionaSaint(misty);
        
        ArrayList<Saint> result = lista.todos();
        lista.ordenar(TipoOrdenacao.DESCENDENTE);
        
        assertEquals(june, result.get(0));
        assertEquals(misty, result.get(1));
    }

	@Test
	public void unirDuasListasVazias(){
		ListaSaint lista1 = new ListaSaint();
		ListaSaint lista2 = new ListaSaint();
		ListaSaint result = new ListaSaint();

		result = lista1.unir(lista2);

		assertEquals(0, result.getListaSaint().size());		   
	}

	@Test
	public void unirUmaListaVaziaEOutraComTresElementos(){
		ListaSaint lista1 = new ListaSaint();
		ListaSaint lista2 = new ListaSaint();
		ListaSaint result = new ListaSaint();
		
		Saint june = new Saint("June", new Armadura(new Constelacao(""), Categoria.BRONZE));
 		Saint misty = new PrataSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA));
        Saint shun = new Saint("Shun", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE));
		
		lista1.adicionaSaint(june);
		lista1.adicionaSaint(misty);
		lista1.adicionaSaint(shun);		

		result = lista1.unir(lista2);
   		assertEquals(3, result.getListaSaint().size());
	}

	@Test
	public void unirDuasListasComTresElementos(){
		ListaSaint lista1 = new ListaSaint();
		ListaSaint lista2 = new ListaSaint();
		ListaSaint result = new ListaSaint();

		Saint june = new Saint("June", new Armadura(new Constelacao(""), Categoria.BRONZE));
 		Saint misty = new PrataSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA));
        Saint shun = new Saint("Shun", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE));
		Saint june2 = new Saint("June", new Armadura(new Constelacao(""), Categoria.BRONZE));
 		Saint misty2 = new PrataSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA));
        Saint shun2 = new Saint("Shun", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE));
		
		lista1.adicionaSaint(june);
		lista1.adicionaSaint(misty);
		lista1.adicionaSaint(shun);
		lista2.adicionaSaint(june2);
		lista2.adicionaSaint(misty2);
		lista2.adicionaSaint(shun2);

		result = lista1.unir(lista2);
		assertEquals(6, result.getListaSaint().size());
	}
}