using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Veiculos.Dominio.Entidades;

namespace Veiculos.Infraestrutura.Mapping
{
    public class FuncionarioMap : EntityTypeConfiguration<Funcionario>
    {
        public FuncionarioMap()
        {
            ToTable("Funcionario");
            HasKey(x => x.Id);

            Property(p => p.Nome).HasMaxLength(300);

        }
    }
}
