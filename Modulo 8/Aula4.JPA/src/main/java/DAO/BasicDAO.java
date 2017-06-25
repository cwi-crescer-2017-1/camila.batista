/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import DAO.CrudDao;
/**
 *
 * @author Camila
 */
public class BasicDAO<T, ID> implements CrudDAO<T, ID>{
    
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER");
    private final EntityManager em = emf.createEntityManager();

    private final Session session;
    private Class<T> entity;

    
    public GenericDAO(Class<T> entity){
        this.entity = entity;
        em.getTransaction().begin();
        session = em.unwrap(Session.class);
    }
    
    @Override
    public T save(T e){
        session.saveOrUpdate(e);
        session.getTransaction().commit();
        session = em.unwrap(Session.class);
        
        return e;
    }
    
    @Override
    public void remove(T e){
        session.delete(e);
        session.getTransaction().commit();
    }
    
    @Override
    public T loadById(ID id){
        return em.find(entity, id);
    }
    
    @Override
    public List<T> findAll(){
        return session.createCriteria(entity).list();
    }
    
    public void close(){
        session.close();
        em.close();
        emf.close();
    }
}
