/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.horario.test;

import br.edu.horario.models.Disciplina;
import br.edu.horario.models.EnumDiaDaSemana;
import br.edu.horario.models.Horario;
import br.edu.horario.models.Professor;
import br.edu.horario.models.Sala;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author GuilhermeA
 */
public class HorarioTest {
    
    public HorarioTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void createHorario(){
        Disciplina d = new Disciplina("Disc");
        Sala s = new Sala("10","20");
        Professor p = new Professor("Zeh", "123");
        Horario h = new Horario("1", d, "N", EnumDiaDaSemana.TERCA, s, p);
        
        assertEquals("Disc", d.getNome());
        assertEquals("Zeh", p.getNome());
        assertEquals("10", s.getNumeroSala());
        assertEquals("20", s.getNumeroPredio());
        assertEquals("1", h.getHorario());
        assertEquals("N", h.getTurma());
        assertEquals(EnumDiaDaSemana.TERCA, h.getDia());
    }
}
