using EditoraCrescer.Infraesturtura;
using EditoraCrescer.Infraesturtura.Entidades;
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
        private LivrosRepositorio _livroRepositorio = new LivrosRepositorio();

        public IHttpActionResult Get()
        {
            var livros = _livroRepositorio.Obter();

            return Ok(livros);
        }

        public IHttpActionResult Post(Livro livro)
        {
            _livroRepositorio.Criar(livro);
            return Ok();
        }

        public IHttpActionResult Delete(int id)
        {
            _livroRepositorio.Remover(id);
            return Ok();
        }
    }
}