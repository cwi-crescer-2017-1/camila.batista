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

        public decimal ValorTotal(int quantidade, decimal valorUnitario)
        {
            int quantidadeTotal = adicionais.Quantidade + produto.Quantidade;
            decimal valorUnitarioTotal = pacote.ValorUnitario + adicionais.ValorUnitario + produto.ValorUnitario;

            return quantidadeTotal * valorUnitarioTotal;
        }

        public int diasAtraso (DateTime dataPrevista, DateTime dataFinal)
        {
             return DateTime.Compare(DataPrevista, dataFinal);
        }

        public decimal multa(decimal multaDiaria)
        {
            decimal multaDiariaTotal = adicionais.MultaDiaria + pacote.MultaDiaria + produto.MultaDiaria;

            return diasAtraso(DataPrevista, DataFinal) * multaDiariaTotal;
        }
    }
}
