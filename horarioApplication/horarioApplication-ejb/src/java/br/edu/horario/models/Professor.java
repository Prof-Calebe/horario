/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.horario.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author guilherme
 */
@Entity
public class Professor implements Serializable{
    
    private static final long serialVersionUID = 3L;
    @Id @GeneratedValue
    private int codigo;
    private String nome;
    private String tia;

    public Professor() {
    }

    public Professor(String nome, String tia) {
        this.nome = nome;
        this.tia = tia;
    }

    @Override
    public String toString() {
        return nome;
    }

    
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTia() {
        return tia;
    }

    public void setTia(String tia) {
        this.tia = tia;
    }
    
    
}
