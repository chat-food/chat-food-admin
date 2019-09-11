/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.food;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javax.swing.JTextField;

/**
 *
 * @author Laboratorio
 */
public class Restaurante {

    String nome;

    public static final String PROP_NOME = "nome";

    public String getNome() {
        return nome;
    }
    private char[] senha;

    public static final String PROP_SENHA = "senha";

    public char[] getSenha() {
        return senha;
    }

    public void setSenha(char[] senha) {
        char[] oldSenha = this.senha;
        this.senha = senha;
        propertyChangeSupport.firePropertyChange(PROP_SENHA, oldSenha, senha);
    }

    private String telefone;

    public static final String PROP_TELEFONE = "telefone";

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        String oldTelefone = this.telefone;
        this.telefone = telefone;
        propertyChangeSupport.firePropertyChange(PROP_TELEFONE, oldTelefone, telefone);
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        propertyChangeSupport.firePropertyChange(PROP_NOME, oldNome, nome);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    String descricao;

    public static final String PROP_DESCRICAO = "descricao";

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        String oldDescricao = this.descricao;
        this.descricao = descricao;
        propertyChangeSupport.firePropertyChange(PROP_DESCRICAO, oldDescricao, descricao);
    }

    private int id_restaurante;

    public static final String PROP_ID_RESTAURANTE = "id_restaurante";

    public int getId_restaurante() {
        return id_restaurante;
    }

    public void setId_restaurante(int id_restaurante) {
        int oldId_restaurante = this.id_restaurante;
        this.id_restaurante = id_restaurante;
        propertyChangeSupport.firePropertyChange(PROP_ID_RESTAURANTE, oldId_restaurante, id_restaurante);
    }

    private String horario_ini;

    public static final String PROP_HORARIO_INI = "horario_ini";

    public String getHorario_ini() {
        return horario_ini;
    }
    private String horario_fim;

    public static final String PROP_HORARIO_FIM = "horario_fim";

    public String getHorario_fim() {
        return horario_fim;
    }

    public void setHorario_fim(String horario_fim) {
        String oldHorario_fim = this.horario_fim;
        this.horario_fim = horario_fim;
        propertyChangeSupport.firePropertyChange(PROP_HORARIO_FIM, oldHorario_fim, horario_fim);
    }


    public void setHorario_ini(String horario_ini) {
        String oldHorario_ini = this.horario_ini;
        this.horario_ini = horario_ini;
        propertyChangeSupport.firePropertyChange(PROP_HORARIO_INI, oldHorario_ini, horario_ini);
    }

    void setHorario_ini(JTextField txtDe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setHorario_fim(JTextField txtAte) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
