﻿using EditoraCrescer.Infraesturtura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraesturtura.Repositorios
{
    public class RevisoresRepositorio
    {
        private Contexto contexto = new Contexto();

        public List<Revisor> Obter()
        {
            return contexto.Revisores.ToList();
        }

        public List<Revisor> ObterPorId(int id)
        {
            return contexto.Revisores.Where(x => x.Id == id).ToList();
        }

        public void Criar(Revisor revisor)
        {
            contexto.Revisores.Add(revisor);
            contexto.SaveChanges();
        }

        
        //PUT


        public void Remover(int id)
        {
            var revisor = contexto.Revisores.FirstOrDefault(x => x.Id == id);
            contexto.Revisores.Remove(revisor);
            contexto.SaveChanges();
        }

        
    }
}
