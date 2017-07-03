/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio;

import Entidades.Comentario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author camila.batista
 */
public interface ComentarioRepositorio extends PagingAndSortingRepository<Comentario, Long>{
    
}
