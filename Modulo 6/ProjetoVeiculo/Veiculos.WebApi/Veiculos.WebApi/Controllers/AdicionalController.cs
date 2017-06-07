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
            var adicionais = _adicionalRepositorio.GetAll();
            return Ok(adicionais);
        }

        [HttpGet]
        [Route("{id}")]
        public IHttpActionResult ObterPorId(int id)
        {
            var adicionais = _adicionalRepositorio.GetById(id);
            return Ok(adicionais);
        }

        [HttpPut]
        public void Adicionar(Adicional adicional)
        {
            _adicionalRepositorio.Insert(adicional);

        }
        
        [HttpDelete]
        public void Deletar(Adicional adicional)
        {
            _adicionalRepositorio.Delete(adicional);
        }
    }
}
