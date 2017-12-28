/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symulator;
import java.util.Random;
/**
 *
 * @author Krzysztof Pasiewicz
 */
public class Uczestnik {
    private String imie;
    private String nazwisko;
    private double budzet;
    
    public void ustawParam(String i, String n){
        Random los = new Random();
        imie = i;
        nazwisko = n;
        budzet = los.nextDouble();
    }
    
    public void kupAkcje(int ilosc, Spolka cel, double marza ){
        double pom;
        if(cel.sprzedaj(ilosc, marza)==true)
        {
            pom = ilosc*cel.getkA();
            if(pom < budzet)
            budzet -= pom - (pom * marza);
        }
            
    }
    
    
}
