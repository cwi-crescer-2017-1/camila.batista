using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Veiculos.Dominio.Entidades;

namespace Veiculos.Infraestrutura.Repositorios
{
    public class FuncionarioRepositorio : BasicRepositorio<Funcionario>
    {
        public FuncionarioRepositorio() { }

        private readonly Contexto _dbContext = new Contexto();

        public Funcionario GetLogin(string login)
        {
            return _dbContext.Funcionarios.FirstOrDefault(x => x.Login == login);
        }
    }
}
