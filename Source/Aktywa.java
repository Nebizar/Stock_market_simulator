/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symulatorjava;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Krzysztof
 */
public class Aktywa implements Serializable {
    private String nazwa;
    private int iloscOp;
    private int ilosc;
    public static List<Double> listaWart = new ArrayList<Double>();
    //private int jUczestnictwa;
    
    public void ustawParam(String n, int ile){
        nazwa = n;
        ilosc = Math.abs(ile);
        iloscOp = 0;
        //System.out.println(ile);
        //jUczestnictwa = j;
    }
    
    public void op(){
        iloscOp++;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }
    
    public void sprzedaj(int ile){
        ilosc-=ile;
    }
    
    public void kup(int ile){
        ilosc+=ile;
    }
    
    
    public int getOp(){
        int pom = iloscOp;
        iloscOp = 0;
        return pom;
    }
    
    public String getNazwa(){
        return this.nazwa;
    }
    
    public void DodajWart(double wart){
        listaWart.add(wart);
    }
    
    @Override
    public String toString(){
        return this.nazwa;
    }
}
