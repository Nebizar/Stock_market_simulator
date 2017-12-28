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
public class Fundusz extends Uczestnik{
    private String nazwa;
    
    public void Fundusz(String i, String n, String n2){
        this.ustawParam(i, n);
        nazwa = n2;
    }
}
