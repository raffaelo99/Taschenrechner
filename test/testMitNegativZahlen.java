/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import taschenrechner.*;

/**
 *
 * @author Raffael
 */
public class testMitNegativZahlen {
    
    private Rechner rech;
    public testMitNegativZahlen() {
       
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void negativeMulti() {
        rech = (Rechner) new Multipliziere();
        assertEquals(-9.0, rech.rechne(-4.5,2.0), 0.0f);
    }
    
    @Test
    public void negativeDiv() {
        rech = (Rechner) new Dividiere();
        assertEquals(-2.5, rech.rechne(5,-2.0), 0.0f);    
    }
    @Test
    public void negativeSub() {
        rech = (Rechner) new Subtrahiere();
        assertEquals(-5, rech.rechne(-3.0,2.0), 0.0f);    
    }
    
}
