/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import DAO.CrudDao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;
/**
 *
 * @author Camila
 */
public abstract class BasicDAO<T, ID> implements CrudDao<T, ID>{
    
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER");
    private final EntityManager em = emf.createEntityManager();

    private Session session;
    private Class<T> entity;

    public BasicDAO(Class<T> entity){
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
