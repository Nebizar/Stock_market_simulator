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
public class Inwestor extends Uczestnik{
    private final String pesel;
    
    public Inwestor(String i, String n, String p){
        this.ustawParam(i, n);
        pesel = p;
    }

    public String getPesel() {
        return pesel;
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
