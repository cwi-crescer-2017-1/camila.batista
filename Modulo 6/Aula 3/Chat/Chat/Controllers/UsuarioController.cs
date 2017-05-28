using Chat.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Http;
using System.Web.Mvc;

namespace Chat.Controllers
{
    public class UsuarioController : ApiController
    {
        private static List<Usuario> usuarios = new List<Usuario>();
        private static int contadorId = 1;
        private static object objetoLock = new object();

        public List<Usuario> Get()
        {
            return usuarios;
        }

        public List<Usuario> Get(int id)
        {
            return usuarios.Where(usuario => usuario.Id == id).ToList();
        }

        public IHttpActionResult Post(Usuario usuario)
        {
            if(usuario == null)
            {
                return BadRequest();
            }
            else
            {
                lock (objetoLock)
                {
                    usuarios.Add(usuario);
                    usuario.Id = contadorId++;
                    usuario.Data = DateTime.Now;
                    return Ok(usuario);
                }
            }

        }
        
    }
}