using Demo1.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demo1.Infraestrutura.Repositorios
{
    public class ItemPedidoRepositorio
    {
        string stringConexao = "Server=13.65.101.67;User Id=camila.batista; Password=123456; Database=aluno19db";

        public void Alterar(ItemPedido itemPedido)
        {
            throw new NotImplementedException();
        }

        public void Criar(ItemPedido itemPedido)
        {
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = @"INSERT INTO ItemPedido (ProdutoId, Quantidade) VALUES (@produtoId, @quantidade)";

                    comando.Parameters.AddWithValue("@produtoId", itemPedido.ProdutoId);
                    comando.Parameters.AddWithValue("@quantidade", itemPedido.Quantidade);

                    comando.ExecuteNonQuery();
                }
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "SELECT @@IDENTITY";

                    var result = (decimal)comando.ExecuteScalar();
                    itemPedido.Id = (int)result;
                }
            }
        }

        public void Excluir(int id)
        {
            throw new NotImplementedException();
        }

        public IEnumerable<ItemPedido> Listar()
        {

        }

        public ItemPedido Obter(int id)
        {
            throw new NotImplementedException();
        }
    }
}
