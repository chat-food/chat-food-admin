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
import java.sql.Time;
import java.util.LinkedList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author Laboratorio
 */
public class RestauranteDAO extends DAO<Restaurante>{
    @Override
    public boolean inserir(Restaurante element) {
        try{
            String comando = "INSERT INTO restaurante "
                    + "(nome,descricao,telefone,hora_inicio,hora_fim,senha) VALUES "
                    + "(?,?,?,?,?,?);";
            
            PreparedStatement stmt = conn.prepareStatement(
                                comando,Statement.RETURN_GENERATED_KEYS);
            
            stmt.setString(1, element.getNome());
            stmt.setString(2, element.getDescricao());
            stmt.setString(3, element.getTelefone());
            stmt.setTime(4, element.getHora_ini());
            stmt.setTime(5, element.getHora_fim());
            stmt.setString(6, new String(element.getSenha()));
            
            int linhas = stmt.executeUpdate();
            if(linhas==1) {
                ResultSet rs = stmt.getGeneratedKeys();
                rs.next();
                element.setId(rs.getInt(1));
                return true;
            }
        }catch(SQLException e){
            System.out.println("erro ao inserir: "+ e.getMessage());
        }
        return false;
    }

    @Override
    public boolean alterar(Restaurante element) {
        
        try{
            String comando = "UPDATE restaurante SET"
                    + "nome= ?,descricao = ?,telefone = ?,hora_inicio= ?,hora_fim= ?,senha = ? WHERE id_restaurante = ?;";
            
            PreparedStatement stmt = conn.prepareStatement(
                                comando,Statement.RETURN_GENERATED_KEYS);
            
            stmt.setString(1, element.getNome());
            stmt.setString(2, element.getDescricao());
            stmt.setString(3, element.getTelefone());
            stmt.setTime(4, element.getHora_ini());
            stmt.setTime(5, element.getHora_fim());
            stmt.setString(6, new String(element.getSenha()));
            stmt.setInt(7, element.getId_restaurante());
            
            int linhas = stmt.executeUpdate();
            if(linhas==1) {
                ResultSet rs = stmt.getGeneratedKeys();
                rs.next();
                return true;
            }
        }catch(SQLException e){
            System.out.println("erro ao alterar: "+ e.getMessage());
        }
        return false;
    }

    @Override
    public boolean excluir(Restaurante element) {
    try{
        String comando = "DELETE FROM restaurante "
                + "WHERE id_restaurante = ?;";
                
        
        PreparedStatement stmt = conn.prepareStatement(
                            comando,Statement.RETURN_GENERATED_KEYS);

        stmt.setInt(1, element.getId_restaurante());

        int linhas = stmt.executeUpdate();
        if(linhas==1) {
            return true;
        }
        }catch(SQLException e){
        System.out.println("erro ao inserir: "+ e.getMessage());
        }
        return false;    
    }

    public List<Restaurante> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
    
    
    public Restaurante consultar(Integer id_rest) {
        try {
            String sql = "SELECT * FROM restaurante WHERE id_restaurante = ?";
       
            PreparedStatement stmt = conn.prepareStatement(
                                sql,Statement.RETURN_GENERATED_KEYS);
            
            stmt.setInt(1, id_rest);
            // Instanciar DAO de Restaurante AQUI e consultar Restaurante
            
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                Restaurante r = new Restaurante(rs.getString("nome"),rs.getString("telefone"),rs.getString("descricao"),rs.getTime("hora_inicio"), rs.getTime("hora_fim"));
               
                String passwd = new String(r.getSenha());
                char[] senhaNova = passwd.toCharArray();
                r.setSenha(senhaNova);
                r.setId(rs.getInt("id"));
                
                return r;
            }
        } catch(SQLException e) {
            System.out.println("erro ao consultar: "+ e.getMessage());
        }
        
        return null; 
        
    }
          
}
