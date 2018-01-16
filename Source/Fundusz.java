/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symulatorjava;

import java.util.Random;

/**
 *
 * @author Krzysztof
 */
public class Fundusz extends Uczestnik{
    private String nazwa;
    private int jednostki;
    private double wartosc;
    
    public Fundusz(String i, String n, String n2){
        Random los = new Random();
        this.ustawParam(i, n);
        nazwa = n2;
        jednostki = los.nextInt()%100;
        wartosc = this.getBudzet()/jednostki;
    }

    public String getNazwa() {
        return nazwa;
    }
    
    @Override
    public String toString(){
        return this.nazwa;
    }
    
    @Override
    public void run(){
        Random los = new Random();
        while(true){
            if(los.nextInt()%3==2 && SymulatorJava.akcje.size()>0 && SymulatorJava.gieldy.size()>0)this.kupAkcje();
            if(los.nextInt()%3==0)this.sprzedajAkcje();
            if(los.nextInt()%3==1 && SymulatorJava.waluty.size()>0)this.kupWalute();
            if(los.nextInt()%3==2 && SymulatorJava.surowce.size()>0)this.kupSurowiec();
            if(los.nextInt()%3==0)this.sprzedajWalute();
            if(los.nextInt()%3==2)this.sprzedajSurowiec();
            if(los.nextInt()%10==1)this.zwiekszBudzet();
        }
    }
}
