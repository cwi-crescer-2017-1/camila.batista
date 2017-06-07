using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Veiculos.Dominio.Entidades
{
    public class Pacote
    {
        public int Id { get; private set; }

        public string Nome { get; set; }

        public decimal ValorUnitario { get; set; }

        public Pacote() { }

        public Pacote(string nome, decimal valorUnitario)
        {
            Nome = nome;
            ValorUnitario = valorUnitario;
        }

        List<string> mensagens = new List<string>();

        public bool Validar()
        {
            mensagens.Clear();

            if (Nome.Length == 0 || Nome.Length > 100)
            {
                mensagens.Add("Nome digitado invalido");
            }

            if (ValorUnitario <= 0)
            {
                mensagens.Add("Valor unitário inválido");
            }

            return mensagens.Count() > 0 ? true : false;
        }
    }
}
