using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demo1.Dominio.Entidades
{
    public class Pedido
    {
        public int Id { get; set; }
        public string NomeCliente { get; set; }
        public List<ItemPedido> Itens { get; set; }

        public bool Validar(out List<string> mensagens)
        {
            mensagens = new List<string>();

            if (string.IsNullOrWhiteSpace(NomeCliente))
            {
                mensagens.Add("Deve ser informado o nome do cliente");
            }
            if(Itens.Count < 1)
            {
                mensagens.Add("Deve ser informado os itens pedidos");
            }
            return mensagens.Count() == 0;
        }
    }
}
