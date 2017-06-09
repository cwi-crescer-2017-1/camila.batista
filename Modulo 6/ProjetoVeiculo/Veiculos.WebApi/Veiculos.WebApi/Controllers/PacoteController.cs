using AutDemo.WebApi;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using Veiculos.Dominio.Entidades;
using Veiculos.Infraestrutura.Repositorios;

namespace Veiculos.WebApi.Controllers
{
    [RoutePrefix("api/pacote")]
    [BasicAuthorization]
    public class PacoteController : ApiController
    {
        readonly PacoteRepositorio _pacoteRepositorio;

        public PacoteController()
        {
            _pacoteRepositorio = new PacoteRepositorio();
        }

        [HttpGet]
        public IHttpActionResult Obter()
        {
            var pacotes = _pacoteRepositorio.GetAll();
            return Ok(pacotes);
        }

        [HttpGet]
        [Route("{id}")]
        public IHttpActionResult ObterPorId(int id)
        {
            var pacotes = _pacoteRepositorio.GetById(id);
            return Ok(pacotes);
        }

        [HttpPut]
        public void Adicionar(Pacote pacote)
        {
            _pacoteRepositorio.Insert(pacote);
        }

        [HttpDelete]
        public void Apagar(Pacote pacote)
        {
            _pacoteRepositorio.Delete(pacote);
        }
    }
}
