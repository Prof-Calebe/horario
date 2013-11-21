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
public class Reserva implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue
    private int codigo;
    private Sala sala;
    private Horario horario;
    private Disciplina disciplina;
    private Professor professor;

    public Reserva() {
    }

    public Reserva(Sala sala, Horario horario, Disciplina disciplina, Professor professor) {
        this.sala = sala;
        this.horario = horario;
        this.disciplina = disciplina;
        this.professor = professor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        return "Reserva em nome de:"+professor+", disciplina:" +disciplina + ", sala:" + sala + ", horario:"+horario;
    }
    
}
