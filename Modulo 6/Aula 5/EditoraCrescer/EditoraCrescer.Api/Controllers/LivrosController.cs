using EditoraCrescer.Infraesturtura;
using EditoraCrescer.Infraesturtura.Entidades;
using EditoraCrescer.Infraesturtura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Http;

namespace EditoraCrescer.Api.Controllers
{
    [RoutePrefix("api/Livro")]
    public class LivrosController : ApiController
    {
        private LivrosRepositorio _livroRepositorio = new LivrosRepositorio();

        [Route("")]
        [HttpGet]
        public IHttpActionResult Obter()
        {
            var livros = _livroRepositorio.Obter();

            return Ok(livros);
        }

        [Route("{isbn:int}")]
        [HttpGet]
        public IHttpActionResult ObterPorId(int isbn)
        {
            var livros = _livroRepositorio.ObterPorId(isbn);
            return Ok(livros);
        }

        [Route("{genero}")]
        [HttpGet]
        public IHttpActionResult ObterPorGenero(string genero)
        {
            var livros = _livroRepositorio.ObterPorGenero(genero);
            return Ok(livros);
        }

        [Route("")]
        public IHttpActionResult Post(Livro livro)
        {
            _livroRepositorio.Criar(livro);
            return Ok();
        }

        [HttpDelete]
        [Route("{Isbn:int}")]
        public IHttpActionResult Delete(int Isbn)
        {
            _livroRepositorio.Remover(Isbn);
            return Ok();
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                _livroRepositorio.Dispose();
            }
            base.Dispose(disposing);
        }
    }
}