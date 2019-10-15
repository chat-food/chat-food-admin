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
public class ClienteDAO extends DAO<Cliente>{
    
    
    @Override
    public boolean inserir(Cliente element) {

        try{
            String comando = "INSERT INTO cliente "
                    + "(id_cliente,nome,telefone) VALUES "
                    + "(?,?,?);";
            
            PreparedStatement stmt = conn.prepareStatement(
                                comando,Statement.RETURN_GENERATED_KEYS);
            
            stmt.setInt(1, element.getIdCliente());
            stmt.setString(2, element.getNome());
            stmt.setString(3, element.getTelefone());
            
            int linhas = stmt.executeUpdate();
            if(linhas==1) {
                ResultSet rs = stmt.getGeneratedKeys();
                rs.next();
                element.setIdCliente(rs.getInt(1));
                return true;
            }
        }catch(SQLException e){
            System.out.println("erro ao inserir: "+ e.getMessage());
        }
        return false;
    }
    
    @Override
       public List<Cliente> listar() {
        List<Cliente> lstClientes = new LinkedList<>();
        lstClientes = ObservableCollections.observableList(lstClientes);
        
        String sql = "SELECT * from cliente;";
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Cliente c = new Cliente();
                c.setIdCliente(rs.getInt("id_cliente"));
                c.setNome(rs.getString("nome"));
                c.setTelefone(rs.getString("telefone"));
                lstClientes.add(c);
            }
            
        }catch(SQLException e){
            System.out.println("erro ao listar");
        }
        return lstClientes;
    }

    @Override
    public boolean alterar(Cliente element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(Cliente element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
