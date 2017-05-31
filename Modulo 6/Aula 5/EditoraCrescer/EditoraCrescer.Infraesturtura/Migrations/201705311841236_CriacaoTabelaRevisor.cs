namespace EditoraCrescer.Infraesturtura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class CriacaoTabelaRevisor : DbMigration
    {
        public override void Up()
        {
            DropForeignKey("dbo.Livros", "IdAutor", "dbo.Autores");
            DropIndex("dbo.Livros", new[] { "IdAutor" });
            CreateTable(
                "dbo.Revisores",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(maxLength: 300),
                    })
                .PrimaryKey(t => t.Id);
            
            AddColumn("dbo.Livros", "IdRevisor", c => c.Int(nullable: true));
            Sql("UPDATE dbo.Livros SET IdRevisor = 1");
            AlterColumn("dbo.Livros", "IdRevisor", x => x.Int(nullable: false));
            AddColumn("dbo.Livros", "DataRevisao", c => c.DateTime(nullable: false));
            AddColumn("dbo.Livros", "Capa", c => c.String());
            AddColumn("dbo.Livros", "Revisor_Id", c => c.Int());
            CreateIndex("dbo.Livros", "IdRevisor");
            CreateIndex("dbo.Livros", "Revisor_Id");
            AddForeignKey("dbo.Livros", "Revisor_Id", "dbo.Revisores", "Id");
            AddForeignKey("dbo.Livros", "IdRevisor", "dbo.Autores", "Id", cascadeDelete: true);
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Livros", "IdRevisor", "dbo.Autores");
            DropForeignKey("dbo.Livros", "Revisor_Id", "dbo.Revisores");
            DropIndex("dbo.Livros", new[] { "Revisor_Id" });
            DropIndex("dbo.Livros", new[] { "IdRevisor" });
            DropColumn("dbo.Livros", "Revisor_Id");
            DropColumn("dbo.Livros", "Capa");
            DropColumn("dbo.Livros", "DataRevisao");
            DropColumn("dbo.Livros", "IdRevisor");
            DropTable("dbo.Revisores");
            CreateIndex("dbo.Livros", "IdAutor");
            AddForeignKey("dbo.Livros", "IdAutor", "dbo.Autores", "Id", cascadeDelete: true);
        }
    }
}
