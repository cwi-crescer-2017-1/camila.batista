/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Pojo.Elenco;
import Repository.ElencoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Camila
 */
@Service
public class ElencoService {

    @Autowired
    private ElencoRepository repositorio;

    public List<Elenco> list() {
        return (List<Elenco>) repositorio.findAll();
    }

    public Elenco findById(Long id) {
        return repositorio.findOne(id);
    }

    public Elenco save(Elenco elenco) {
        return repositorio.save(elenco);
    }

    public void delete(Long id) {
        repositorio.delete(id);
    }
}
