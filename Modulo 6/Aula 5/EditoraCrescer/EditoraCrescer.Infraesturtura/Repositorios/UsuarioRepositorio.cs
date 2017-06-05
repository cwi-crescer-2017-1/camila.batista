using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraesturtura.Entidades
{
    public class UsuarioRepositorio
    {
        private Contexto contexto = new Contexto();

        public UsuarioRepositorio()
        {

        }

        public void Criar(Usuario usuario)
        {
            if (usuario.Validar())
            {
                contexto.Usuarios.Add(usuario);
                contexto.SaveChanges();
            }
        }

        public void Alterar(Usuario usuario)
        {
            if (usuario.Validar())
            {
                contexto.Entry(usuario).State = EntityState.Modified;
                contexto.SaveChanges();
            }
        }
        public void Excluir(int id)
        {
            var us = contexto.Usuarios.FirstOrDefault(x => x.Id == id);
            contexto.Usuarios.Remove(us);
            contexto.SaveChanges();
        }

        public object Listar()
        {
            return contexto.Usuarios
                            .Select(usuario => new
                            {
                                Id = usuario.Id,
                                Nome = usuario.Nome,
                                Email = usuario.Email,
                                Permissoes = usuario.Permissoes
                            }).ToList();
        }

        public Usuario Obter(string email)
        {
            return contexto.Usuarios.Where(u => u.Email == email).Include(u => u.Permissoes).FirstOrDefault(usuario => usuario.Email == email);
        }
    }
}
