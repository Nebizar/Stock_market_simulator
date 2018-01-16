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
public class Surowiec extends Aktywa{
    private String jednostka;
    private String waluta;
    private double wartosc;
    private double wMin;
    private double wMax;
    
    public Surowiec(String n, String j, String w){
        Random los = new Random();
        this.ustawParam(n,los.nextInt()%1000000000);
        jednostka = j;
        waluta = w;
        wartosc = los.nextDouble();
        wMin = wartosc;
        wMax = wartosc;
    }
    
    public Surowiec(){
        
    }
    
    public void kopiuj(Surowiec s){
        this.ustawParam(s.getNazwa(), s.getIlosc());
        jednostka = s.jednostka;
        waluta = s.waluta;
        wartosc = s.wartosc;
        wMin = s.wMin;
        wMax = s.wMax;
    }
    
    public void aktualizuj(){
        Random los = new Random();
        this.DodajWart(wartosc);
        //synchronized(SymulatorJava.monitorS){
        int iloscOp = this.getOp();
        if(iloscOp==0 && wartosc>0){
            wartosc -= los.nextDouble()%wartosc;
        }
        else{
            wartosc += iloscOp*los.nextDouble()%0.55;
        }
        if(wartosc<wMin) wMin = wartosc;
        if(wartosc>wMax) wMax = wartosc;
        iloscOp = 0;
        System.out.println("AKtual SUROWIEC");
    }
 
    
    
    public String getJednostka() {
        return jednostka;
    }

    public String getWaluta() {
        return waluta;
    }

    public double getWartosc() {
        return wartosc;
    }

    public double getwMin() {
        return wMin;
    }

    public double getwMax() {
        return wMax;
    }
}
