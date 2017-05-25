using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FolhaPagamento
{
    public class FolhaPagamento : IFolhaPagamento
    {
        public Demonstrativo GerarDemonstrativo(int horasCategoria, double salarioBase, double horasExtras, double horasDescontadas)
        {
            double valorHora = salarioBase / horasCategoria;
            HorasCalculadas extras = new HorasCalculadas(horasExtras, Math.Round((valorHora * horasExtras), 2));
            HorasCalculadas descontadas = new HorasCalculadas(horasDescontadas, Math.Round((valorHora * horasDescontadas), 2));
            double totalProventos = Math.Round((salarioBase + extras.ValorTotalHoras - descontadas.ValorTotalHoras), 2);
            Desconto inss = INSS(totalProventos);
            Desconto irrf = IRRF(totalProventos, inss);
            Desconto fgts = FGTS(totalProventos);
            double totalDescontos = Math.Round((inss.Valor + fgts.Valor), 2);
            double salarioLiquido = Math.Round((salarioBase - totalDescontos), 2);


            Demonstrativo d = new Demonstrativo(
                Math.Round(salarioBase, 2),
                horasCategoria,
                extras,
                descontadas,
                totalProventos,
                inss,
                irrf,
                totalDescontos,
                salarioLiquido,
                fgts);
            return d;
        }


        private static Desconto INSS(double TotalProventos)
        {
            double a = 0;
            if (TotalProventos <= 1000)
            {
                a = 0.08;
            }
            else if (TotalProventos <= 1500)
            {
                a = 0.09;
            }
            else
            {
                a = 0.10;
            }

            return new Desconto(a, Math.Round(((TotalProventos * a) / 100), 2));
        }

        public static Desconto IRRF(double TotalProventos, Desconto INSS)
        {
            double a = 0;
            double v = TotalProventos - INSS.Valor;

            if (v <= 1710.78)
            {
                new Desconto(0, 0);
            }
            else if (v <= 2563.91)
            {
                a = 0.075;
            }
            else if (a <= 3418.59)
            {
                a = 0.15;
            }
            else if (a <= 4271.59)
            {
                a = 0.225;
            }
            else
            {
                a = 0.275;
            }

            return new Desconto(a, Math.Round(((v * a) / 100), 2));
        }

        private static Desconto FGTS (double TotalProventos)
        {
            return new Desconto(0.11, Math.Round((TotalProventos * 0.11) / 100, 2));
        }
    }
}
