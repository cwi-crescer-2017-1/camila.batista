using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Veiculos.Infraestrutura.Repositorios
{
    public class AdicionalRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();



        public void Dispose()
        {
            contexto.Dispose();
        }

        public object Obter()
        {
            throw new NotImplementedException();
        }

        public object ObterPorId(int id)
        {
            throw new NotImplementedException();
        }
    }
}
