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
public class ItemCardapio {
    
    private String idItemCardapio;

    public static final String PROP_IDITEMCARDAPIO = "idItemCardapio";

    /**
     * Get the value of idItemCardapio
     *
     * @return the value of idItemCardapio
     */
    public String getIdItemCardapio() {
        return idItemCardapio;
    }

    /**
     * Set the value of idItemCardapio
     *
     * @param idItemCardapio new value of idItemCardapio
     */
    public void setIdItemCardapio(String idItemCardapio) {
        String oldIdItemCardapio = this.idItemCardapio;
        this.idItemCardapio = idItemCardapio;
        propertyChangeSupport.firePropertyChange(PROP_IDITEMCARDAPIO, oldIdItemCardapio, idItemCardapio);
    }

    
    private Cardapio cardapio;

    public static final String PROP_CARDAPIO = "cardapio";

    public Cardapio getCardapio() {
        return cardapio;
    }

    public void setCardapio(Cardapio cardapio) {
        Cardapio oldCardapio = this.cardapio;
        this.cardapio = cardapio;
        propertyChangeSupport.firePropertyChange(PROP_CARDAPIO, oldCardapio, cardapio);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
    
    private String nome;

    public static final String PROP_NOME = "nome";

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        propertyChangeSupport.firePropertyChange(PROP_NOME, oldNome, nome);
    }

    private float preco;

    public static final String PROP_PRECO = "preco";

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        float oldPreco = this.preco;
        this.preco = preco;
        propertyChangeSupport.firePropertyChange(PROP_PRECO, oldPreco, preco);
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
    
    
}
