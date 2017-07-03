/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entidades.Post;
import Entidades.Usuario;
import Repositorio.PostRepositorio;
import java.awt.print.Pageable;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.userdetails.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 *
 * @author camila.batista
 */
@Service
public class PostService {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private PostRepositorio postRepositorio;
    
    public Page<Post> findAll(Pageable pageable){
        return postRepositorio.findAll(pageable);
    }

    public List<Post> findAll(){
        return (List<Post>) postRepositorio.findAll();
    }
    
    public Post findById(Long id){
        return postRepositorio.findOne(id);
    }
  
    //Descomentar quando criar os amigos
//    public List<Post> getPosts(User user, Pageable pageable) {
//        Set<Usuario> amigos = usuarioService.findByEmail(user.getUsername()).getAmigos();
//        return postRepositorio.findByUsuarioOrder(amigos, pageable);
//    }

    public List<Post> postUsuario(Long id) {
        return (List<Post>) usuarioService.findById(id).getPost();
    }
    
    public Post update(Post post){
        return postRepositorio.save(post);
    }

    public Post save(Post post, User user) throws Exception{
        Usuario uLogado = usuarioService.findByEmail(user.getUsername());
        post.setUsuario(uLogado);
        return postRepositorio.save(post);
    }
    
    public void delete(Long id){
        postRepositorio.delete(id);
    }
}
