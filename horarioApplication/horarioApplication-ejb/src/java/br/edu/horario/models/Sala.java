/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.horario.models;

import java.util.ArrayList;

/**
 *
 * @author GuilhermeA
 */
public class Sala {

    private ArrayList<Horario> lsHorarios;
    private int numeroSala = -1;
    private int numeroPredio = -1;
    
    public Sala(){
        this.lsHorarios = new ArrayList<>();
    }

    public Sala(int numeroSala, int numeroPredio) {
        this.lsHorarios = new ArrayList<>();
        this.numeroSala = numeroSala;
        this.numeroPredio = numeroPredio;
    }

    
    public ArrayList<Horario> getLsHorarios() {
        return lsHorarios;
    }
    public int getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
    }

    public int getNumeroPredio() {
        return numeroPredio;
    }

    public void setNumeroPredio(int numeroPredio) {
        this.numeroPredio = numeroPredio;
    }
    
    public void addHorario(Horario horario){
        lsHorarios.add(horario);
    }

    @Override
    public String toString() {
        return "Sala:"+numeroSala+", prédio:"+numeroPredio+" Qtde horários:"+lsHorarios.size();
    }
    
    
}
