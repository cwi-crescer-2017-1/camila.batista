namespace Veiculos.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class AdicionarMultaDiaria : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.Adicional", "MultaDiaria", c => c.Decimal(nullable: false, precision: 18, scale: 2));
            AddColumn("dbo.Pacote", "MultaDiaria", c => c.Decimal(nullable: false, precision: 18, scale: 2));
            AddColumn("dbo.Produto", "MultaDiaria", c => c.Decimal(nullable: false, precision: 18, scale: 2));
        }
        
        public override void Down()
        {
            DropColumn("dbo.Produto", "MultaDiaria");
            DropColumn("dbo.Pacote", "MultaDiaria");
            DropColumn("dbo.Adicional", "MultaDiaria");
        }
    }
}
