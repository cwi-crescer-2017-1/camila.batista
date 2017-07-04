/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio;

import Entidades.Post;
import Entidades.Usuario;
import java.awt.print.Pageable;
import java.util.List;
import java.util.Set;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author camila.batista
 */
public interface PostRepositorio extends PagingAndSortingRepository<Post, Long>{

    public List<Post> findByUsuarioOrder(Set<Usuario> amigos, Pageable pageable);

    public Page<Post> findAll(Pageable pageable);
    
}
