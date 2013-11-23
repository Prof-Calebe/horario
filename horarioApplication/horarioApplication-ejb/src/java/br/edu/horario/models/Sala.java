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
 * @author GuilhermeA
 */
@Entity
public class Sala implements Serializable{
    
    private static final long serialVersionUID = 5L;
    @Id @GeneratedValue
    private int codigo;
    private String numeroSala;
    private String numeroPredio;
    
    public Sala(){
    }

    public Sala(String numeroSala, String numeroPredio) {
        this.numeroSala = numeroSala;
        this.numeroPredio = numeroPredio;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(String numeroSala) {
        this.numeroSala = numeroSala;
    }

    public String getNumeroPredio() {
        return numeroPredio;
    }

    public void setNumeroPredio(String numeroPredio) {
        this.numeroPredio = numeroPredio;
    }

    @Override
    public String toString() {
          return "Sala:"+numeroSala+", prédio:"+numeroPredio;
    }

    
}
