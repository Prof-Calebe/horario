/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.horario.jpa;

import br.edu.horario.models.Horario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author GuilhermeA
 */
@Stateless(mappedName = "ejb/HorarioFacade")
public class HorarioFacade extends AbstractFacade<Horario> {

    @PersistenceContext(unitName = "horarioApplication-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HorarioFacade() {
        super(Horario.class);
    }
}

