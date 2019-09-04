package chat.food;


public class Pedido {

    private int id_pedido;

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    private float valor_total;

    public float getValor_total() {
        return valor_total;
    }

    public void setValor_total(float valor_total) {
        this.valor_total = valor_total;
    }

    private int restaurante_id_restaurante;

    public int getRestaurante_id_restaurante() {
        return restaurante_id_restaurante;
    }

    public void setRestaurante_id_restaurante(int restaurante_id_restaurante) {
        this.restaurante_id_restaurante = restaurante_id_restaurante;
    }

    private int cliente_id_cliente;

    public int getCliente_id_cliente() {
        return cliente_id_cliente;
    }

    public void setCliente_id_cliente(int cliente_id_cliente) {
        this.cliente_id_cliente = cliente_id_cliente;
    }

    private int endereco_id_endereco;

    public int getEndereco_id_endereco() {
        return endereco_id_endereco;
    }

    public void setEndereco_id_endereco(int endereco_id_endereco) {
        this.endereco_id_endereco = endereco_id_endereco;
    }

}
