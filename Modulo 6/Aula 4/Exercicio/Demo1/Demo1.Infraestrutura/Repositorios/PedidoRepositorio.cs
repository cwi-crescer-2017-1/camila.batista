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
                    if (item.Id == 0)
                    {
                        CriarItemPedido(conexao, pedido, item);
                        BaixarEstoque(conexao, item);
                    }
                    else
                    {
                        int diferenca = 0;

                        using (var comando = conexao.CreateCommand())
                        {
                            comando.CommandText = @"SELECT Quantidade FROM ItemPedido WHERE Id = @id";

                            comando.Parameters.AddWithValue("@id", item.Id);
                            diferenca = (int)comando.ExecuteScalar();
                        }

                        using (var comando = conexao.CreateCommand())
                        {
                            comando.CommandText = @"UPDATE ITEMPEDIDO SET PedidoId = @pedidoId, ProdutoId = @produtoId, Quantidade = @quantidade WHERE Id = @id";

                            comando.Parameters.AddWithValue("@id", item.Id);
                            comando.Parameters.AddWithValue("@pedidoId", pedido.Id);
                            comando.Parameters.AddWithValue("@produtoId", item.ProdutoId);
                            comando.Parameters.AddWithValue("@quantidade", item.Quantidade);

                            comando.ExecuteNonQuery();
                        }
                        AtualizaEstoque(conexao, item, diferenca);
                    }
                }

                var itensExcluidos = new List<ItemPedido>();
                
                using(var comando = conexao.CreateCommand())
                {
                    comando.CommandText = @"SELECT Id, PedidoId, ProdutoId, Quantidade FROM ItemPedido WHERE PedidoId = @pedidoId";
                    comando.Parameters.AddWithValue("@pedidoId", pedido.Id);

                    using (var dataReader = comando.ExecuteReader())
                    {
                        while (dataReader.Read())
                        {
                            var excluir = LerItemPedido(dataReader);

                            if(!pedido.Itens.Where(i => i.Id == itensExcluidos.Id).Any())
                            {
                                excluir.Add(itensExcluidos);
                            }
                        }
                    }
                }

                foreach(var excluirItens in itensExcluidos)
                {
                    using(var comando = conexao.CreateCommand())
                    {
                        comando.CommandText = @"DELETE ItemPedido WHERE Id = @id";
                        comando.Parameters.AddWithValue("@id", pedido.Id);
                        comando.ExecuteNonQuery();
                    }
                    IncrementarEstoque(conexao, excluirItens);
                }
            }
        }

        public void Criar(Pedido pedido)
        {
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                var transacao = conexao.BeginTransaction();

                try
                {

                    using (var comando = conexao.CreateCommand())
                    {
                        comando.Transaction = transacao;
                        comando.CommandText = @"INSERT INTO Pedido (NomeCliente) VALUES (@nomeCliente)";

                        comando.Parameters.AddWithValue("@nomeCliente", pedido.NomeCliente);

                        comando.ExecuteNonQuery();
                    }

                    using (var comando = conexao.CreateCommand())
                    {
                        comando.Transaction = transacao;
                        comando.CommandText = "SELECT CAST(@@IDENTITY AS INT)";

                        pedido.Id = (int)comando.ExecuteScalar();
                    }

                    foreach (ItemPedido item in pedido.Itens)
                    {
                        CriarItemPedido(conexao, pedido, item, transacao);
                        BaixarEstoque(conexao, item, transacao);
                    }

                    transacao.Commit();
                }
                catch
                {
                    transacao.Rollback();
                    throw;
                }
            }
        }

        public void Excluir(int id)
        {
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();
                var pedido = Obter(id);

                foreach (var item in pedido.Itens)
                {
                    IncrementarEstoque(conexao, item);
                }

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = @"DELETE Pedido WHERE Id = @id";

                    comando.Parameters.AddWithValue("@id", id);

                    comando.ExecuteNonQuery();
                }
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = @"DELETE ItemPedido WHERE Id = @id";

                    comando.Parameters.AddWithValue("@id", id);
                    comando.ExecuteNonQuery();
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
                        comando.CommandText = @"SELECT Id, PedidoId, ProdutoId, Quantidade FROM ItemPedido WHERE PedidoId = @pedidoId";
                        comando.Parameters.AddWithValue("@pedidoId", p.Id);

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
                    comando.CommandText = @"SELECT Id, NomeCliente FROM Pedido WHERE Id = @id";

                    comando.Parameters.AddWithValue("@id", id);

                    var dataReader = comando.ExecuteReader();

                    while (dataReader.Read())
                    {
                        pedido = new Pedido();

                        pedido.Id = (int)dataReader["Id"];
                        pedido.NomeCliente = (string)dataReader["NomeCliente"];

                        return pedido;
                    }
                }

                using(var comando = conexao.CreateCommand())
                {
                    comando.CommandText = @"SELECT Id, PedidoId, ProdutoId, Quantidade FROM ItemPedido WHERE PedidoId = @pedidoId";
                    comando.Parameters.AddWithValue("@pedidoId", pedido.Id);

                    var dataReader = comando.ExecuteReader();
                    while (dataReader.Read())
                    {
                        ItemPedido i = new ItemPedido();

                        i.Id = (int)dataReader["Id"];
                        i.ProdutoId = (int)dataReader["ProdutoId"];
                        i.Quantidade = (int)dataReader["Quantidade"];

                        pedido.Itens.Add(i);
                    }
                }
            }

            return pedido;
        }
    }
}
