using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Veiculos.Dominio.Enum;

namespace Veiculos.Dominio.Entidades
{
    public class Cliente
    {
        public int Id { get; private set; }

        public string Nome { get; set; }

        public string Endereco { get; set; }

        public string CPF { get; set; }

        public Genero Sexo { get; set; }

        public DateTime DataNascimento { get; set; }

        List<string> mensagens = new List<string>();

        public Cliente() { }

        public Cliente(string nome, string endereco, string cpf, Genero sexo, DateTime dataNascimento)
        {
            Nome = nome;
            Endereco = endereco;
            CPF = cpf;
            Sexo = sexo;
            DataNascimento = dataNascimento;

            if(Sexo.Equals(1))
            {
                sexo = Genero.FEMININO;
            }else if (Sexo.Equals(2))
            {
                sexo = Genero.MASCULINO;
            }
        }

        public bool Validar()
        {
            mensagens.Clear();

            if (Nome.Length == 0 || Nome.Length > 100)
            {
                mensagens.Add("Nome digitado invalido");
            }

            if(CPF.Length > 11)
            {
                mensagens.Add("CPF digitado invalido");
            }

            if (DataNascimento.Equals(DateTime.Now))
            {
                mensagens.Add("Data de nascimento inválida");
            }
            
            return mensagens.Count() > 0 ? true : false;
        }
    }
}
