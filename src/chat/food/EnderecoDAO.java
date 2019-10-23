/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.food;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author Laboratorio
 */
public class EnderecoDAO extends DAO<Endereco>{

    @Override
    public boolean inserir(Endereco element) {
        try{
            String sql = "INSERT INTO endereco "
                    + "(logradouro,bairro,cidade,cep,estado,complemento) VALUES "
                    + "(?,?,?,?,?,?);";
            PreparedStatement stmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, element.getLogradouro());
            stmt.setString(2, element.getBairro());
            stmt.setString(3, element.getCidade());
            stmt.setString(4, element.getCep());
            stmt.setString(5, element.getEstado());
            stmt.setString(6, element.getComplemento());
            //stmt.setObject(7, element.getCliente());
            int linhas = stmt.executeUpdate();
            if(linhas==1) {
                ResultSet rs = stmt.getGeneratedKeys();
                rs.next();
                element.setIdEndereco(rs.getInt(1));
                return true;
            }
        }catch(Exception e) {
             e.printStackTrace();
        }
         return false;
    }

    @Override
    public boolean alterar(Endereco element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(Endereco element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Endereco> listar() {
        List<Endereco> lstEndereco = new LinkedList<>();
        lstEndereco = ObservableCollections.observableList(lstEndereco);
        
        String sql = "select * from endereco";
        
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Endereco e = new Endereco();
                e.setIdEndereco(rs.getInt("id_endereco"));
                e.setLogradouro(rs.getString("logradouro"));
                e.setBairro(rs.getString("bairro"));
                e.setCidade(rs.getString("cidade"));
                e.setCep(rs.getString("cep"));
                e.setEstado(rs.getString("estado"));
                e.setComplemento(rs.getString("complemento"));
                lstEndereco.add(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstEndereco;
    }
    
}
