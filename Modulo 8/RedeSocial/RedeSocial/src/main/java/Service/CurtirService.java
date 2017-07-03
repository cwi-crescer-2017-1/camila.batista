/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entidades.Curtir;
import Entidades.Post;
import Entidades.Usuario;
import Repositorio.CurtirRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

/**
 *
 * @author camila.batista
 */
public class CurtirService {
    
    @Autowired
    private CurtirRepositorio curtirRepositorio;
    
    @Autowired
    private PostService postService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    public Curtir curtir(Curtir curtir, User user, Long idPost) throws Exception{
        curtir.setPost(postService.findById(idPost));
        curtir.setUsuarioCurtida(usuarioService.findByEmail(user.getName()));
        return curtirRepositorio.save(curtir);
    }
    
    
//    public void curtir(Long idPost, Long idUsuario){
//        if(curtirRepositorio.findOne(idUsuario) == null || curtirRepositorio.findOne(idPost) == null){
//            Curtir curtir = new Curtir();
//            Post post = new Post();
//            Usuario usuario = usuarioService.findById(idUsuario);
//            curtir.setId(post.getId());
//            curtirRepositorio.save(curtir);
//        }
//    }
    
    public void descurtir(Long idPost, Long idUsuario){
        if(curtirRepositorio.findOne(idUsuario) == null || curtirRepositorio.findOne(idPost) == null){
            Curtir curtir = new Curtir();
            curtirRepositorio.delete(curtir.getId());
        }
    }    
}
