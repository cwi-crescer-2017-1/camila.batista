/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entidades.Usuario;
import Service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author camila.batista
 */
@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {
    
    @Autowired
    UsuarioService service;
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Usuario> list(){
        return service.list();
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Usuario findById(Long id){
        return service.findById(id);
    }
    
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Usuario save(Usuario usuario) throws Exception{
        return service.save(usuario);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(Long id){
        service.delete(id);
    }
}
