/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entidades.Usuario;
import Repositorio.UsuarioRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author camila.batista
 */
@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepositorio repositorio;
    
    public List<Usuario> list(){
        return (List<Usuario>) repositorio.findAll();
    }
    
    public Usuario listId(Long id){
        return repositorio.findOne(id);
    }
    
    public Usuario save(Usuario usuario){
        return repositorio.save(usuario);
    }
    
    public void delete(Long id){
        repositorio.delete(id);
    }
}
