using EditoraCrescer.Infraesturtura;
using EditoraCrescer.Infraesturtura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Http;
using System.Web.Mvc;

namespace EditoraCrescer.Api.Controllers
{
    public class LivrosController : ApiController
    {
        private LivroRepositorio _livroRepositorio = new LivroRepositorio();
        public IHttpActionResult Get()
        {
            var livros = _livroRepositorio.Obter();

            return Ok(livros);
        }
    }
}