/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.horario.gerenciadores;

import br.edu.horario.models.Reserva;

/**
 *
 * @author guilherme
 */
public class GerenciadorReservas implements IGerenciador{

    @Override
    public void add(Object obj) {
        checkType(obj);
    }

    @Override
    public void remove(Object obj) {
        checkType(obj);
    }

    @Override
    public void update(Object newObj, Object oldObj) {
        checkType(newObj);
        checkType(oldObj);
    }

    @Override
    public void read(Object obj) {
        checkType(obj);
    }

    @Override
    public void checkType(Object obj) {
        if(!obj.getClass().isInstance(Reserva.class))
            throw new UnsupportedOperationException("Objeto não é uma reserva");
    }
    
}
