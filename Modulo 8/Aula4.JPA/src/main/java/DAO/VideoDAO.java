/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojo.Video;

/**
 *
 * @author Camila
 */
public class VideoDAO extends BasicDAO<Video, Long>{
    
    public VideoDAO(Class<Video> entity) {
        super(entity);
    }
    
}
