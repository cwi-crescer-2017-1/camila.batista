/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Pojo.Ator;
import Service.AtorService;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author camila.batista
 */
@RestController
@RequestMapping(value = "/ator")
public class AtorController {

    @Autowired
    AtorService service;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Ator> list() {
        return service.list();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Ator findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @ResponseBody()
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Ator save(@RequestBody Ator ator) {
        return service.save(ator);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        service.remove(id);
    }
}
