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
public class testExtremWerte {
    
    private Rechner rech;
    public testExtremWerte() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        rech = (Rechner) new Addiere();
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
    public void hoecherPositivWert() {
        
        assertEquals(2147483647, rech.rechne(1073741823.5, 1073741823.5), 0.0f);    
    }
    
    @Test
    public void hoecherNegativWert() {
       // rech = (Rechner) new Addiere();
        assertEquals(-2147483647, rech.rechne(-1073741823.5, -1073741823.5), 0.0f);    
    }
}
