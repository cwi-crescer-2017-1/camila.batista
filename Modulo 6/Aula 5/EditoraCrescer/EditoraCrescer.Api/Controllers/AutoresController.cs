using EditoraCrescer.Infraesturtura.Entidades;
using EditoraCrescer.Infraesturtura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Http;

namespace EditoraCrescer.Api.Controllers
{
    [RoutePrefix("api/Autor")]
    public class AutoresController : ApiController
    {
        private AutoresRepositorio _autoresRepositorio = new AutoresRepositorio();

        [Route("")]
        [HttpGet]
        public IHttpActionResult Obter()
        {
            var autores = _autoresRepositorio.Obter();
            return Ok(autores);
        }
        
        [Route("{id}")]
        [HttpGet]
        public IHttpActionResult ObterPorId(int id)
        {
            var autores = _autoresRepositorio.ObterPorId(id);
            return Ok(autores);
        }
        
        [Route("{id}/Livros")]
        [HttpGet]
        public IHttpActionResult ObterLivrosDeAutor(Autor autor)
        {
            var livros = _autoresRepositorio.ObterLivros(autor);
            return Ok(livros);
        }

        [Route("")]
        public IHttpActionResult Post(Autor autor)
        {
            _autoresRepositorio.Criar(autor);
            return Ok();
        }

        [Route("{id: int}")]
        [HttpPut]
        public IHttpActionResult Put (int id, Autor autor)
        {
            if (id != autor.Id)
                return Request.CreateResponse(HttpStatusCode.BadRequest,
                    new { mensagens = new string[] { "Ids não conferem" } });

            if (!_autoresRepositorio.VerificaSeAutorExiste(id))
                return Request.CreateResponse(HttpStatusCode.NotFound,
                    new { mensagens = new string[] { "Autor não encontrado" } });

            _autoresRepositorio.Alterar(autor);

            return Request.CreateResponse(HttpStatusCode.OK);
        }
        

        [Route("{id}")]
        [HttpDelete]
        public IHttpActionResult Delete (int id)
        {
            _autoresRepositorio.Remover(id);
            return Ok();
        }
    }
}
