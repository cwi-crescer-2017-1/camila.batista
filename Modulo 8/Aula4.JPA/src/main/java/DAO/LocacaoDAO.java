/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojo.Locacao;

/**
 *
 * @author Camila
 */
public class LocacaoDAO extends BasicDAO<Locacao, Long>{
    
    public LocacaoDAO(Class<Locacao> entity) {
        super(entity);
    }
    
}