/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.horario.jpa;

import br.edu.horario.models.Disciplina;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author GuilhermeA
 */
@Stateless(mappedName = "ejb/DisciplinaFacade")
public class DisciplinaFacade extends AbstractFacade<Disciplina> {

    @PersistenceContext(unitName = "horarioApplication-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public DisciplinaFacade() {
        super(Disciplina.class);
    }
}
