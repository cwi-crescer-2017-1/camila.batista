/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio;

import Entidades.Usuario;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author camila.batista
 */
public interface UsuarioRepositorio extends CrudRepository<Usuario, Long>{

    public Usuario findByEmail(String email);

    public List<Usuario> findByNome(String nome);
    
}
