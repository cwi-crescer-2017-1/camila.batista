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

        public Pedido()
        {
            Itens = new List<ItemPedido>();
        }

        public bool Validar(out List<string> mensagens)
        {
            mensagens = new List<string>();

            if (string.IsNullOrWhiteSpace(NomeCliente))
            {
                mensagens.Add("Deve ser informado o nome do cliente");
            }
            if(Itens.Where(q => q.Quantidade < 0).Any())
            {
                mensagens.Add("Não é possível gerar um pedido com a quantidade de itens pedidos negativa");
            }
            return mensagens.Count() == 0;
        }
    }
}
