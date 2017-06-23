/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojo.Estado;
import br.com.crescer.aula3.ConnectionUtils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author camila.batista
 */
public class EstadoDAO implements DAO<Estado>{
    
    private static final String INSERT_ESTADO = "INSERT INTO ESTADO(ID, NOME, UF, PAIS) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_ESTADO = "UPDATE ESTADO SET NOME = ?, UF = ?, PAIS = ? WHERE ID = ?";
    private static final String DELETE_ESTADO = "DELETE ESTADO WHERE ID = ?";
    private static final String LOAD_ESTADO = "SELECT * FROM ESTADO WHERE ID = ?";
    
    
    @Override
    public void insert(Estado estado) {

        try(final PreparedStatement preparedStatement = 
                ConnectionUtils.getConnection().prepareStatement(INSERT_ESTADO)){
            
            preparedStatement.setLong(1, estado.getId());
            preparedStatement.setString(2, estado.getNome());
            preparedStatement.setString(3, estado.getUf());
            preparedStatement.setLong(4, estado.getIdPais());
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            System.err.format("SQLException: %s", ex);
        } catch (Exception ex) {
            Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void delete(Estado estado) {

        try(final PreparedStatement preparedStatement = 
                ConnectionUtils.getConnection().prepareStatement(DELETE_ESTADO)){

            preparedStatement.setLong(1, estado.getId());
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            System.err.format("SQLException: %s", ex);
        }
    }

    @Override
    public void update(Estado estado) {
        try(final PreparedStatement preparedStatement = 
                ConnectionUtils.getConnection().prepareStatement(UPDATE_ESTADO)){
            
            preparedStatement.setString(1, estado.getNome());
            preparedStatement.setString(2, estado.getUf());
            preparedStatement.setLong(3, estado.getIdPais());

            preparedStatement.setLong(4, estado.getId());
            
            preparedStatement.executeUpdate();
        
        } catch (SQLException ex) {
            System.err.format("SQLException: %s", ex);
        } catch (Exception ex) {
            Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Estado loadBy(Long id) {
        final Estado estado = new Estado();
        
        try(final PreparedStatement preparedStatement = 
                ConnectionUtils.getConnection().prepareStatement(LOAD_ESTADO)){
            preparedStatement.setLong(1, id);
            
            try(final ResultSet resultSet = preparedStatement.executeQuery()){
                while(resultSet.next()){
                    estado.setId(resultSet.getLong("ID"));
                    estado.setNome(resultSet.getString("NOME"));
                    estado.setUf(resultSet.getString("UF"));
                    estado.setIdPais(resultSet.getLong("IDPAIS"));
                }
            }catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        }catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
        } catch (Exception ex) {
            Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return estado;
    }
}
