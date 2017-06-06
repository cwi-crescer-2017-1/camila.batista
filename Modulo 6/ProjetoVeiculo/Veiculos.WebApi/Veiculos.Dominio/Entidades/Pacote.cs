using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Veiculos.Infraestrutura.Entidades
{
    public class Pacote
    {
        public int Id { get; private set; }

        public string Nome { get; set; }

        public decimal ValorUnitario { get; set; }

        public Pacote() { }
    }
}
