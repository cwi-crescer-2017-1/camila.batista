public class OuroSaint extends Saint{
    public OuroSaint(String nome, Armadura armadura) throws Exception{
        super(nome, armadura);
        this.qtdSentidosDespertos = 7;
        
        String constelacao = armadura.getConstelacao();
			if(!constelacao.equals("Áries") && !constelacao.equals("Touro") && !constelacao.equals("Virgem") && !constelacao.equals("Peixe")
			 && !constelacao.equals("Cancer") && !constelacao.equals("Libra") && !constelacao.equals("Escorpião") && !constelacao.equals("Gemeos") 
			&& !constelacao.equals("Escorpião")  && !constelacao.equals("Escorpião") && !constelacao.equals("Escorpião")  && !constelacao.equals("Escorpião")){
				throw new Exception ("Constelação inválida");
			 }
     }
}