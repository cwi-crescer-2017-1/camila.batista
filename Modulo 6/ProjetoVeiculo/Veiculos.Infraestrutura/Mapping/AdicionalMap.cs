using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Veiculos.Dominio.Entidades;

namespace Veiculos.Infraestrutura.Mapping
{
    public class AdicionalMap : EntityTypeConfiguration<Adicional>
    {
        public AdicionalMap()
        {
            ToTable("Adicional");
            HasKey(x => x.Id);

            Property(x => x.Nome).HasMaxLength(100);
            Property(x => x.ValorUnitario).IsRequired();
            Property(x => x.Quantidade).IsRequired();
        }
    }
}
