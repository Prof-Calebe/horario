/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.horario.jpa;

import br.edu.horario.models.Professor;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author GuilhermeA
 */
@Stateless(mappedName = "ejb/ProfessorFacade")
public class ProfessorFacade extends AbstractFacade<Professor> {

    @PersistenceContext(unitName = "horarioApplication-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProfessorFacade() {
        super(Professor.class);
    }
}

