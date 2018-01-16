/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symulatorjava;
import java.io.*;

/**
 *
 * @author Krzysztof
 */
public class Rynek implements Serializable{
    private String nazwa;
    private double marza;
    
    public void ustawPar(String n, double m){
        nazwa = n;
        marza = m;
    }
    
    public double getMarza(){
        return marza;
    }
}
