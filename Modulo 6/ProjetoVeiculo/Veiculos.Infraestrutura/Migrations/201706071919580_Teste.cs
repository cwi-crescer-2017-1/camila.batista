namespace Veiculos.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class Teste : DbMigration
    {
        public override void Up()
        {
            AlterColumn("dbo.Adicional", "Nome", c => c.String(maxLength: 100));
            AlterColumn("dbo.Cliente", "Nome", c => c.String(nullable: false, maxLength: 100));
            AlterColumn("dbo.Cliente", "Endereco", c => c.String(nullable: false, maxLength: 300));
            AlterColumn("dbo.Cliente", "CPF", c => c.String(nullable: false, maxLength: 11));
            AlterColumn("dbo.Funcionario", "Nome", c => c.String(nullable: false, maxLength: 100));
            DropColumn("dbo.Pedido", "ValorTotal");
        }
        
        public override void Down()
        {
            AddColumn("dbo.Pedido", "ValorTotal", c => c.Decimal(nullable: false, precision: 18, scale: 2));
            AlterColumn("dbo.Funcionario", "Nome", c => c.String(nullable: false, maxLength: 300));
            AlterColumn("dbo.Cliente", "CPF", c => c.String(nullable: false, maxLength: 20));
            AlterColumn("dbo.Cliente", "Endereco", c => c.String(nullable: false, maxLength: 500));
            AlterColumn("dbo.Cliente", "Nome", c => c.String(nullable: false, maxLength: 300));
            AlterColumn("dbo.Adicional", "Nome", c => c.String(maxLength: 300));
        }
    }
}
