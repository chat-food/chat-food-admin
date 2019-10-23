/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.food;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author Laboratorio
 */
public class Endereco {

    private int idEndereco;

    public static final String PROP_IDENDERECO = "idEndereco";

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        int oldIdEndereco = this.idEndereco;
        this.idEndereco = idEndereco;
        propertyChangeSupport.firePropertyChange(PROP_IDENDERECO, oldIdEndereco, idEndereco);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    private String logradouro;

    public static final String PROP_LOGRADOURO = "logradouro";

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        String oldLogradouro = this.logradouro;
        this.logradouro = logradouro;
        propertyChangeSupport.firePropertyChange(PROP_LOGRADOURO, oldLogradouro, logradouro);
    }

    private int numero;

    public static final String PROP_NUMERO = "numero";

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        int oldNumero = this.numero;
        this.numero = numero;
        propertyChangeSupport.firePropertyChange(PROP_NUMERO, oldNumero, numero);
    }

    private String bairro;

    public static final String PROP_STRINGBAIRRO = "stringbairro";

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String stringbairro) {
        String oldStringbairro = this.bairro;
        this.bairro = stringbairro;
        propertyChangeSupport.firePropertyChange(PROP_STRINGBAIRRO, oldStringbairro, stringbairro);
    }

    private String cidade;

    public static final String PROP_CIDADE = "cidade";

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        String oldCidade = this.cidade;
        this.cidade = cidade;
        propertyChangeSupport.firePropertyChange(PROP_CIDADE, oldCidade, cidade);
    }

    private String cep;

    public static final String PROP_CEP = "cep";

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        String oldCep = this.cep;
        this.cep = cep;
        propertyChangeSupport.firePropertyChange(PROP_CEP, oldCep, cep);
    }

    private String estado;

    public static final String PROP_ESTADO = "estado";

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        String oldEstado = this.estado;
        this.estado = estado;
        propertyChangeSupport.firePropertyChange(PROP_ESTADO, oldEstado, estado);
    }

    private String complemento;

    public static final String PROP_COMPLEMENTO = "complemento";

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        String oldComplemento = this.complemento;
        this.complemento = complemento;
        propertyChangeSupport.firePropertyChange(PROP_COMPLEMENTO, oldComplemento, complemento);
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

    @Override
    public String toString() {
        return "Endereco{" + "idEndereco=" + idEndereco + ", logradouro=" + logradouro + ", numero=" + numero + ", bairro=" + bairro + ", cidade=" + cidade + ", cep=" + cep + ", estado=" + estado + ", complemento=" + complemento + ", restaurante=" + restaurante + ", cliente=" + cliente + '}';
    }

    
}
