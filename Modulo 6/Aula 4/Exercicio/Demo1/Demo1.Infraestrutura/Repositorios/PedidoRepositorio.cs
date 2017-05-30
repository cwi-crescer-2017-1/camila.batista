using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Demo1.Dominio.Entidades;
using System.Data.SqlClient;

namespace Demo1.Infraestrutura.Repositorios
{
    public class PedidoRepositorio : IPedidoRepositorio
    {
        string stringConexao = "Server=13.65.101.67;User Id=camila.batista; Password=123456; Database=aluno19db";

        public void Alterar(Pedido pedido)
        {
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = @"UPDATE PEDIDO SET NomeCliente = @nomeCliente, Itens = @itens WHERE Id = @id";

                    comando.Parameters.AddWithValue("@id", pedido.Id);
                    comando.Parameters.AddWithValue("@nomeCliente", pedido.NomeCliente);
                    comando.Parameters.AddWithValue("@itens", pedido.Itens);

                    comando.ExecuteNonQuery();
                }

                foreach(ItemPedido item in pedido.Itens)
                {
                    using (var comando = conexao.CreateCommand())
                    {
                        comando.CommandText = @"UPDATE ITEMPEDIDO SET PedidoId = @pedidoId, ProdutoId = @produtoId, Quantidade = @quantidade WHERE Id = @id";

                        comando.Parameters.AddWithValue("@id", item.Id);
                        comando.Parameters.AddWithValue("@pedidoId", pedido.Id);
                        comando.Parameters.AddWithValue("@produtoId", item.ProdutoId);
                        comando.Parameters.AddWithValue("@quantidade", item.Quantidade);

                        comando.ExecuteNonQuery();
                    }
                }
            }
        }

        public void Criar(Pedido pedido)
        {
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = @"INSERT INTO Pedido (NomeCliente, Itens) VALUES (@nomeCliente, @itens)";

                    comando.Parameters.AddWithValue("@nomeCliente", pedido.NomeCliente);
                    comando.Parameters.AddWithValue("@itens", pedido.Itens);

                    comando.ExecuteNonQuery();
                }

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "SELECT @@IDENTITY";

                    var result = (decimal)comando.ExecuteScalar();
                    pedido.Id = (int)result;
                }

                foreach (ItemPedido item in pedido.Itens)
                {
                    using (var comando = conexao.CreateCommand())
                    {
                        comando.CommandText = @"INSERT INTO ItemPedido (PedidoId, ProdutoId, Quantidade) VALUES (@pedidoId, @produtoId, @quantidade)";

                        comando.Parameters.AddWithValue("@pedidoId", pedido.Id);
                        comando.Parameters.AddWithValue("@produtoId", item.ProdutoId);
                        comando.Parameters.AddWithValue("@quantidade", item.Quantidade);

                        comando.ExecuteNonQuery();
                    }
                    using (var comando = conexao.CreateCommand())
                    {
                        comando.CommandText = @"UPDATE PRODUTO SET Estoque -= @quantidade WHERE Id = @produtoId";
                        comando.Parameters.AddWithValue("@produtoId", item.ProdutoId);
                        comando.Parameters.AddWithValue("@quantidade", item.Quantidade);
                        comando.ExecuteNonQuery();
                    }

                    using (var comando = conexao.CreateCommand())
                    {
                        comando.CommandText = "SELECT @@IDENTITY";

                        var result = (decimal)comando.ExecuteScalar();
                        item.Id = (int)result;
                    }
                }
            }
        }

        public void Excluir(int id)
        {
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = @"DELETE Pedido WHERE Id = @id";

                    comando.Parameters.AddWithValue("@id", id);

                    comando.ExecuteNonQuery();
                }

                var pedido = Obter(id);
                foreach(var item in pedido.Itens)
                {
                    using (var comando = conexao.CreateCommand())
                    {
                        comando.CommandText = @"DELETE ItemPedido WHERE Id = @id";

                        comando.Parameters.AddWithValue("@id", id);
                        comando.ExecuteNonQuery();
                    }
                }
                
            }
        }

        public IEnumerable<Pedido> Listar()
        {
            var pedidos = new List<Pedido>();

            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = @"SELECT Id, NomeCliente, Itens FROM Pedido";
                    var dataReader = comando.ExecuteReader();

                    while (dataReader.Read())
                    {
                        var pedido = new Pedido();

                        pedido.Id = (int)dataReader["Id"];
                        pedido.NomeCliente = (string)dataReader["NomeCliente"];
                        pedido.Itens = (List<ItemPedido>)dataReader["Itens"];

                        pedidos.Add(pedido);
                    }
                }
                foreach(Pedido p in pedidos)
                {
                    using (var comando = conexao.CreateCommand())
                    {
                        comando.CommandText = @"SELECT Id, PedidoId, ProdutoId, Quantidade FROM ItemPedido";
                        var dataReader = comando.ExecuteReader();

                        while (dataReader.Read())
                        {
                            var item = new ItemPedido();

                            item.Id = (int)dataReader["Id"];
                            item.ProdutoId = (int)dataReader["ProdutoId"];
                            item.Quantidade = (int)dataReader["Quantidade"];

                            p.Itens.Add(item);
                        }
                    }
                }
            }

            return pedidos;
        }

        public Pedido Obter(int id)
        {
            Pedido pedido = null;

            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = @"SELECT Id, NomeCliente, Itens FROM Pedido WHERE Id = @id";

                    comando.Parameters.AddWithValue("@id", id);

                    var dataReader = comando.ExecuteReader();

                    while (dataReader.Read())
                    {
                        pedido = new Pedido();

                        pedido.Id = (int)dataReader["Id"];
                        pedido.NomeCliente = (string)dataReader["NomeCliente"];
                        pedido.Itens = (List<ItemPedido>)dataReader["Itens"];

                        return pedido;
                    }
                }
            }

            return pedido;
        }
    }
}
