/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.horario.models;

/**
 *
 * @author guilherme
 */
public class Professor {
    private String nome;
    private String tia;

    public Professor(String nome, String tia) {
        this.nome = nome;
        this.tia = tia;
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
