package chat.food;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Date;
import java.util.Map;

public class Pedido {

    public Pedido() {
        status = "ABERTO";
    }

    private int id_pedido;

    public static final String PROP_ID_PEDIDO = "id_pedido";

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        int oldId_pedido = this.id_pedido;
        this.id_pedido = id_pedido;
        propertyChangeSupport.firePropertyChange(PROP_ID_PEDIDO, oldId_pedido, id_pedido);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    private String descricao;

    public static final String PROP_DESCRICAO = "descricao";

    private Endereco endereco;

    public static final String PROP_ENDERECO = "endereco";

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        Endereco oldEndereco = this.endereco;
        this.endereco = endereco;
        propertyChangeSupport.firePropertyChange(PROP_ENDERECO, oldEndereco, endereco);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        String oldDescricao = this.descricao;
        this.descricao = descricao;
        propertyChangeSupport.firePropertyChange(PROP_DESCRICAO, oldDescricao, descricao);
    }

    private double valor_total;

    public static final String PROP_VALOR_TOTAL = "valor_total";

    public double getValor_total() {
        return valor_total;
    }

    public void setValor_total(double valor_total) {
        double oldValor_total = this.valor_total;
        this.valor_total = valor_total;
        propertyChangeSupport.firePropertyChange(PROP_VALOR_TOTAL, oldValor_total, valor_total);
    }

    private String status;

    public static final String PROP_STATUS = "status";

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        String oldStatus = this.status;
        this.status = status;
        propertyChangeSupport.firePropertyChange(PROP_STATUS, oldStatus, status);
    }

    private Restaurante restaurante;

    public static final String PROP_RESTAURANTE = "restaurante";

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        Restaurante oldRestaurante = this.restaurante;
        this.restaurante = restaurante;
        propertyChangeSupport.firePropertyChange(PROP_RESTAURANTE, oldRestaurante, restaurante);
    }

    private Cliente cliente;

    public static final String PROP_CLIENTE = "cliente";

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        Cliente oldCliente = this.cliente;
        this.cliente = cliente;
        propertyChangeSupport.firePropertyChange(PROP_CLIENTE, oldCliente, cliente);
    }

    private Date horario_pedido;

    public static final String PROP_HORARIO_PEDIDO = "horario_pedido";

    public Date getHorario_pedido() {
        return horario_pedido;
    }

    public void setHorario_pedido(Date horario_pedido) {
        Date oldHorario_pedido = this.horario_pedido;
        this.horario_pedido = horario_pedido;
        propertyChangeSupport.firePropertyChange(PROP_HORARIO_PEDIDO, oldHorario_pedido, horario_pedido);
    }

}
