using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Veiculos.Dominio.Entidades
{
    public class Pedido
    {
        public int Id { get; private set; }

        public DateTime DataInicial { get; private set; }

        public DateTime DataPrevista { get; set; }

        public DateTime DataFinal { get; private set; }

        public Cliente cliente { get; private set; }

        public Funcionario funcionario { get; private set; }

        public Adicional adicionais { get; private set; }

        public Produto produto { get; private set; }

        public Pacote pacote { get; private set; }

        public Pedido() { }

        List<string> mensagens = new List<string>();

        public bool Validar()
        {
            if (produto.Nome.Equals("Fiat Mobi") && adicionais.Nome.Equals("Reboque") || produto.Nome.Equals("Toyota Hilux") && adicionais.Nome.Equals("Rack"))
            {
                mensagens.Add("Impossivel selecionar o produto com este adicional");
            }
            return mensagens.Count() > 0 ? true : false;
        }

        public decimal ValorTotal(int quantidade, decimal valorUnitario)
        {
            int quantidadeTotal = adicionais.Quantidade + produto.Quantidade;
            decimal valorUnitarioTotal = pacote.ValorUnitario + adicionais.ValorUnitario + produto.ValorUnitario;
            decimal multaDiariaTotal = adicionais.MultaDiaria + pacote.MultaDiaria + produto.MultaDiaria;

            return (quantidadeTotal * valorUnitarioTotal) + (DiasAtraso(DataPrevista, DataFinal) * multaDiariaTotal);
        }

        public int DiasAtraso (DateTime dataPrevista, DateTime dataFinal)
        {
            return (DataFinal - dataPrevista).Days;
             //return DateTime.Compare(DataPrevista, dataFinal);
        }
    }
}
