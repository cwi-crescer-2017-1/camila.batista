/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entidades.Post;
import Service.PostService;
import java.awt.print.Pageable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author camila.batista
 */
@RestController
public class PostController {
    
    @Autowired
    private PostService postService;

// ESSA COISA NAO FUNCIONA    
//    @PostMapping(value = "/post")
//    public void novoPost(@RequestBody Post post, @AuthenticationPrincipal User user){
//        postService.save(post, user);
//    }
    
    @GetMapping(value = "/post/{id}")
    public List<Post> postUsuario(@PathVariable Long id){
        return postService.postUsuario(id);
    }
    
    //Descomentar quando adicionar os amigos
//    @GetMapping(value = "post/feed")
//    public List<Post> getPosts(@AuthenticationPrincipal User user, Pageable pageable){
//        return postService.getPosts(user, pageable);
//    }
}
