package chat.food;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.Time;
import java.util.Date;

public class Restaurante {

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

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
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

    private Integer id_restaurante;

    public final String PROP_ID_RESTAURANTE = "id_restaurante";

    public int getId_restaurante() {
        return id_restaurante;
    }

    public void setId_restaurante(int id_restaurante) {
        int oldId_restaurante = this.id_restaurante;
        this.id_restaurante = id_restaurante;
        propertyChangeSupport.firePropertyChange(PROP_ID_RESTAURANTE, oldId_restaurante, id_restaurante);
    }

    private Time hora_ini;

    public static final String PROP_HORA_INI = "hora_ini";

    public Time getHora_ini() {
        return hora_ini;
    }

    public void setHora_ini(Time hora_ini) {
        Date oldHora_ini = this.hora_ini;
        this.hora_ini = hora_ini;
        propertyChangeSupport.firePropertyChange(PROP_HORA_INI, oldHora_ini, hora_ini);
    }

    private Time hora_fim;

    public static final String PROP_HORA_FIM = "hora_fim";

    public Time getHora_fim() {
        return hora_fim;
    }

    public void setHora_fim(Time hora_fim) {
        Date oldHora_fim = this.hora_fim;
        this.hora_fim = hora_fim;
        propertyChangeSupport.firePropertyChange(PROP_HORA_FIM, oldHora_fim, hora_fim);
    }

    public Restaurante(String n, String tele, String desc, Time inicio, Time fim) {
        this.nome = n;
        this.telefone = tele;
        this.descricao = desc;
        this.hora_ini = inicio;
        this.hora_fim = fim;
    }

    public void setId(Integer id) {
    Integer oldId = this.id_restaurante;
    this.id_restaurante = id;
    }
}
