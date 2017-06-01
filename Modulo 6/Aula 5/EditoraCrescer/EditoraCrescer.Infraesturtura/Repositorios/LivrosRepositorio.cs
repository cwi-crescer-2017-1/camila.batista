using EditoraCrescer.Infraesturtura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraesturtura.Repositorios
{
    public class LivrosRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();

        public Dynamic Obter()
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
                     }).ToList();
        }

        public List<Livro> ObterPorId(int isbn)
        {
            return contexto.Livros.Where(x => x.Isbn == isbn).ToList(); 
        }

        public Dynamic ObterPorGenero(string genero)
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

        public void Criar(Livro livro)
        {
            contexto.Livros.Add(livro);
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
