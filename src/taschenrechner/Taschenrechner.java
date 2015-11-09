/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taschenrechner;
import java.util.Scanner;

/**
 *
 * @author Raffael
 */
public class Taschenrechner {
//private static Berechnung berechne;

private static Scanner scan;
private static boolean stop;
private static Rechner rech;
private static Ausgabe aus;

private static double zw;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        scan = new Scanner(System.in);
        aus = new CMD();
        
        stop = false;
        
        while(stop == false){
            
        double erg = 0;
        zw =0;    
        
        System.out.println("Erste Zahl: ");
        double x = scan.nextDouble();
        
        System.out.println("Operand: ");
        String op1 = scan.next();
        
        System.out.println("Zweite Zahl: ");
        double y = scan.nextDouble();
        
        System.out.println("Operand: ");
        String op2 = scan.next();
        
        System.out.println("Dritte Zahl: ");
        double z = scan.nextDouble(); 

        //String eingabe = scan.next();
        
        //berechne.berechne(eingabe);
        
        switch (op1) {
                case "*": rech = new Multipliziere();
                        erg = rech.rechne(x, y); break;
                case ":":
                        rech = new Dividiere();
                        erg = rech.rechne(x, y); break;
                    case "^":
                        rech = new Potenzieren();
                        erg = rech.rechne(x, y); break;    
            }
            
                zwischenErgebnis(y, erg);
           
            switch (op2) {
                case "*": rech = new Multipliziere();
                        erg = rech.rechne(zw, z); break;
                case ":":
                        rech = new Dividiere();
                        erg = rech.rechne(zw, z); break;
                    case "^":
                        rech = new Potenzieren();
                        erg = rech.rechne(x, y); break;   
            }
            

                zwischenErgebnis(y, erg);
            
            switch (op1) {
                case "+": rech = new Addiere();
                        erg = rech.rechne(x, zw); break;
                case "-":
                        rech = new Subtrahiere();
                        erg = rech.rechne(x, zw);   break;                        
            }

                zwischenErgebnis(y, erg);
            
            switch (op2) {
                case "+": rech = new Addiere();
                        erg = rech.rechne(zw,z);break;
                case "-":
                        rech = new Subtrahiere();
                        erg = rech.rechne(zw,z);  break;                        
            }
        
        aus.gibErgebnis(erg);
        

        System.out.println("");
        System.out.println("Noch eine Rechenoperation? Eingabe 'Ja':  ");
        String bool = scan.next();
        
        if(!bool.equals("ja")) {
            stop = true;
         }
        }
    }
    
    public static double zwischenErgebnis(double y, double erg){
        if(erg !=0){
            zw = erg;
            }
            else {
                zw = y;
            }
        return zw;
    }
    
}




