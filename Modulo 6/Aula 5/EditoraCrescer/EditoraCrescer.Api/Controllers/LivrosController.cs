using EditoraCrescer.Infraesturtura;
using EditoraCrescer.Infraesturtura.Entidades;
using EditoraCrescer.Infraesturtura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
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

            return Ok(new { dados = livros });
        }

        [Route("{isbn:int}")]
        [HttpGet]
        public IHttpActionResult ObterPorId(int isbn)
        {
            var livros = _livroRepositorio.ObterPorId(isbn);
            return Ok(new { dados = livros });
        }

        [Route("{genero}")]
        [HttpGet]
        public IHttpActionResult ObterPorGenero(string genero)
        {
            var livros = _livroRepositorio.ObterPorGenero(genero);
            return Ok(new { dados = livros});
        }

        [HttpGet]
        [Route("{autor}")]
        public IHttpActionResult ObterLivroPorAutor(string genero)
        {
            var livro = _livroRepositorio.ObterPorGenero(genero);
            return Ok(new { dados = livro });
        }

        [Route("Lancamento")]
        [HttpGet]
        public IHttpActionResult ObterLancamentos()
        {
            var result = _livroRepositorio.ObterLancamentos();
            return Ok(result);
        }

        [Route("")]
        public IHttpActionResult Post(Livro livro)
        {
            _livroRepositorio.Criar(livro);
            return Ok();
        }

        
        [Route("{isbn}")]
        [HttpPut]
        public HttpResponseMessage Put (int isbn, Livro livro)
        {
            if (isbn != livro.Isbn)
                return Request.CreateResponse(HttpStatusCode.BadRequest,
                    new { mensagens = new string[] { "Ids não conferem" } });

            if (!_livroRepositorio.VerificaSeLivroExiste(isbn))
                return Request.CreateResponse(HttpStatusCode.NotFound,
                    new { mensagens = new string[] { "Livro não encontrado" } });

            _livroRepositorio.Alterar(livro);

            return Request.CreateResponse(HttpStatusCode.OK);
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
