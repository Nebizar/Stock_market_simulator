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
public class Aktualizer implements Runnable {
    private Object monitor = new Object();
    
    @Override
    public void run(){
        Random los = new Random();
        while(true){
            while(los.nextInt(10000000)!=2){}
            if(SymulatorJava.waluty.size()>0 && (SymulatorJava.inwestorzy.size()>0 || SymulatorJava.fundusze.size()>0)){
            synchronized(SymulatorJava.monitorW){
            for (Waluta arg : SymulatorJava.waluty) {
                arg.aktualizuj();
            }
            }
            }
            if(SymulatorJava.surowce.size()>0 && (SymulatorJava.inwestorzy.size()>0 || SymulatorJava.fundusze.size()>0)){
            synchronized(SymulatorJava.monitorS){
            for (Surowiec arg : SymulatorJava.surowce) {
                arg.aktualizuj();
            }
            }
            }
            if(SymulatorJava.akcje.size()>0 && (SymulatorJava.inwestorzy.size()>0 || SymulatorJava.fundusze.size()>0)){
            synchronized(SymulatorJava.monitorA){
                for (Akcje arg : SymulatorJava.akcje) {
                    arg.aktualizuj();
                }
            }
            }
            
        }
    }
}
