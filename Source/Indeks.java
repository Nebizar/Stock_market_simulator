/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symulatorjava;

import java.util.ArrayList;

/**
 *
 * @author Krzysztof
 */
public class Indeks {
    private String nazwa;
    private ArrayList<String> spolki;
    
    public Indeks(String n){
        nazwa = n;
        spolki = new ArrayList<String>();
    }
    
    public void dodajSpolke(String sp){
        spolki.add(sp);
    }
    
    public boolean znajdz(String sp){
        for (String string : spolki) {
            if(string.equals(sp)){
                return true;
            }
        }
        return false;
    }
    
}
