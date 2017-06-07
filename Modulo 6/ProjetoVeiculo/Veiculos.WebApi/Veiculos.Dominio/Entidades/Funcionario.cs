using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
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

        static readonly char[] _caracteresNovaSenha = "abcdefghijklmnopqrstuvzwyz1234567890*-_".ToCharArray();

        static readonly int _numeroCaracteresNovaSenha = 10;

        public Funcionario() { }

        public Funcionario(string nome, Tipo cargo, string login, string senha)
        {
            Nome = nome;
            Cargo = cargo;
            Login = login;
            Senha = senha;
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

        public string ResetarSenha()
        {
            var senha = string.Empty;
            for (int i = 0; i < Senha.Length; i++)
            {
                senha += new Random().Next(0, _caracteresNovaSenha.Length);
            }

            Senha = CriptografarSenha(senha);

            return senha;
        }

        private string CriptografarSenha(string senha)
        {
            MD5 md5 = MD5.Create();
            byte[] inputBytes = Encoding.Default.GetBytes(Login + senha);
            byte[] hash = md5.ComputeHash(inputBytes);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < hash.Length; i++)
                sb.Append(hash[i].ToString("x2"));

            return sb.ToString();
        }

        public bool ValidarSenha(string senha)
        {
            return CriptografarSenha(senha) == Senha;
        }
    }
}
