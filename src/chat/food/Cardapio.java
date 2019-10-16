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
public class Cardapio {

    private int idCardapio;

    public static final String PROP_IDCARDAPIO = "idCardapio";

    public int getIdCardapio() {
        return idCardapio;
    }

    public void setIdCardapio(int idCardapio) {
        int oldIdCardapio = this.idCardapio;
        this.idCardapio = idCardapio;
        propertyChangeSupport.firePropertyChange(PROP_IDCARDAPIO, oldIdCardapio, idCardapio);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
    
    private Restaurante restaurante;

    public static final String PROP_RESTAURANTE = "restaurante";

    /**
     * Get the value of restaurante
     *
     * @return the value of restaurante
     */
    public Restaurante getRestaurante() {
        return restaurante;
    }

    /**
     * Set the value of restaurante
     *
     * @param restaurante new value of restaurante
     */
    public void setRestaurante(Restaurante restaurante) {
        Restaurante oldRestaurante = this.restaurante;
        this.restaurante = restaurante;
        propertyChangeSupport.firePropertyChange(PROP_RESTAURANTE, oldRestaurante, restaurante);
    }

}
