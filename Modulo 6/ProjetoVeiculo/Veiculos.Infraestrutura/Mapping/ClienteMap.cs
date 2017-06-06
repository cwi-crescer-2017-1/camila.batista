using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Veiculos.Dominio.Entidades;

namespace Veiculos.Infraestrutura.Mapping
{
    public class ClienteMap : EntityTypeConfiguration<Cliente>
    {
        public ClienteMap()
        {
            ToTable("Cliente");
            HasKey(x => x.Id);

            Property(p => p.Nome).HasMaxLength(300); 
            Property(x => x.Endereco).HasMaxLength(500);
            Property(x => x.CPF).HasMaxLength(20);

            Property(x => x.Nome).IsRequired();
            Property(x => x.Endereco).IsRequired();
            Property(x => x.CPF).IsRequired();
            Property(x => x.Sexo).IsRequired();
            Property(x => x.DataNascimento).IsRequired();

        }
    }
}
