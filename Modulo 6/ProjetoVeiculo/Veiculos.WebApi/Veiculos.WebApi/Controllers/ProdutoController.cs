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
    [RoutePrefix("api/produto")]
    public class ProdutoController : ApiController
    {
        readonly ProdutoRepositorio _produtoRepositorio;

        public ProdutoController()
        {
            _produtoRepositorio = new ProdutoRepositorio();
        }

        [HttpGet]
        public IHttpActionResult Obter()
        {
            var produtos = _produtoRepositorio.GetAll();
            return Ok(produtos);
        }

        [HttpGet]
        [Route("{id}")]
        public IHttpActionResult ObterPorId(int id)
        {
            var produtos = _produtoRepositorio.GetById(id);
            return Ok(produtos);
        }

        [HttpPut]
        public void Adicionar(Produto produto)
        {
            _produtoRepositorio.Insert(produto);
        }

        [HttpDelete]
        public void Apagar(Produto produto)
        {
            _produtoRepositorio.Delete(produto);
        }
    }
}
