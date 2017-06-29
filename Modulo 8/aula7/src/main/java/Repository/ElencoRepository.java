/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Pojo.Elenco;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Camila
 */
public interface ElencoRepository extends CrudRepository<Elenco, Long>{
    
}
