using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Veiculos.Dominio.Entidades;

namespace Veiculos.Infraestrutura.Mapping
{
    public class PacoteMap : EntityTypeConfiguration<Pacote>
    {
        public PacoteMap()
        {
            ToTable("Pacote");
            HasKey(x => x.Id);

            Property(x => x.Nome).HasMaxLength(300);

            Property(x => x.Nome).IsRequired();
            Property(x => x.ValorUnitario).IsRequired();
        }
    }
}
