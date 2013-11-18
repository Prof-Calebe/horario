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

public class Horario {
    private int horario;
    private Disciplina disciplina;
    private String turma;
    private EnumDiaDaSemana dia;

    public Horario(){}
    public Horario(int horario, Disciplina disciplina, String turma, EnumDiaDaSemana dia) {
        this.horario = horario;
        this.disciplina = disciplina;
        this.turma = turma;
        this.dia = dia;
    }

    public EnumDiaDaSemana getDia() {
        return dia;
    }

    public void setDia(EnumDiaDaSemana dia) {
        this.dia = dia;
    }

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
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
