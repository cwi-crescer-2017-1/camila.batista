using Chat.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Http;
using System.Web.Mvc;
using System.Text.RegularExpressions;

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
			mensagem.Texto = Regex.Replace(mensagem.Texto, "André Nunes", "$$$$$ $$$$$", RegexOptions.IgnoreCase);
                mensagem.Data = DateTime.Now;    
		Mensagens.Add(mensagem);
                    
                    return Ok(mensagem);
                }
            }
        }

    }
}