/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entidades.Curtir;
import Entidades.Post;
import Entidades.Usuario;
import Service.CurtirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author camila.batista
 */
@RestController
public class CurtirController {
    
    @Autowired
    private CurtirService curtirService;
    
    @PostMapping(value = "/like/{id}")
    public Curtir curtir(@RequestBody Curtir curtir, @AuthenticationPrincipal User user, @PathVariable Long id) throws Exception{
        return curtirService.curtir(curtir, user, id);
    }
    
    @PostMapping(value = "/descurtir/{id}")
    public void descurtir(Curtir curtir) throws Exception{
        curtirService.descurtir(curtir);
    }
}
