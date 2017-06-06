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
                .HasForeignKey(x => x.cliente.Id);

            HasRequired(x => x.funcionario)
                .WithMany()
                .HasForeignKey(x => x.funcionario.Id);

            HasRequired(x => x.adicionais)
                .WithMany()
                .HasForeignKey(x => x.adicionais.Id);

            HasRequired(x => x.produto)
                .WithMany()
                .HasForeignKey(x => x.produto.Id);

            HasRequired(x => x.pacote)
                .WithMany()
                .HasForeignKey(x => x.pacote.Id);
        }

    }
}
