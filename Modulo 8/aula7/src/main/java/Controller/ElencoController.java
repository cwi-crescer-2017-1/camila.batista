/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Pojo.Classificacao;
import Pojo.Elenco;
import Service.ClassificacaoService;
import Service.ElencoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Camila
 */
@RequestMapping(value = "/elenco")
public class ElencoController {
    
    @Autowired
    ElencoService service; 
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Elenco> list(){
        return service.list();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Elenco findById(@PathVariable Long id){
        return service.findById(id);
    }
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Elenco save(@RequestBody Elenco elenco){
        return service.save(elenco);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
