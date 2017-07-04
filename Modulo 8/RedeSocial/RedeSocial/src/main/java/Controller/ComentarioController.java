/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entidades.Comentario;
import Service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author camila.batista
 */
@RestController
public class ComentarioController {
    
    @Autowired
    private ComentarioService comentarioService;
    
    @PostMapping(value = "/comentarios")
    public Comentario adicionarComentario(@RequestBody Comentario comentario, @AuthenticationPrincipal User user, @PathVariable Long id) throws Exception{
        return comentarioService.save(comentario, user, id);
    }
}
