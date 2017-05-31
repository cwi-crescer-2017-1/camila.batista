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

        
        //MÉTODO OBTERLIVRO NAO IMPLEMENTADO
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

        //POST

        [Route("{id}")]
        [HttpDelete]
        public IHttpActionResult Delete (int id)
        {
            _autoresRepositorio.Remover(id);
            return Ok();
        }
    }
}