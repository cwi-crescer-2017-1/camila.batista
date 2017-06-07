using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Veiculos.Dominio.Entidades
{
    public class Adicional
    {
        public int Id { get; private set; }

        public string Nome { get; set; }

        public decimal ValorUnitario { get; set; }

        public int Quantidade { get; set; }

        List<String> mensagens = new List<string>();

        public Adicional() { }

        public Adicional(string nome, decimal valorUnitario, int quantidade)
        {
            Nome = nome;
            ValorUnitario = valorUnitario;
            Quantidade = quantidade;
        }

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

            if(Quantidade <= 0)
            {
                mensagens.Add("Quantidade inválida");
            }

            return mensagens.Count() > 0 ? true : false;
        }
    }
}
