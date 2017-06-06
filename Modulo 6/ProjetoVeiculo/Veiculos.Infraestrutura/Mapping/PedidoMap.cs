using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Veiculos.Dominio.Entidades;

namespace Veiculos.Infraestrutura.Mapping
{
    public class PedidoMap : EntityTypeConfiguration<Pedido>
    {
        public PedidoMap()
        {
            ToTable("Pedido");
            HasKey(x => x.Id);


            HasRequired(x => x.cliente)
                .WithMany()
                .Map(x => x.MapKey("IdCliente"));

            HasRequired(x => x.funcionario)
                .WithMany()
                .Map(x => x.MapKey("IdFuncionario"));

            HasRequired(x => x.adicionais)
                .WithMany()
                .Map(x => x.MapKey("IdAdicionais"));

            HasRequired(x => x.produto)
                .WithMany()
                .Map(x => x.MapKey("IdProduto"));

            HasRequired(x => x.pacote)
                .WithMany()
                .Map(x => x.MapKey("IdPacote"));
        }

    }
}
