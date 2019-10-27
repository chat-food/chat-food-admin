/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.food;

import java.sql.Date;
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
public class PedidoDAO extends DAO<Pedido> {

    @Override
    public boolean inserir(Pedido element) {

        try{
            String comando = "INSERT INTO pedido "
                    + "(id_restaurante, id_cliente, descricao, "
                    + "horario, status, valor_total, id_endereco ) "
                    + "VALUES "
                    + "(?, ?, ?, ?, ?, ?, ?);";
            
            PreparedStatement stmt = conn.prepareStatement(
                                comando,Statement.RETURN_GENERATED_KEYS);
            
            stmt.setInt(1, element.getRestaurante().getId_restaurante());
            stmt.setInt(2, element.getCliente().getIdCliente());
            stmt.setString(3, element.getDescricao());
            stmt.setDate(4, (Date) element.getHorario_pedido());
            stmt.setString(5, element.getStatus());
            stmt.setDouble(6, element.getValor_total());
            stmt.setInt(7, element.getEndereco().getIdEndereco());
            
            int linhas = stmt.executeUpdate();
            if(linhas==1) {
                ResultSet rs = stmt.getGeneratedKeys();
                rs.next();
                element.setId_pedido(rs.getInt(1));
                return true;
            }
        }catch(SQLException e){
            System.out.println("erro ao inserir: "+ e.getMessage());
        }
        return false;
    }

    @Override
    public boolean alterar(Pedido element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(Pedido element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pedido> listar() {
        List<Pedido> listaPedido = new LinkedList<>();
        listaPedido = ObservableCollections.observableList(listaPedido);
        
        String sql = "SELECT * from pedido;";
        
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                Pedido p = new Pedido();
                
                p.setId_pedido(rs.getInt("id_pedido"));
                p.setDescricao(rs.getString("descricao"));
                p.setHorario_pedido(rs.getDate("horario"));
                p.setStatus(rs.getString("status"));
                p.setValor_total(rs.getDouble("valor_total"));
                
                listaPedido.add(p);
            }
            
        }catch(SQLException e){
            System.out.println("erro ao listar");
        }
        return listaPedido;
    }
    
    public List<Pedido> listarPorRestaurante(Restaurante r) {
        List<Pedido> listaPedido = new LinkedList<>();
        listaPedido = ObservableCollections.observableList(listaPedido);
        
        String sql = "SELECT * FROM pedido WHERE id_restaurante = ?;";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(
                sql,
                Statement.RETURN_GENERATED_KEYS
            );
            stmt.setInt(1, r.getId_restaurante());
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Pedido p = new Pedido();
                
                p.setId_pedido(rs.getInt("id_pedido"));
                p.setDescricao(rs.getString("descricao"));
                p.setValor_total(rs.getDouble("valor_total"));
                p.setHorario_pedido(rs.getDate("horario"));
                p.setStatus(rs.getString("status"));
                
                listaPedido.add(p);
            }
        } catch(SQLException e) {
            System.out.println("Erro ao listar pedidos por restaurante: " + e.getMessage());
        }
        
        return listaPedido;
    }
}
