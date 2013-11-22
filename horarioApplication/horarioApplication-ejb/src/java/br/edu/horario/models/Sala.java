/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.horario.models;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.ElementCollection;
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
//    @ElementCollection
//    private ArrayList<Horario> lsHorarios;
    private String numeroSala;
    private String numeroPredio;
    
    public Sala(){
//        this.lsHorarios = new ArrayList<>();
    }

    public Sala(String numeroSala, String numeroPredio) {
//        this.lsHorarios = new ArrayList<>();
        this.numeroSala = numeroSala;
        this.numeroPredio = numeroPredio;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

//    public void setLsHorarios(ArrayList<Horario> lsHorarios) {
//        this.lsHorarios = lsHorarios;
//    }
//    
//    public ArrayList<Horario> getLsHorarios() {
//        return lsHorarios;
//    }
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
    
//    public void addHorario(Horario horario){
//        lsHorarios.add(horario);
//    }

    @Override
    public String toString() {
//        return "Sala:"+numeroSala+", prédio:"+numeroPredio+" Qtde horários:"+lsHorarios.size();
          return "Sala:"+numeroSala+", prédio:"+numeroPredio;
    }
    
//    public String toStringAllHorarios(){
//        String out = "Sala:"+numeroSala+", prédio:"+numeroPredio+" \n";
//        for(Horario hor : lsHorarios){
//            out += hor + "\n";
//        }
//        return out;
//    }
    
    
}
