using exemplos.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace exemplos.Controllers
{
    public class HeroisController : ApiController
    {

        public IEnumerable<Heroi> Get(int? id = null)
        {
            var herois = new List<Heroi>()
            {
                new Heroi {Id = 1, Nome = "Goku", Poder = new Poder() {Nome = "Genki Dama", Dano = 8000 } },
                new Heroi {Id = 2, Nome = "Luffy", Poder = new Poder() {Nome = "Genki Dama", Dano = 8200 } },
                new Heroi {Id = 3, Nome = "Ryu", Poder = new Poder() {Nome = "Genki Dama", Dano = 9000 } },
                new Heroi {Id = 4, Nome = "Madara", Poder = new Poder() {Nome = "Genki Dama", Dano = 212000 } },
                new Heroi {Id = 5, Nome = "Tom Bombadil", Poder = new Poder() {Nome = "cantar", Dano = 12000 } }
            };

            return herois.Where(x => (id == null || x.Id == id));
        }

        public IHttpActionResult Post(Heroi heroi)
        {
            if (heroi.Id == 0)
            {

                return Ok();
            }
            else{
                return BadRequest();
            }
        }
    }
}
