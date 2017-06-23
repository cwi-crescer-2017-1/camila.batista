
import Pojo.Cliente;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author camila.batista
 */
public class Main {
    public static void main(String[] args) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("MEGASENA");
	final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        
//        Cliente c1 = new Cliente();
//        c1.setNome("Pudim");
//        c1.setId((long)1);
        Cliente c1 = em.find(Cliente.class, 1L);

        System.out.println(c1.getNome());
        
        em.persist(c1);
        
        
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
