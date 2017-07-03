/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entidades.Comentario;
import Repositorio.ComentarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

/**
 *
 * @author camila.batista
 */
@Service
public class ComentarioService {
    
    @Autowired
    private ComentarioRepositorio repositorio;
    
    @Autowired
    private PostService postService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    public Comentario save(Comentario comentario, User user, Long id) throws Exception{
        comentario.setPost(postService.findById(id));
        comentario.setUsuario(usuarioService.findByEmail(user.getUsername()));
        return repositorio.save(comentario);
    }
    
    public void delete(Long id){
        repositorio.delete(id);
    }
}
