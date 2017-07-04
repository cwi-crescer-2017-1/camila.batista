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
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    
    public String criptografar(Usuario usuario){
        usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
        return usuario.getSenha();
    }
    
    public String getCriptografia(String senha){
        return new BCryptPasswordEncoder().encode(senha);
    }
    
    public boolean getSenhaLogin(String senha, Usuario usuario){
        if(getCriptografia(senha).equals(usuario.getSenha())){
            return true;
        }else{
            return false;
        }
    }
    
    public Usuario findByEmail(String email) throws Exception{
        if(email.trim().length() == 0){
            throw new Exception ("Impossivel cadastrar com um email vazio");
        }else{
            return repositorio.findByEmail(email);
        }
    }
    
    //Procura amigos
    
    @Query("select * from usuario where nome like ':nome%' or email like ':nome%'")
    public List<Usuario> findByNome(String nome){
       return (List<Usuario>) repositorio.findAll();
    }
    
    public Usuario findById(Long id){
        return repositorio.findOne(id);
    }
    
    public Usuario save(Usuario usuario) throws Exception{
        if(findByEmail(usuario.getEmail()) == null){
            criptografar(usuario);
        }else{
            throw new Exception("Email já cadastrado");
        }
        return repositorio.save(usuario);
    }
    
    public Usuario update(Usuario usuario) throws Exception{    
        if(usuario == null){
            throw new Exception("Usuário não encontrado");
        }
        
        //Altera a senha
        if(usuario.getSenha() == null){
            usuario.setSenha(usuario.getSenha());
        }else{
            criptografar(usuario);
        }
        
        return repositorio.save(usuario);
    }
    
    public void delete(Long id){
        repositorio.delete(id);
    }
    
    public void enviarConvite(Usuario us1, Usuario us2) throws Exception{
        us2.getConvites().add(us1);
        update(us2);
    }
    
    public void aceitarConvite(Usuario us1, Usuario us2) throws Exception{
        us1.getConvites().remove(us2);
        us1.getAmigos().add(us2);
        us2.getAmigos().add(us1);
        update(us1);
        update(us2);
    }
    
    public void rejeitarConvite (Usuario us1, Usuario us2) throws Exception{
        us1.getConvites().remove(us2);
        update(us1);
    }
    
    public void removerAmizade (Usuario us1, Usuario us2) throws Exception{
        us1.getAmigos().remove(us2);
        us2.getAmigos().remove(us1);
        update(us1);
        update(us2);
    }
}
