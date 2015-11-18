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
public interface DBAnbindung {
    
    void ausgabeDB()  ;

    void anzahlBerechnungen();
    
    void DurchschnittAllerZahlen();
    
    void anzahlPlusOperationen();
    
    void durchschnittLetzterNeunZahlen();
    
    void berechnungHinzufuegen(double eins, double zwei, double drei, String op1, String op2);

}
