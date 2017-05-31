using EditoraCrescer.Infraesturtura.Entidades;
using System.Data.Entity.ModelConfiguration;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraesturtura.Mappings
{
    public class RevisorMap : EntityTypeConfiguration<Revisor>
    {
        public RevisorMap()
        {
            ToTable("Revisores");
            Property(p => p.Nome).HasMaxLength(300);    
        }
    }
}
