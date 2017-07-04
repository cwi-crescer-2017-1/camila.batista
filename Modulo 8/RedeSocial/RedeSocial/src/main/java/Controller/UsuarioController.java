/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entidades.Usuario;
import Service.UsuarioService;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public Usuario findById(@PathVariable Long id){
        return service.findById(id);
    }
    
    @RequestMapping(value = "/{usuario}", method = RequestMethod.GET)
    public List<Usuario> findByNome(String nome){
        return service.findByNome(nome);
    }
    
    @RequestMapping(value = "/{email}" ,method = RequestMethod.GET)
    public boolean login(String senha, Usuario usuario) throws Exception{
        if(service.getSenhaLogin(senha, usuario) && service.findByEmail(usuario.getEmail()) != null){
            return true;
        }else{
            return false;
        }
    }
    
    @GetMapping(value = "/amigos")
    public Set<Usuario> getAmigos(@AuthenticationPrincipal User user) throws Exception{
        return (Set<Usuario>) service.findByEmail(user.getUsername()).getAmigos();
    }
    
    @GetMapping(value = "/convites")
    public Set<Usuario> getConvites(@AuthenticationPrincipal User user) throws Exception{
        return (Set<Usuario>) service.findByEmail(user.getUsername()).getConvites();
    }
            
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Usuario save(Usuario usuario) throws Exception{
        return service.save(usuario);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(Long id){
        service.delete(id);
    }
    
    @PostMapping(value = "/update")
    public Usuario update(@RequestBody Usuario usuario, @AuthenticationPrincipal User user) throws Exception{
        Usuario us1 = service.findByEmail(user.getUsername());
        us1.setNome(usuario.getNome());
        us1.setSenha(usuario.getSenha());
        return service.update(us1);
    }
    
    @PostMapping(value = "/convite/aceitar/{id}")
    public void enviarConvite(@PathVariable Long id, @AuthenticationPrincipal User user) throws Exception{
        Usuario us1 = service.findByEmail(user.getUsername());
        Usuario us2 = service.findById(id);
        service.enviarConvite(us1, us2);
    }
    
    @PostMapping(value = "/convite/rejeitar/{id}")
    public void rejeitarConvite(@PathVariable Long id, @AuthenticationPrincipal User user) throws Exception{
        Usuario us1 = service.findByEmail(user.getUsername());
        Usuario us2 = service.findById(id);
        service.rejeitarConvite(us1, us2);
    }
    
    
    
}
