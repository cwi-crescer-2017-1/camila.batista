/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Pojo.Ator;
import Repository.AtorRepository;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author camila.batista
 */
@Service
public class AtorService {
  
  @Autowired
  private AtorRepository repositorio;
  
  public List<Ator> list() {
    return (List<Ator>) repositorio.findAll();
  }
  
  public Ator findById(Long id) {
    return repositorio.findOne(id);
  }
  
  public Ator save(Ator ator) {
    return repositorio.save(ator);
  }

  public void remove(Long id) {
    repositorio.delete(id);
  }
}
