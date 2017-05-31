using EditoraCrescer.Infraesturtura.Entidades;
using EditoraCrescer.Infraesturtura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace EditoraCrescer.Api.Controllers
{
    public class RevisoresController : ApiController
    {
        private RevisoresRepositorio _revisoresRepositorio = new RevisoresRepositorio();

        public IHttpActionResult Get()
        {
            var revisores = _revisoresRepositorio.Obter();
            return Ok(revisores);
        }

        public IHttpActionResult Post(Revisor revisor)
        {
            _revisoresRepositorio.Criar(revisor);
            return Ok();
        }

        public IHttpActionResult Delete(int id)
        {
            _revisoresRepositorio.Remover(id);
            return Ok();
        }
    }
}
