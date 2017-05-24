using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace demo1
{
    class Program
    {

        static void Main(string[] args)
        {
            Console.WriteLine("Hello");
            Console.ReadLine();

            Pessoa p1 = new Pessoa();
            p1.id = null;
            p1.dataNascimento = new DateTime(1882, 10, 03);
            p1.nome = $"Alguem {p1.id}";

            if (p1.id == null)
            {
                Console.WriteLine(p1.nome);
                Console.ReadLine();
            }
            var p2 = new Pessoa();


            Console.WriteLine("Peso");
            var peso = Console.ReadLine();
            Console.WriteLine("Altura");
            var altura = Console.ReadLine();


            var calculo = new CalculoIMC(double.Parse(peso), double.Parse(altura));

            Console.WriteLine(calculo.CalcularIMC());
            Console.ReadKey();

            List<int> arrayList = new List<int>();

            bool entrada = true;
            while(entrada)
            {
                Console.WriteLine("Digite um valor");
                var lida = Console.ReadLine();

                if(lida == "exit")
                {
                    break;
                }
 
                arrayList.Add(int.Parse(lida));    
            }

            foreach(var e in arrayList)
            {
                Console.WriteLine(e);

            }
            Console.ReadKey();
        }
    }
}
