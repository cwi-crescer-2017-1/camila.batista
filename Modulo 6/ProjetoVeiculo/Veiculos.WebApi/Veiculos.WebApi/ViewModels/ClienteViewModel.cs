using System;
using Veiculos.Dominio.Enum;

namespace Veiculos.WebApi.ViewModels
{
    public class ClienteViewModel
    {
        public int Id { get; private set; }

        public string Nome { get; set; }

        public string Endereco { get; set; }

        public string CPF { get; set; }

        public Genero Sexo { get; set; }

        public DateTime DataNascimento { get; set; }
    }
}