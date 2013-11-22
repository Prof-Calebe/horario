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
public class Horario implements Serializable{
    
    private static final long serialVersionUID = 2L;
    @Id @GeneratedValue
    private int codigo;
    private String horario;
    private Disciplina disciplina;
    private String turma;
    private EnumDiaDaSemana dia;

    public Horario(){}
    public Horario(String horario, Disciplina disciplina, String turma, EnumDiaDaSemana dia) {
        this.horario = horario;
        this.disciplina = disciplina;
        this.turma = turma;
        this.dia = dia;
    }

    @Override
    public String toString() {
        return horario+":"+disciplina+". Turma:"+turma;
    }
    
    
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public EnumDiaDaSemana getDia() {
        return dia;
    }

    public void setDia(EnumDiaDaSemana dia) {
        this.dia = dia;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }
    
    
    
    
}
