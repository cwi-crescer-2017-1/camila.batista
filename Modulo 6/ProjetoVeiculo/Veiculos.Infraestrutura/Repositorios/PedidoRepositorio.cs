using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Veiculos.Dominio.Entidades;

namespace Veiculos.Infraestrutura.Repositorios
{
    public class PedidoRepositorio : BasicRepositorio<Pedido>
    {
        public PedidoRepositorio() { }

        public List<Pedido> obetRelatorioMensal(int mes)
        {
            return _dbContext.Set<Pedido>().Include("adicionais").Include("funcionario").Include("cliente").Include("produto").Include("pacote").Where(x => x.DataInicial.Month == mes).ToList(); 
        }

        //public override List<Pedido> GetAll()
        //{
        //    return _dbContext.Set<Pedido>().Include("adicionais").Include("funcionario").Include("cliente").Include("produto").Include("pacote").ToList();
        //}

        //public List<Pedido> obter()
        //{
        //    return _dbContext.Set<Pedido>().Include("adicionais").Include("funcionario").Include("cliente").Include("produto").Include("pacote").ToList();
        //}
    }
}
