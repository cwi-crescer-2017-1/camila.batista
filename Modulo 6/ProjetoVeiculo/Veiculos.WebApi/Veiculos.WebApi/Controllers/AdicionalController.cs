using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using Veiculos.Infraestrutura.Repositorios;

namespace Veiculos.WebApi.Controllers
{
    [RoutePrefix("api/adicional")]
    public class AdicionalController : ApiController
    {
        readonly AdicionalRepositorio _adicionalRepositorio;

        public AdicionalController()
        {
            _adicionalRepositorio = new AdicionalRepositorio();
        }

        [HttpGet]
        public IHttpActionResult Obter()
        {
            var adicionais = _adicionalRepositorio.Obter();
            return Ok(adicionais);
        }

        [HttpGet]
        [Route("{id : int}")]
        public IHttpActionResult ObterPorId(int id)
        {
            var adicionais = _adicionalRepositorio.ObterPorId(id);
            return Ok(adicionais);
        }
        
    }
}
