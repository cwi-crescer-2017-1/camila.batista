using System;
using System.Collections.Generic;
using System.Linq;
using System.Linq.Expressions;
using System.Text;
using System.Threading.Tasks;

namespace Veiculos.Infraestrutura.Repositorios
{
    public class BasicRepositorio<TEntity> where TEntity : class
    {
        public Contexto _dbContext = new Contexto();

        public BasicRepositorio()
        {
        }

        public void Insert(TEntity entity)
        {
            _dbContext.Set<TEntity>().Add(entity);
            _dbContext.SaveChanges();
        }

        public void Delete(TEntity entity)
        {
            _dbContext.Set<TEntity>().Remove(entity);
            _dbContext.SaveChanges();
        }

        //public IQueryable<TEntity> SearchFor(Expression<Func<TEntity, bool>> predicate)
        //{
        //    return _dbContext.Set<TEntity>().Where(predicate);
        //}

        public IQueryable<TEntity> SearchFor(Expression<Func<TEntity, bool>> predicate)
        {
            return _dbContext.Set<TEntity>().Where(predicate);
        }

        public IQueryable<TEntity> GetAll()
        {
            return _dbContext.Set<TEntity>();
        }

        public TEntity GetById(int id)
        {
            return _dbContext.Set<TEntity>().Find(id);
        }
    }
}
