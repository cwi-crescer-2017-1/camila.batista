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
    [RoutePrefix("api/funcionario")]
    public class FuncionarioController : ApiController
    {
        readonly FuncionarioRepositorio _funcionarioRepositorio;

        public FuncionarioController()
        {
            _funcionarioRepositorio = new FuncionarioRepositorio();
        }

        [HttpGet]
        public IHttpActionResult Obter()
        {
            var funcionarios = _funcionarioRepositorio.GetAll();
            return Ok(funcionarios);
        }

        [HttpGet]
        [Route("{id}")]
        public IHttpActionResult ObterPorId(int id)
        {
            var funcionarios = _funcionarioRepositorio.GetById(id);
            return Ok(funcionarios);
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
