/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.food;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Laboratorio
 */
public class Restaurante {

    private String nome;
    private char[] senha;
    private String telefone;
    private String descricao;
    private static int id_restaurante;
    private Date hora_ini;
    private Date hora_fim;

    public Restaurante(String n, char[] pw, String tele, String desc, Date inicio, Date fim)
    {
        Restaurante.id_restaurante++;
        this.nome = n;
        this.senha = pw;
        this.telefone = tele;
        this.descricao = desc;
        this.hora_ini = inicio;
        this.hora_fim = fim;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public void setSenha(char[] senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }
    
    public void setTelefone(String tele){
        this.telefone = tele;
    }
    
    public String getDescricao(){
        return this.descricao;
    }
    public void setDescricao(String desc){
        this.descricao = desc;
    }

    public int getId_restaurante() {
        return this.id_restaurante; 
        //duvida
    }

    public Date getHoraIni()
    {
        return this.hora_ini;
    }
    public Date getHoraFim()
    {
        return this.hora_fim;
    }
}
