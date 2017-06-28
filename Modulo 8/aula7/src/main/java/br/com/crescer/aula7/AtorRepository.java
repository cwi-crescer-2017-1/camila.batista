/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author camila.batista
 */
public interface AtorRepository extends CrudRepository<Ator, Long>{
    
    List<Ator> findAll();
}
