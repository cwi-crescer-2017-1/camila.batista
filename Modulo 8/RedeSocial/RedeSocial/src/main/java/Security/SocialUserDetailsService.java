/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Security;

import Entidades.Usuario;
import Service.UsuarioService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Camila
 */
@Service
public class SocialUserDetailsService implements UserDetailsService{

    @Autowired
    private UsuarioService service;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = service.findByEmail(username);
        final List<GrantedAuthority> grants = new ArrayList<>();
        grants.add(() -> "ROLE_USER");
        return new User(usuario.getEmail(), usuario.getSenha(), grants);
    
    }    
}
