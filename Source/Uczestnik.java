/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symulatorjava;
import java.util.ArrayList;
import java.util.Random;
import java.lang.Runnable;
import java.io.*;

/**
 *
 * @author Krzysztof Pasiewicz
 */
public class Uczestnik implements Runnable, Serializable {
    private String imie;
    private String nazwisko;
    private double budzet;
    private ArrayList <Akcje> mojeA = new ArrayList<>(); 
    private ArrayList <Surowiec> mojeS = new ArrayList<>();
    private ArrayList <Waluta> mojeW = new ArrayList<>();
    //private Object monitor = new Object();
    
    public void ustawParam(String i, String n){
        Random los = new Random();
        imie = i;
        nazwisko = n;
        budzet = Math.abs(los.nextDouble()*10000);
    }

    public String getImie() {
        return imie;
    }

    public double getBudzet() {
        return budzet;
    }

    public String getNazwisko() {
        return nazwisko;
    }
    
    public void zwiekszBudzet(){
        Random los = new Random();
        this.budzet+=(los.nextDouble()*1000);
        System.out.println("Pozyczka");
    }
    public void kupAkcje(){
        double pom;
        Random los = new Random();
        int celID = los.nextInt(SymulatorJava.akcje.size());
        synchronized(SymulatorJava.monitorA){
        Akcje cel = SymulatorJava.akcje.get(celID);
        Akcje mojaA;
        String pomoc = cel.getSpolka();
        //GET MARZA _ OGARNAC
        double marza =1;
            for (Gielda gielda : SymulatorJava.gieldy) {
                marza = gielda.wlMarza(pomoc);
                if(marza!=0){
                    break;
                }
            }
        //KONIEC
        int ilosc = Math.abs(los.nextInt(cel.getIlosc()));
        double cena = cel.getWartosc();
        boolean test = false;
        pom = ilosc*cena;
        pom += pom*marza;
        while(pom>budzet && ilosc>0)
        {
            ilosc--;
            pom = ilosc*cena;
            pom += pom*marza;
        }
        for (int i = 0; i < mojeA.size(); i++) {
            mojaA = mojeA.get(i);
            if(cel.getNazwa().equals(mojaA.getNazwa())){
                budzet-=pom;
                cel.sprzedaj(ilosc);
                mojaA.kup(ilosc);
                cel.op();
                SymulatorJava.akcje.set(celID, cel);
                mojeA.set(i, mojaA);
                for (Spolka spolka : SymulatorJava.spolki) {
                    if(spolka.getNazwa().equals(pomoc)){
                        spolka.strata(pom);
                        spolka.wol(ilosc);
                    }
                }
                test=true;
                break;
            }
        }
        if(test==false){
            mojaA = new Akcje();
            budzet-=pom;
            mojaA.kopiuj(cel);
            mojaA.setIlosc(ilosc);
            mojeA.add(mojaA);
            cel.sprzedaj(ilosc);
            cel.op();
            SymulatorJava.akcje.set(celID, cel);
            for (Spolka spolka : SymulatorJava.spolki) {
                    if(spolka.getNazwa().equals(pomoc)){
                        spolka.strata(pom);
                        spolka.wol(ilosc);
                    }
                }
        }
        }
        
        System.out.println("Kupno Akcji udane!!!");
    }
    
    public void sprzedajAkcje(){
        Random los = new Random();
        Akcje mojaA;
        Akcje sprzedaz;
        int ileAk = SymulatorJava.akcje.size();
        double pom;
        if(mojeA.size()>0){
            int celID = los.nextInt(mojeA.size());
            mojaA = mojeA.get(celID);
            for (int i = 0; i < ileAk; i++) {
                synchronized(SymulatorJava.monitorA){
                sprzedaz = SymulatorJava.akcje.get(i);
                if(sprzedaz.getNazwa().equals(mojaA.getNazwa())){
                    int ilosc = Math.abs(los.nextInt(mojaA.getIlosc()));
                    double marza =1;
                    for (Gielda gielda : SymulatorJava.gieldy) {
                        marza = gielda.wlMarza(mojaA.getSpolka());
                        if(marza!=0) break;
                    }
                    pom = ilosc*sprzedaz.getWartosc();
                    pom -= pom*SymulatorJava.rs.getMarza();
                    budzet+=pom;
                    sprzedaz.kup(ilosc);
                    sprzedaz.op();
                    mojaA.sprzedaj(ilosc);
                    mojeA.set(celID, mojaA);
                    SymulatorJava.akcje.set(i, sprzedaz);
                    for (Spolka spolka : SymulatorJava.spolki) {
                    if(spolka.getNazwa().equals(mojaA.getNazwa())){
                        spolka.strata(pom);
                        spolka.wol(ilosc);
                    }
                }
                }
                }
            }
            System.out.println("Cos sprzedalem XD");
        }
    }
    
    public void kupWalute(){
        double pom;
        Random los = new Random();
        int celID = los.nextInt(SymulatorJava.waluty.size());
        synchronized(SymulatorJava.monitorW){
        Waluta cel = SymulatorJava.waluty.get(celID);
        Waluta mojaW;
        double marza = SymulatorJava.rw.getMarza();
        int ilosc = Math.abs(los.nextInt(cel.getIlosc()));
        double cena = cel.getKupno();
        boolean test = false;
        pom = ilosc*cena;
        pom += pom*marza;
        while(pom>budzet && ilosc>0)
        {
            ilosc--;
            pom = ilosc*cena;
            pom += pom*marza;
        }
        for (int i = 0; i < mojeW.size(); i++) {
            mojaW = mojeW.get(i);
            if(cel.getNazwa().equals(mojaW.getNazwa())){
                budzet-=pom;
                cel.sprzedaj(ilosc);
                mojaW.kup(ilosc);
                cel.op();
                SymulatorJava.waluty.set(celID, cel);
                mojeW.set(i, mojaW);
                test=true;
                break;
            }
        }
        if(test==false){
            mojaW = new Waluta();
            mojaW.kopiuj(cel);
            mojaW.setIlosc(ilosc);
            mojeW.add(mojaW);
            cel.sprzedaj(ilosc);
            cel.op();
            SymulatorJava.waluty.set(celID, cel);
        }
        }
        System.out.println("Kupno waluty udane!!!");
    }
    
    public void sprzedajWalute(){
        Random los = new Random();
        Waluta mojaW;
        //Waluta sprzedaz;
        //int ileWal = SymulatorJava.waluty.size();
        double pom;
        if(mojeW.size()>0){
            int celID = los.nextInt(mojeW.size());
            mojaW = mojeW.get(celID);
            synchronized(SymulatorJava.monitorW){
                for (Waluta sprzedaz : SymulatorJava.waluty) {
               
                //sprzedaz = SymulatorJava.waluty.get(i);
                if(sprzedaz.getNazwa().equals(mojaW.getNazwa())){
                    int ilosc = Math.abs(los.nextInt(mojaW.getIlosc()));
                    pom = ilosc*sprzedaz.getSprzedaz();
                    pom -= pom*SymulatorJava.rw.getMarza();
                    budzet+=pom;
                    sprzedaz.kup(ilosc);
                    sprzedaz.op();
                    mojaW.sprzedaj(ilosc);
                    mojeW.set(celID, mojaW);
                    //SymulatorJava.waluty.set(i, sprzedaz);
                    System.out.println("Cos sprzedalem XD");
                }
                }
            }
            
        }
    }
    
    public void kupSurowiec(){
        double pom;
        Random los = new Random();
        int celID = los.nextInt(SymulatorJava.surowce.size());
        synchronized(SymulatorJava.monitorS){
        Surowiec cel = SymulatorJava.surowce.get(celID);
        Surowiec mojS;
        double marza = SymulatorJava.rs.getMarza();
        int ilosc = Math.abs(los.nextInt(cel.getIlosc()));
        double cena = cel.getWartosc();
        boolean test = false;
        pom = ilosc*cena;
        pom += pom*marza;
        while(pom>budzet && ilosc>0)
        {
            ilosc--;
            pom = ilosc*cena;
            pom += pom*marza;
        }
        for (int i = 0; i < mojeS.size(); i++) {
            mojS = mojeS.get(i);
            if(cel.getNazwa().equals(mojS.getNazwa()))
            {
                
                budzet-=pom;
                cel.sprzedaj(ilosc);
                mojS.kup(ilosc);
                cel.op();
                SymulatorJava.surowce.set(celID, cel);
                mojeS.set(i, mojS);
                test=true;
                break;
                
            }
        }
        if(test==false){
            mojS = new Surowiec();
            mojS.kopiuj(cel);
            mojS.setIlosc(ilosc);
            mojeS.add(mojS);
            cel.sprzedaj(ilosc);
            cel.op();
            SymulatorJava.surowce.set(celID, cel);
        }
        }
        System.out.println("Kupno surowca udane!!!");
    }
    
    public void sprzedajSurowiec(){
        Random los = new Random();
        Surowiec mojS;
        //Surowiec sprzedaz;
        //int ileSur = SymulatorJava.surowce.size();
        double pom;
        if(mojeS.size()>0){
            int celID = los.nextInt(mojeS.size());
            mojS = mojeS.get(celID);
            synchronized(SymulatorJava.monitorS){
            for (Surowiec sprzedaz : SymulatorJava.surowce){
                
                //sprzedaz = SymulatorJava.surowce.get(i);
                if(sprzedaz.getNazwa().equals(mojS.getNazwa())){
                    int ilosc = Math.abs(los.nextInt(mojS.getIlosc()));
                    pom = ilosc*sprzedaz.getWartosc();
                    pom -= pom*SymulatorJava.rs.getMarza();
                        budzet+=pom;
                        sprzedaz.kup(ilosc);
                        sprzedaz.op();
                        mojS.sprzedaj(ilosc);
                        mojeS.set(celID, mojS);
                        //SymulatorJava.surowce.set(i, sprzedaz);
                }
                }
            }
            System.out.println("Cos sprzedalem XD");
        }
    }
    
    @Override
    public String toString(){
        String pom = this.imie + " " + this.nazwisko;
        return pom;
    }
    
    @Override
    public void run(){
        
    }
    
}
