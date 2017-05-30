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
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = @"UPDATE ITEMPEDIDO SET ProdutoId = @produtoId, Quantidade = @quantidade WHERE Id = @id";

                    comando.Parameters.AddWithValue("@id", itemPedido.Id);
                    comando.Parameters.AddWithValue("@produtoId", itemPedido.ProdutoId);
                    comando.Parameters.AddWithValue("@quantidade", itemPedido.Quantidade);

                    comando.ExecuteNonQuery();
                }
            }
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
            using(var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = @"DELETE ItemPedido WHERE Id = @id";

                    comando.Parameters.AddWithValue("@id", id);
                    comando.ExecuteNonQuery();
                }
            }
        }

        public IEnumerable<ItemPedido> Listar()
        {
            var itens = new List<ItemPedido>();
            using(var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = @"SELECT Id, ProdutoId, Quantidade FROM ItemPedido";
                    var dataReader = comando.ExecuteReader();

                    while (dataReader.Read())
                    {
                        var item = new ItemPedido();

                        item.Id = (int)dataReader["Id"];
                        item.ProdutoId = (int)dataReader["ProdutoId"];
                        item.Quantidade = (int)dataReader["Quantidade"];

                        itens.Add(item);
                    }
                }
            }
            return itens;
        }

        public ItemPedido Obter(int id)
        {
            ItemPedido itemPedido = null;

            using(var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = @"SELECT Id, ProdutoId, Quantidade FROM ItemPedido WHERE Id = @id";
                    comando.Parameters.AddWithValue("@id", id);

                    var dataReader = comando.ExecuteReader();
                    while (dataReader.Read())
                    {
                        itemPedido = new ItemPedido();

                        itemPedido.Id = (int)dataReader["Id"];
                        itemPedido.ProdutoId = (int)dataReader["ProdutoId"];
                        itemPedido.Quantidade = (int)dataReader["Quantidade"];

                        return itemPedido;
                    }
                }
            }

            return itemPedido;
        }
    }
}
