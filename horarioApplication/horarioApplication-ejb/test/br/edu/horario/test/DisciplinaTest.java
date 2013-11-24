/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.horario.test;

import br.edu.horario.models.Disciplina;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author GuilhermeA
 */
public class DisciplinaTest {
    
    public DisciplinaTest() {
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
    public void disciplinaCreate(){
        Disciplina d = new Disciplina("Teste");
        Assert.assertEquals("Teste", d.getNome());
        
        Disciplina d2 = new Disciplina(1, "TesteComCodigo");
        Assert.assertEquals(1,d2.getCodigo());
    }
    
    @Test
    public void disciplinaEdit(){
        Disciplina d = new Disciplina("TesteAntes");
        d.setNome("TesteDepois");
        
        assertEquals("TesteDepois", d.getNome());
    }
   
}
