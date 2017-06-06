namespace Veiculos.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class GerarEntidades : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Adicional",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(maxLength: 300),
                        ValorUnitario = c.Decimal(nullable: false, precision: 18, scale: 2),
                        Quantidade = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Cliente",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(nullable: false, maxLength: 300),
                        Endereco = c.String(nullable: false, maxLength: 500),
                        CPF = c.String(nullable: false, maxLength: 20),
                        Sexo = c.Int(nullable: false),
                        DataNascimento = c.DateTime(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Funcionario",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(nullable: false, maxLength: 300),
                        Cargo = c.Int(nullable: false),
                        Login = c.String(nullable: false),
                        Senha = c.String(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Pacote",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(nullable: false, maxLength: 300),
                        ValorUnitario = c.Decimal(nullable: false, precision: 18, scale: 2),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Pedido",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        ValorTotal = c.Decimal(nullable: false, precision: 18, scale: 2),
                        DataInicial = c.DateTime(nullable: false),
                        DataPrevista = c.DateTime(nullable: false),
                        DataFinal = c.DateTime(nullable: false),
                        IdAdicionais = c.Int(nullable: false),
                        IdCliente = c.Int(nullable: false),
                        IdFuncionario = c.Int(nullable: false),
                        IdPacote = c.Int(nullable: false),
                        IdProduto = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Adicional", t => t.IdAdicionais, cascadeDelete: true)
                .ForeignKey("dbo.Cliente", t => t.IdCliente, cascadeDelete: true)
                .ForeignKey("dbo.Funcionario", t => t.IdFuncionario, cascadeDelete: true)
                .ForeignKey("dbo.Pacote", t => t.IdPacote, cascadeDelete: true)
                .ForeignKey("dbo.Produto", t => t.IdProduto, cascadeDelete: true)
                .Index(t => t.IdAdicionais)
                .Index(t => t.IdCliente)
                .Index(t => t.IdFuncionario)
                .Index(t => t.IdPacote)
                .Index(t => t.IdProduto);
            
            CreateTable(
                "dbo.Produto",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(nullable: false, maxLength: 300),
                        ValorUnitario = c.Decimal(nullable: false, precision: 18, scale: 2),
                        Quantidade = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Pedido", "IdProduto", "dbo.Produto");
            DropForeignKey("dbo.Pedido", "IdPacote", "dbo.Pacote");
            DropForeignKey("dbo.Pedido", "IdFuncionario", "dbo.Funcionario");
            DropForeignKey("dbo.Pedido", "IdCliente", "dbo.Cliente");
            DropForeignKey("dbo.Pedido", "IdAdicionais", "dbo.Adicional");
            DropIndex("dbo.Pedido", new[] { "IdProduto" });
            DropIndex("dbo.Pedido", new[] { "IdPacote" });
            DropIndex("dbo.Pedido", new[] { "IdFuncionario" });
            DropIndex("dbo.Pedido", new[] { "IdCliente" });
            DropIndex("dbo.Pedido", new[] { "IdAdicionais" });
            DropTable("dbo.Produto");
            DropTable("dbo.Pedido");
            DropTable("dbo.Pacote");
            DropTable("dbo.Funcionario");
            DropTable("dbo.Cliente");
            DropTable("dbo.Adicional");
        }
    }
}
