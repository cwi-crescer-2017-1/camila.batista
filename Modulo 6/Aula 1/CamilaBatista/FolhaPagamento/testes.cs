using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FolhaPagamento
{
    [TestClass]
    public class testes
    {
        public const double MargemErro = 0.01;

        [TestMethod]
        public void Validar_Demonstrativo_Industria_Salario_1000()
        {
            int horasCategoria = 200;
            double salarioBase = 1000;
            double horasExtras = 0;
            double horasDescontadas = 0;

            var folhaPagamento = new FolhaPagamento();
            var demonstrativo = folhaPagamento.GerarDemonstrativo(horasCategoria, salarioBase, horasExtras, horasDescontadas);

            var quantidadeHorasExtrasEsperado = 0;
            var valorTotalHorasExtrasEsperado = 0;
            var quantidadeHorasDescontadasEsperado = 0;
            var valorTotalHorasDescontadasEsperado = 0;
            var totalProventosEsperado = 1000;
            var inssAliquotaEsperado = 8;
            var inssValorEsperado = 80;
            var irrfAliquotaEsperado = 0;
            var irrfValorEsperado = 0;
            var totalDescontosEsperado = 80;
            var totalLiquidoEsperado = 920;
            var fgtsAliquotaEsperado = 11;
            var fgtsValorEsperado = 110;

            Assert.AreEqual(salarioBase, demonstrativo.SalarioBase, MargemErro);
            Assert.AreEqual(quantidadeHorasExtrasEsperado, demonstrativo.HorasExtras.QtdHoras, MargemErro);
            Assert.AreEqual(valorTotalHorasExtrasEsperado, demonstrativo.HorasExtras.ValorTotalHoras, MargemErro);
            Assert.AreEqual(quantidadeHorasDescontadasEsperado, demonstrativo.HorasDescontadas.QtdHoras, MargemErro);
            Assert.AreEqual(valorTotalHorasDescontadasEsperado, demonstrativo.HorasDescontadas.ValorTotalHoras, MargemErro);
            Assert.AreEqual(totalProventosEsperado, demonstrativo.TotalProventos, MargemErro);
            Assert.AreEqual(inssAliquotaEsperado, demonstrativo.Inss.Aliquota, MargemErro);
            Assert.AreEqual(inssValorEsperado, demonstrativo.Inss.Valor, MargemErro);
            Assert.AreEqual(irrfAliquotaEsperado, demonstrativo.Irrf.Aliquota, MargemErro);
            Assert.AreEqual(irrfValorEsperado, demonstrativo.Irrf.Valor, MargemErro);
            Assert.AreEqual(totalDescontosEsperado, demonstrativo.TotalDescontos, MargemErro);
            Assert.AreEqual(totalLiquidoEsperado, demonstrativo.TotalLiquido, MargemErro);
            Assert.AreEqual(fgtsAliquotaEsperado, demonstrativo.Fgts.Aliquota, MargemErro);
            Assert.AreEqual(fgtsValorEsperado, demonstrativo.Fgts.Valor, MargemErro);
        }

        [TestMethod]
        public void Validar_Demonstrativo_Industria_Salario_5000_HrE50_HrD10()
        {
            int horasCategoria = 200;
            double salarioBase = 5000;
            double horasExtras = 50;
            double horasDescontadas = 10;

            var folhaPagamento = new FolhaPagamento();
            var demonstrativo = folhaPagamento.GerarDemonstrativo(horasCategoria, salarioBase, horasExtras, horasDescontadas);

            var quantidadeHorasExtrasEsperado = 50;
            var valorTotalHorasExtrasEsperado = 1250;
            var quantidadeHorasDescontadasEsperado = 10;
            var valorTotalHorasDescontadasEsperado = 250;
            var totalProventosEsperado = 6000;
            var inssAliquotaEsperado = 0.10;
            var inssValorEsperado = 600;
            var irrfAliquotaEsperado = 0.275;
            var irrfValorEsperado = 1485;
            var totalDescontosEsperado = 2085;
            var totalLiquidoEsperado = 3915;
            var fgtsAliquotaEsperado = 0.11;
            var fgtsValorEsperado = 660;

            Assert.AreEqual(demonstrativo.SalarioBase, salarioBase);
            Assert.AreEqual(demonstrativo.HorasExtras.QtdHoras, quantidadeHorasExtrasEsperado);
            Assert.AreEqual(demonstrativo.HorasExtras.ValorTotalHoras, valorTotalHorasExtrasEsperado);
            Assert.AreEqual(demonstrativo.HorasDescontadas.QtdHoras, quantidadeHorasDescontadasEsperado);
            Assert.AreEqual(demonstrativo.HorasDescontadas.ValorTotalHoras, valorTotalHorasDescontadasEsperado);
            Assert.AreEqual(demonstrativo.TotalProventos, totalProventosEsperado);
            Assert.AreEqual(demonstrativo.Inss.Aliquota, inssAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Inss.Valor, inssValorEsperado);
            Assert.AreEqual(demonstrativo.Irrf.Aliquota, irrfAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Irrf.Valor, irrfValorEsperado);
            Assert.AreEqual(demonstrativo.TotalDescontos, totalDescontosEsperado);
            Assert.AreEqual(demonstrativo.TotalLiquido, totalLiquidoEsperado);
            Assert.AreEqual(demonstrativo.Fgts.Aliquota, fgtsAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Fgts.Valor, fgtsValorEsperado);
        }
    }
}
