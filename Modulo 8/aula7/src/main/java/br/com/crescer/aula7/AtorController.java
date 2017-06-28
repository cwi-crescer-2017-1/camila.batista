/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
    
//    @RequestMapping()
//    public List<Ator> list() {
//        Ator p = new Ator();
//        p.setNome("Carlos H. Nonnemacher");
//        return Stream.of(p).collect(Collectors.toList());
//    }
    
}
