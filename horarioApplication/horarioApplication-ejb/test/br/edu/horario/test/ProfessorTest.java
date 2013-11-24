/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.horario.test;

import br.edu.horario.models.Professor;
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
public class ProfessorTest {
    
    public ProfessorTest() {
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
    public void professorCreate(){
        Professor p = new Professor("Zeh", "123");
        assertEquals("Zeh", p.getNome());
        assertEquals("123", p.getTia());
    }
    
    @Test
    public void professorEdit(){
        Professor p = new Professor("ZehAntes", "123Antes");
        p.setNome("Zeh");
        p.setTia("123");
        assertEquals("Zeh", p.getNome());
        assertEquals("123", p.getTia());
    }
}
