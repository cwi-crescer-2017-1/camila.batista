using EditoraCrescer.Infraesturtura.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraesturtura.Repositorios
{
    public class LivrosRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();


        public bool VerificaSeLivroExiste(int isbn)
        {
            return contexto.Livros.Count(e => e.Isbn == isbn) > 0;
        }

        public object Obter(int skip)
        {
            //return contexto.Livros.ToList();
            return contexto.Livros
                .Select(x => new
                {
                    Isbn = x.Isbn,
                    Titulo = x.Titulo,
                    Capa = x.Capa,
                    NomeAutor = x.Autor.Nome,
                    Genero = x.Genero
                }).OrderBy(x => x.Isbn)
                .Skip(skip * 10)
                .Take(10)
                .ToList();
        }

        public List<int> ObterPaginacao()
        {
            List<int> paginas = new List<int>();
            int count = contexto.Livros.Count()/10;
            for(int x = 1; x <= count; x++)
            {
                paginas.Add(x);
            }

            return paginas;
        }
            
        public List<Livro> ObterPorId(int isbn)
        {
            return contexto.Livros.Where(x => x.Isbn == isbn).ToList(); 
        }

        public object ObterPorGenero(string genero)
        {
            List<Livro> livro = contexto.Livros.Where(x => x.Genero.Contains(genero)).ToList();
            return livro.Select(x => new
                {
                    Isbn = x.Isbn,
                    Titulo = x.Titulo,
                    Capa = x.Capa,
                    NomeAutor = x.Autor.Nome,
                    Genero = x.Genero
                 }).ToList();
        }

        //GET DA ULTIMA SEMANA
        

        public object ObterLancamentos()
        {
            var data = DateTime.Now.AddDays(-7);
            return contexto.Livros
                            .Where(x => x.DataPublicacao != null && x.DataPublicacao > data)
                            .OrderByDescending(x => x.DataPublicacao)
                            .Select(x => new
                            {
                                Isbn = x.Isbn,
                                Titulo = x.Titulo,
                                Capa = x.Capa,
                                NomeAutor = x.Autor.Nome,
                                Genero = x.Genero
                            }).ToList();
        }

        public void Criar(Livro livro)
        {
            contexto.Livros.Add(livro);
            contexto.SaveChanges();
        }
        
        public void Alterar(Livro livro)
        {
            contexto.Entry(livro).State = EntityState.Modified;
            contexto.SaveChanges();
        }

        public void Remover(int id)
        {
            var livro = contexto.Livros.FirstOrDefault(x => x.Isbn == id);
            contexto.Livros.Remove(livro);
            contexto.SaveChanges();
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
