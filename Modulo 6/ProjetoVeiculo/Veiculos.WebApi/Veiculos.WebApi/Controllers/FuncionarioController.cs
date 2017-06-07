using AutDemo.WebApi;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Threading;
using System.Web.Http;
using Veiculos.Dominio.Entidades;
using Veiculos.Infraestrutura.Repositorios;

namespace Veiculos.WebApi.Controllers
{
    [RoutePrefix("api/funcionario")]
    [BasicAuthorization]
    public class FuncionarioController : ApiController
    {
        FuncionarioRepositorio _funcionarioRepositorio;

        public FuncionarioController()
        {
            _funcionarioRepositorio = new FuncionarioRepositorio();
        }

        [HttpGet]
        [Route("{id}")]
        public IHttpActionResult ObterPorId(int id)
        {
            var funcionarios = _funcionarioRepositorio.GetById(id);
            return Ok(funcionarios);
        }

        [HttpGet]
        public IHttpActionResult Obter()
        {
            var funcionario = _funcionarioRepositorio.GetLogin(Thread.CurrentPrincipal.Identity.Name);
            if (funcionario == null)
            {
                return BadRequest();
            }
            return Ok(funcionario);
        }

        [HttpPut]
        public void Adicionar(Funcionario funcionario)
        {
            _funcionarioRepositorio.Insert(funcionario);
        }

        [HttpDelete]
        public void Apagar(Funcionario funcionario)
        {
            _funcionarioRepositorio.Delete(funcionario);
        }
    }
}
