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
import java.util.LinkedList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author Laboratorio
 */
public class ItemDAO extends DAO<ItemCardapio>{
    
    
    @Override
    public boolean inserir(ItemCardapio element) {

        try{
            String comando = "INSERT INTO itemcardapio "
                    + "(IdItemCardapio,nome,preco,descricao) VALUES "
                    + "(?,?,?,?);";
            
            PreparedStatement stmt = conn.prepareStatement(
                                comando,Statement.RETURN_GENERATED_KEYS);
            
            stmt.setString(1, element.getIdItemCardapio());
            stmt.setString(2, element.getNome());
            stmt.setFloat(3, element.getPreco());
            stmt.setString(4, element.getDescricao());
            
            int linhas = stmt.executeUpdate();
            if(linhas==1) {
                ResultSet rs = stmt.getGeneratedKeys();
                rs.next();
                element.setIdItemCardapio(rs.getString(1));
                return true;
            }
        }catch(SQLException e){
            System.out.println("erro ao inserir: "+ e.getMessage());
        }
        return false;
    }
    
    @Override
       public List<ItemCardapio> listar() {
        List<ItemCardapio> lstItemCardapio = new LinkedList<>();
        lstItemCardapio = ObservableCollections.observableList(lstItemCardapio);
        
        String sql = "SELECT * from itemcardapio;";
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                ItemCardapio ic = new ItemCardapio();
                ic.setIdItemCardapio(rs.getString("IdItemCardapio"));
                ic.setNome(rs.getString("nome"));
                ic.setPreco(rs.getFloat("preco"));
                ic.setDescricao(rs.getString("descricao"));
                lstItemCardapio.add(ic);
            }
            
        }catch(SQLException e){
            System.out.println("erro ao listar");
        }
        return lstItemCardapio;
    }

    @Override
    public boolean alterar(ItemCardapio element) {
        try{
            String comando = "UPDATE itemcardapio SET"
                    + "IdItemCardapio= ?,nome = ?,preco = ?, descricao = ?;";
            
            PreparedStatement stmt = conn.prepareStatement(
                                comando,Statement.RETURN_GENERATED_KEYS);
            
            stmt.setString(1, element.getIdItemCardapio());
            stmt.setString(2, element.getNome());
            stmt.setFloat(3, element.getPreco());
            stmt.setString(4, element.getDescricao());
        
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
    public boolean excluir(ItemCardapio element) {
        try{
        String comando = "DELETE FROM itemcardapio"
                + "WHERE IdItemCardapio = ?;";
                
        
        PreparedStatement stmt = conn.prepareStatement(
                            comando,Statement.RETURN_GENERATED_KEYS);

        stmt.setString(1, element.getIdItemCardapio());

        int linhas = stmt.executeUpdate();
        if(linhas==1) {
            return true;
        }
        }catch(SQLException e){
        System.out.println("erro ao inserir: "+ e.getMessage());
        }
        return false;    
        
    }
}
