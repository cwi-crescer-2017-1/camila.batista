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
    [RoutePrefix("api/Revisor")]
    public class RevisoresController : ApiController
    {
        private RevisoresRepositorio _revisoresRepositorio = new RevisoresRepositorio();

        [Route("")]
        [HttpGet]
        public IHttpActionResult Obter()
        {
            var revisores = _revisoresRepositorio.Obter();
            return Ok(revisores);
        }
        [Route("{id}")]
        [HttpGet]
        public IHttpActionResult ObterPorId(int id)
        {
            var revisores = _revisoresRepositorio.ObterPorId(id);
            return Ok(revisores);
        }

        [Route("")]
        [HttpPost]
        public IHttpActionResult Post(Revisor revisor)
        {
            _revisoresRepositorio.Criar(revisor);
            return Ok();
        }
       

        //PUT

        [Route("{id}")]
        [HttpDelete]
        public IHttpActionResult Delete(int id)
        {
            _revisoresRepositorio.Remover(id);
            return Ok();
        }
    }
}
