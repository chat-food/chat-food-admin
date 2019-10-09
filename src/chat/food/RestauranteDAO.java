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
                    + "(id_restaurante,nome,descricao,telefone,hora_inicio,hora_fim,senha) VALUES "
                    + "(?,?,?,?,?,?,?);";
            
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
                    + "nome= ?,descricao = ?,telefone = ?,hora_inicio= ?,hora_fim= ?,senha = ?;";
            
            PreparedStatement stmt = conn.prepareStatement(
                                comando,Statement.RETURN_GENERATED_KEYS);
            
            stmt.setString(1, element.getNome());
            stmt.setString(2, element.getDescricao());
            stmt.setString(3, element.getTelefone());
            stmt.setTime(4, (Time) element.getHora_ini());
            stmt.setTime(5, (Time) element.getHora_fim());
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
    public boolean excluir(Restaurante element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Restaurante> listar() {
        List<Restaurante> lstRestaurantes = new LinkedList<>();
        lstRestaurantes = ObservableCollections.observableList(lstRestaurantes);
        
        String sql = "SELECT * from restaurante;";
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                Restaurante r = new Restaurante(rs.getString("nome"),rs.getString("telefone"),rs.getString("descricao"),rs.getTime("hora_ini"), rs.getTime("hora_fim"));
               
                        
                String passwd = new String(r.getSenha());
                char[] senhaNova = passwd.toCharArray();
                r.setSenha(senhaNova);
                
                r.setId(rs.getInt("id"));
                lstRestaurantes.add(r);
            }
            
        }catch(SQLException e){
            System.out.println("erro ao listar");
        }
        return lstRestaurantes;
    }
}
