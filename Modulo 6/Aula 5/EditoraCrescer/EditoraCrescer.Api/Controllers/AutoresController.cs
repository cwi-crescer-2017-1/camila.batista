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
    public class AutoresController : ApiController
    {
        private AutoresRepositorio _autoresRepositorio = new AutoresRepositorio();

        public IHttpActionResult Get()
        {
            var autores = _autoresRepositorio.Obter();
            return Ok(autores);
        }

        public IHttpActionResult Post(Autor autor)
        {
            _autoresRepositorio.Criar(autor);
            return Ok();
        }

        public IHttpActionResult Delete (int id)
        {
            _autoresRepositorio.Remover(id);
            return Ok();
        }
    }
}