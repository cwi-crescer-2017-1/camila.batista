public class OuroSaint extends Saint{
    
    public OuroSaint(String nome, String constelacao1) throws Exception{
        super(nome, new Armadura(new Constelacao(constelacao1), Categoria.OURO));
        this.qtdSentidosDespertos = 7;
        
        Constelacao constelacao = this.getArmadura().getConstelacao();
        if ( !constelacao.getNome().equals("Áries") 
        && !constelacao.getNome().equals("Touro")
        && !constelacao.getNome().equals("Gêmeos")
        && !constelacao.getNome().equals("Câncer")
        && !constelacao.getNome().equals("Virgem")
        && !constelacao.getNome().equals("Leão")
        && !constelacao.getNome().equals("Libra")
        && !constelacao.getNome().equals("Escorpião")
        && !constelacao.getNome().equals("Sagitário")
        && !constelacao.getNome().equals("Capricórnio")
        && !constelacao.getNome().equals("Aquário")
        && !constelacao.getNome().equals("Peixes")) {
            throw new Exception("Constelação inválida");
        }
        
    }
}