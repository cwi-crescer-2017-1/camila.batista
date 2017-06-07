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
    [RoutePrefix("api/Cliente")]
    public class ClienteController : ApiController
    {

        readonly ClienteRepositorio _clienteRepositorio;

        public ClienteController()
        {
            _clienteRepositorio = new ClienteRepositorio();
        }

        [HttpGet]
        public IHttpActionResult Obter()
        {
            var clientes = _clienteRepositorio.GetAll();
            return Ok(clientes);
        }

        [HttpGet]
        public IHttpActionResult ObterPorId(int id)
        {
            var clientes = _clienteRepositorio.GetById(id);
            return Ok(clientes);
        }

        [HttpPut]
        public void Adicionar(Cliente cliente)
        {
            _clienteRepositorio.Insert(cliente);
        }

        [HttpDelete]
        public void Apagar(Cliente cliente)
        {
            _clienteRepositorio.Delete(cliente);
        }
    }
}
