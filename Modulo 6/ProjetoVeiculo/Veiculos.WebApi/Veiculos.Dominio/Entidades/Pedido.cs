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

        public decimal ValorTotal { get; set; }

        public DateTime DataInicial { get; private set; }

        public DateTime DataPrevista { get; set; }

        public DateTime DataFinal { get; private set; }

        public Cliente cliente { get; private set; }

        public Funcionario funcionario { get; private set; }

        public Adicional adicionais { get; private set; }

        public Produto produto { get; private set; }

        public Pacote pacote { get; private set; }

        public Pedido() { }
    }
}
