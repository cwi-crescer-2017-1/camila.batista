/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Pojo.Classificacao;
import Service.ClassificacaoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Camila
 */
@RestController
@RequestMapping(value = "/classificacao")
public class ClassificacaoController {
    
    @Autowired
    ClassificacaoService service; 
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Classificacao> list(){
        return service.list();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Classificacao findById(@PathVariable Long id){
        return service.findById(id);
    }
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Classificacao save(@RequestBody Classificacao classificacao){
        return service.save(classificacao);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
