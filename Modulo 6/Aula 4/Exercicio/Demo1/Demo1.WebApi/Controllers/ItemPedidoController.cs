using Demo1.Dominio.Entidades;
using Demo1.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Http;
using System.Web.Mvc;

namespace Demo1.WebApi.Controllers
{
    public class ItemPedidoController : ApiController
    {
        ItemPedidoRepositorio _itemPedidoRepositorio = new ItemPedidoRepositorio();

        public IHttpActionResult Post(ItemPedido itemPedido)
        {
            var mensagens = new List<string>();
            if (!itemPedido.Validar(out mensagens))
            {
                return BadRequest(string.Join(".", mensagens.ToArray()));
            }

            _itemPedidoRepositorio.Criar(itemPedido);
            return Ok(itemPedido);
        }

        public IHttpActionResult Put(ItemPedido itemPedido)
        {
            var mensagens = new List<string>();
            if(!itemPedido.Validar(out mensagens))
            {
                return BadRequest(string.Join(".", mensagens.ToArray()));
            }

            _itemPedidoRepositorio.Alterar(itemPedido);
            return Ok(itemPedido);
        }

        public IHttpActionResult Get()
        {
            return Ok(_itemPedidoRepositorio.Listar());
        }

        public IHttpActionResult Get(int id)
        {
            return Ok(_itemPedidoRepositorio.Obter(id));
        }

        public IHttpActionResult Delete(int id)
        {
            _itemPedidoRepositorio.Excluir(id);
            return Ok();
        }
    }
}