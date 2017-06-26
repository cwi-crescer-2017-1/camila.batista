/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojo.Cliente;

/**
 *
 * @author Camila
 */
public class ClienteDAO extends BasicDAO<Cliente, Long>{
    
    public ClienteDAO(Class<Cliente> entity) {
        super(entity);
    }
    
}
