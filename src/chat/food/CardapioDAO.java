/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.food;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Laboratorio
 */
public class CardapioDAO extends DAO<Cardapio> {

    @Override
    public boolean inserir(Cardapio element) {
        try {
            String comando = "INSERT INTO chatfood.cardapio"
                + "(id_restaurante)"
                + "VALUES"
                + "(?);";
       
            PreparedStatement stmt = conn.prepareStatement(
                                comando,Statement.RETURN_GENERATED_KEYS);
            
            stmt.setInt(1, element.getRestaurante().getId_restaurante());
            
            int linhas = stmt.executeUpdate();
            if(linhas==1) {
                ResultSet rs = stmt.getGeneratedKeys();
                rs.next();
                element.setIdCardapio(rs.getInt(1));
                
                return true;
            }
        } catch(SQLException e) {
            System.out.println("erro ao inserir: "+ e.getMessage());
        }
        
        return false;
    }

    @Override
    public boolean alterar(Cardapio element) {
        try {
            String comando = "UPDATE chatfood.cardapio SET "
                + "id_restaurante = ? "
                + "WHERE id_cardapio = ?;";
       
            PreparedStatement stmt = conn.prepareStatement(
                                comando,Statement.RETURN_GENERATED_KEYS);
            
            stmt.setInt(1, element.getRestaurante().getId_restaurante());
            stmt.setInt(2, element.getIdCardapio());
            
            int linhas = stmt.executeUpdate();
            if(linhas==1) {
                return true;
            }
        } catch(SQLException e) {
            System.out.println("erro ao inserir: "+ e.getMessage());
        }
        
        return false;   
    }

    @Override
    public boolean excluir(Cardapio element) {
        try {
            String comando = "DELETE FROM chatfood.cardapio WHERE id_cardapio = ?";
       
            PreparedStatement stmt = conn.prepareStatement(
                                comando,Statement.RETURN_GENERATED_KEYS);
            
            stmt.setInt(1, element.getIdCardapio());
            
            int linhas = stmt.executeUpdate();
            if(linhas==1) {
                return true;
            }
        } catch(SQLException e) {
            System.out.println("erro ao inserir: "+ e.getMessage());
        }
        
        return false;   
    }

    @Override
    public List<Cardapio> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
    
    public Cardapio consultarPorRestaurante(Restaurante r) {
        try {
            String comando = "SELECT * FROM chatfood.cardapio WHERE id_restaurante = ?";
       
            PreparedStatement stmt = conn.prepareStatement(
                                comando,Statement.RETURN_GENERATED_KEYS);
            
            stmt.setInt(1, r.getId_restaurante());
            // Instanciar DAO de Restaurante AQUI e consultar Restaurante
            
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                Cardapio c = new Cardapio();
                c.setIdCardapio(rs.getInt(1));
                
                return c;
            }
        } catch(SQLException e) {
            System.out.println("erro ao consultar: "+ e.getMessage());
        }
        
        return null;   
    }
}
