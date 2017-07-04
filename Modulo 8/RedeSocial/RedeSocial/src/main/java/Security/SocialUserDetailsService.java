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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author camila.batista
 */
@Service
public class SocialUserDetailsService implements UserDetailsService {

    @Autowired
    UsuarioService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> grants = new ArrayList<>();
        Usuario usuario = new Usuario();
        try {
            usuario = service.findByEmail(username);
        } catch (Exception ex) {
            Logger.getLogger(SocialUserDetailsService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new User(usuario.getEmail(),usuario.getSenha(),grants);
    }

}
