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
public class Seria implements Serializable{
    private Akcje akcje[];
    private Surowiec surowce[];
    private Waluta waluty[];
    private Gielda gieldy[];
    private Spolka spolki[];
    private Inwestor inwestorzy[];
    private Fundusz fundusze[];
    private RynekSurowcow rynS;
    private RynekWalut rynW;
    
    
    public Seria(){
        akcje = new Akcje[SymulatorJava.akcje.size()];
        akcje = SymulatorJava.akcje.toArray(akcje);
        surowce = new Surowiec[SymulatorJava.surowce.size()];
        surowce = SymulatorJava.surowce.toArray(surowce);
        waluty = new Waluta[SymulatorJava.waluty.size()];
        waluty = SymulatorJava.waluty.toArray(waluty);
        inwestorzy = new Inwestor[SymulatorJava.inwestorzy.size()];
        inwestorzy = SymulatorJava.inwestorzy.toArray(inwestorzy);
        fundusze = new Fundusz[SymulatorJava.fundusze.size()];
        fundusze = SymulatorJava.fundusze.toArray(fundusze);
        spolki = new Spolka[SymulatorJava.spolki.size()];
        spolki = SymulatorJava.spolki.toArray(spolki);
        gieldy = new Gielda[SymulatorJava.gieldy.size()];
        gieldy = SymulatorJava.gieldy.toArray(gieldy);
        rynS = SymulatorJava.rs;
        rynW = SymulatorJava.rw;
    }
    
    public void odczytaj(){
        SymulatorJava.akcje.addAll(akcje);
        SymulatorJava.surowce.addAll(surowce);
        SymulatorJava.waluty.addAll(waluty);
        SymulatorJava.inwestorzy.addAll(inwestorzy);
        SymulatorJava.fundusze.addAll(fundusze);
        SymulatorJava.gieldy.addAll(gieldy);
        for (Inwestor arg : SymulatorJava.inwestorzy) {
            new Thread(arg).start();
        }
        for (Fundusz arg : SymulatorJava.fundusze) {
            new Thread(arg).start();
        }
        for (Spolka arg : SymulatorJava.spolki) {
            new Thread(arg).start();
        }
    }
    
    
}
