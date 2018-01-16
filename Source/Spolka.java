/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symulatorjava;
import java.util.Random;
import java.io.*;
/**
 *
 * @author Krzysztof
 */
public class Spolka implements Runnable, Serializable {
    private String nazwa;
    private String data;
    private double kO;
    private double kA;
    private double kMin;
    private double kMax;
    private int lAkcji;
    private double zysk;
    private double przychod;
    private double kapitalWl;
    private double kapitalZ;
    private int wolumen;
    private int obroty; 
   
    
    public Spolka(String n, String d){
        Random los = new Random();
        nazwa = n;
        data = d;
        kO = los.nextDouble()*10000;
        kA = kO;
        kMin = kA;
        kMax = kA;
        lAkcji = los.nextInt(100);
        zysk =0;
        przychod = 0;
        kapitalWl = los.nextDouble()*1000;
        kapitalZ = los.nextDouble()*1000;
        wolumen = 0;
        obroty = 0;
        
    }
    
    public void zysk(double ile){
        kA+=ile;
        //if(kA<kMin)kMin = kA;
        if(kA>kMax)kMax = kA;
        obroty+=ile;
        zysk+=ile;
        przychod+=ile;
    }
    
    public void strata(double ile){
        kA-=ile;
        if(kA<kMin)kMin=kA;
        obroty-=ile;
        zysk-=ile;
    }
    
    public void wol(int ile){
        wolumen+=ile;
    }
    
    
    
    
    public String getNazwa() {
        return nazwa;
    }

    public String getData() {
        return data;
    }

    public double getkO() {
        return kO;
    }

    public double getkA() {
        return kA;
    }

    public double getkMin() {
        return kMin;
    }

    public double getkMax() {
        return kMax;
    }

    public int getlAkcji() {
        return lAkcji;
    }

    public double getZysk() {
        return zysk;
    }

    public double getPrzychod() {
        return przychod;
    }

    public double getKapitalWl() {
        return kapitalWl;
    }

    public double getKapitalZ() {
        return kapitalZ;
    }

    public int getWolumen() {
        return wolumen;
    }

    public int getObroty() {
        return obroty;
    }
    
    public void wygenerujAkcje(){
        Random los = new Random();
        int nA = los.nextInt(20);
        this.lAkcji+=nA;
        int iloscSp = SymulatorJava.akcje.size();
        Akcje check;
        String pom = this.nazwa+"(Akcje)";;
        int iloscAk;
        for (int i = 0; i < iloscSp; i++) {
            check = SymulatorJava.akcje.get(i);
            if(pom.equals(check.getNazwa())){
                iloscAk = check.getIlosc();
                iloscAk+=nA;
                check.setIlosc(iloscAk);
                SymulatorJava.akcje.set(i, check);
                System.out.println("Nowe akcje na rynku od "  + this.nazwa);
            }
        }
    } 
    
    @Override
    public String toString(){
        return this.nazwa;
    }
    
    @Override
    public void run(){
        Random los = new Random();
        while(true){    
            if(los.nextInt()%100000==123){
                while(los.nextInt()%1000000!=2){}
                while(los.nextInt()%1000000!=3){}
                this.wygenerujAkcje();
                //System.out.println("Nowe akcje sa");
            }
        }
    }
}
