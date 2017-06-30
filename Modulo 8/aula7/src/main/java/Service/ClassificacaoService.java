/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Pojo.Classificacao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Camila
 */
@Service
public class ClassificacaoService {
    
    @Autowired
    private ClassificacaoService repositorio;
    
    
    public List<Classificacao> list(){
        return (List<Classificacao>) repositorio.list();
    }
    
    public Classificacao findById(Long id){
        return repositorio.findById(id);
    }
    
    public Classificacao save(Classificacao classificacao){
        return repositorio.save(classificacao);
    }
    
    public void delete(Long id){
        repositorio.delete(id);
    }
}
