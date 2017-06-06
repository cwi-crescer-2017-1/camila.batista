using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Veiculos.Dominio.Entidades
{
    public class Cliente
    {
        public int Id { get; private set; }

        public string Nome { get; set; }

        public string Endereco { get; set; }

        public string CPF { get; set; }

        public Genero Sexo { get; set; }

        public DateTime DataNascimento { get; set; }

        public Cliente() { }
    }
}
