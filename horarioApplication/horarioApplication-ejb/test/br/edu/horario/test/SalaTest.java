/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.horario.test;

import br.edu.horario.models.Sala;
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
public class SalaTest {
    
    public SalaTest() {
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
    public void salaCreate(){
        Sala s = new Sala("10","11");
        Assert.assertEquals("10", s.getNumeroSala());
        Assert.assertEquals("11", s.getNumeroPredio());
    }
    
    @Test
    public void salaEdit(){
        Sala s = new Sala("1","2");
        s.setNumeroPredio("10");
        s.setNumeroSala("20");
        Assert.assertEquals("10",s.getNumeroPredio());
        Assert.assertEquals("20",s.getNumeroSala());
    }
}
