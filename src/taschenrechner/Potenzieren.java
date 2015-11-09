/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taschenrechner;

/**
 *
 * @author Raffael
 */
public class Potenzieren implements Rechner {
    
    public double rechne(double x,double y) {
        double zw = 0;
        if (y == 0) {  
        return 1;
        }
        
        else if(y ==1) {
            return x;
        }
        
        else {
            
            zw = x * x;
            
            for (int i = 1; i < y-1; i++) {
                
                zw = zw* x;
            }
            return zw;
        }
    }
    
}
