using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Veiculos.Dominio.Enum;

namespace Veiculos.Dominio.Entidades
{
    public class Funcionario
    {
        public int Id { get; private set; }

        public string Nome { get; set; }

        public Tipo Cargo { get; set; }

        public string Login { get; set; }

        public string Senha { get; set; }

        public Funcionario() { }

        public Funcionario(string nome, Tipo cargo, string login, string senha)
        {
            Nome = nome;
            Cargo = cargo;
            Login = login;
            Senha = senha;

            if (Cargo.Equals(1))
            {
                cargo = Tipo.ADMINISTRADOR;
            }
            else if (Cargo.Equals(2))
            {
                cargo = Tipo.OPERADOR;
            }
        }

        List<string> mensagens = new List<string>();

        public bool Validar()
        {
            mensagens.Clear();

            if (Nome.Length == 0 || Nome.Length > 100)
            {
                mensagens.Add("Nome digitado invalido");
            }

            if(Login.Length == 0 || Senha.Length == 0)
            {
                mensagens.Add("Impossivel fazer login, tente novamente");
            }

            return mensagens.Count() > 0 ? true : false;
        }
    }
}
