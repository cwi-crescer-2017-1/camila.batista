using Chat.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Http;
using System.Web.Mvc;

namespace Chat.Controllers
{
    public class MensagemController : ApiController
    {
        private static List<Mensagem> Mensagens = new List<Mensagem>();
        private static object objetoLock = new object();

        public List<Mensagem> Get()
        {
            return Mensagens;
        }

        public IHttpActionResult Post(Mensagem mensagem)
        {
            if(mensagem == null)
            {
                return BadRequest();
            }
            else
            {
                lock (objetoLock)
                {
                    Mensagens.Add(mensagem);
                    mensagem.Data = DateTime.Now;
                    return Ok(mensagem);
                }
            }
        }

    }
}