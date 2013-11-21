/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.horario.models;

import java.io.Serializable;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author guilherme
 */
@Entity
public class Disciplina implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue
    private int codigo;
    private String nome;

    @Override
    public String toString() {
        return nome;
    }

    public Disciplina() {
    }

    public Disciplina(int codigo,String nome) {
        this.codigo = codigo;
        this.nome = nome; 
    }
    
    public Disciplina(String nome){
        this.nome = nome;
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
    
    
}
