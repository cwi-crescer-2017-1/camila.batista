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
    [RoutePrefix("api/pedido")]
    public class PedidoController : ApiController
    {
        readonly PedidoRepositorio _pedidoRepositorio;

        public PedidoController()
        {
            _pedidoRepositorio = new PedidoRepositorio();
        }

        [HttpGet]
        public IHttpActionResult Obter()
        {
            var pedido = _pedidoRepositorio.GetAll();
            return Ok(pedido);
        }

        [HttpGet]
        [Route("{id}")]
        public IHttpActionResult ObterPorId(int id)
        {
            var pedido = _pedidoRepositorio.GetById(id);
            return Ok(pedido);
        }

        [HttpPut]
        public void Adicionar(Pedido pedido)
        {
            _pedidoRepositorio.Insert(pedido);
        }

        [HttpDelete]
        public void Apagar(Pedido pedido)
        {
            _pedidoRepositorio.Delete(pedido);
        }
    }
}
