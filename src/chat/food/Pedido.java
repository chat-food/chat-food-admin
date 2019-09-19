package chat.food;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Date;

public class Pedido {

    enum Status {
        ABERTO, PREPARANDO, FINALIZADO, ENTREGUE;
    }

    public Pedido() {
        status = Status.ABERTO;
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

    private Status status;

    public static final String PROP_STATUS = "status";

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        Status oldStatus = this.status;
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
