/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.horario.gerenciadores;

/**
 *
 * @author guilherme
 */
public interface IGerenciador {
    public void add(Object obj);
    public void remove(Object obj);
    public void update(Object newObj, Object oldObj);
    public void read(Object obj);
    public void checkType(Object obj);
}
