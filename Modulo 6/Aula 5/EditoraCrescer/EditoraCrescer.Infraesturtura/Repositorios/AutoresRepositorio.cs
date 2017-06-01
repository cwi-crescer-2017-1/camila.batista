using EditoraCrescer.Infraesturtura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraesturtura.Repositorios
{
    public class AutoresRepositorio
    {
        private Contexto contexto = new Contexto();

        public List<Autor> Obter()
        {
            return contexto.Autores.ToList();
        }

        public List<Autor> ObterPorId(int id)
        {
            return contexto.Autores.Where(x => x.Id == id).ToList();
        }

        //TERMINAR
        public object ObterLivros(Autor autor)
        {
            throw new NotImplementedException();
        }
        
        
        public void Criar(Autor autor)
        {
            contexto.Autores.Add(autor);
            contexto.SaveChanges();
        }

        public void Alterar(Autor autor)
        {
            contexto.Entry(autor).State = EntityState.Modified;
            contexto.SaveChanges();   
        }

        public void Remover (int id)
        {
            var autor = contexto.Autores.FirstOrDefault(x => x.Id == id);
            contexto.Autores.Remove(autor);
            contexto.SaveChanges();
        }
        
    }
}
