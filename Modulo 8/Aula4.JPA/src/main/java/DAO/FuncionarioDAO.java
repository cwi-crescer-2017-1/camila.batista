/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojo.Funcionario;

/**
 *
 * @author Camila
 */
public class FuncionarioDAO extends BasicDAO<Funcionario, Long>{
    
    public FuncionarioDAO(Class<Funcionario> entity) {
        super(entity);
    }
    
}
