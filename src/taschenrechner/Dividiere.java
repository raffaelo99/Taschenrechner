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
public class Dividiere implements Rechner{
    
    public double rechne(double x, double y){
        
        if(y!=0) {
            return x/y;
        }
        return 0;
    }
    
}
