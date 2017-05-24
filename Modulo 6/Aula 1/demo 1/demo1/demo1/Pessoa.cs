using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace demo1
{
    public class Pessoa
    {
        public const double PI = 3.14;

        public readonly double PIreadonly = 3.14;

        public Pessoa()
        {
            PIreadonly = 3.143;
        }    

        public string nome { get; set; }

        public int? id { get; set; }

        public DateTime dataNascimento { get; set; }

    }
}
