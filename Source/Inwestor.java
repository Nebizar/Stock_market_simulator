/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symulator;

/**
 *
 * @author Krzysztof
 */
public class Inwestor extends Uczestnik{
    private String pesel;
    
    public void Inwestor(String i, String n, String p){
        this.ustawParam(i, n);
        pesel = p;
    }
    
}
