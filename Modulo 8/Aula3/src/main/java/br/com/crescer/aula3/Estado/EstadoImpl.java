/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula3.Estado;

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
public class EstadoImpl implements EstadoDAO{

    private static final String INSERT_ESTADO = "INSERT INTO ESTADO(ID, NOME, UF, PAIS) VALUES (?, ?)";
    private static final String UPDATE_ESTADO = "UPDATE ESTADO SET NOME = ? WHERE ID = ?";
    private static final String DELETE_ESTADO = "DELETE ESTADO WHERE ID = ?";
    private static final String LOAD_ESTADO = "SELECT * FROM ESTADO WHERE ID = ?";
    
    
    @Override
    public void insert(Estado estado) {

        try(final PreparedStatement preparedStatement = 
                ConnectionUtils.getConnection().prepareStatement(INSERT_ESTADO)){
            
            preparedStatement.setLong(1, estado.getId());
            preparedStatement.setString(2, estado.getNome());
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            System.err.format("SQLException: %s", ex);
        } catch (Exception ex) {
            Logger.getLogger(EstadoImpl.class.getName()).log(Level.SEVERE, null, ex);
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
            preparedStatement.setLong(2, estado.getId());
            
            preparedStatement.executeUpdate();
        
        } catch (SQLException ex) {
            System.err.format("SQLException: %s", ex);
        } catch (Exception ex) {
            Logger.getLogger(EstadoImpl.class.getName()).log(Level.SEVERE, null, ex);
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
//                    estado.setPais(resultSet.getString("PAIS"));
//                    estado.getUf(resultSet.getString("UF"));
                }
            }catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        }catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
        } catch (Exception ex) {
            Logger.getLogger(EstadoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return estado;
    }
}
