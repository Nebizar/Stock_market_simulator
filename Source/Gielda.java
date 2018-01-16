/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symulatorjava;
import java.util.ArrayList;
import java.util.Random;
import javafx.scene.control.Alert;
/**
 *
 * @author Krzysztof
 */
public class Gielda extends Rynek {
    //private String nazwa;
    private String kraj;
    private String waluta; 
    private String miasto;
    private String adres;
    private ArrayList<Indeks> listaIndeks = new ArrayList<>();
    private int lInd =0;

    public int getlInd() {
        return lInd;
    }
    
    public void addIndeks(Indeks nowy){
        listaIndeks.add(nowy);
    }
    
    public Gielda(String n, String k, String w, String m, String a){
        Random los = new Random();
        this.ustawPar(n, los.nextDouble()%0.05);
        kraj = k;
        waluta = w;
        miasto = m;
        adres = a;
    }
    
    public double wlMarza(String sp){
        if(listaIndeks.size()>0){
            for (Indeks in : listaIndeks) {
                if(in.znajdz(sp)==true){
                    return this.getMarza();
                }
            }
        }
        return 0;
    }
    
    public void dodajSp(String sp){
        Random los = new Random();
        int id = los.nextInt(listaIndeks.size());
        Indeks in = listaIndeks.get(id);
        in.dodajSpolke(sp);
        listaIndeks.set(id, in);
            //return true;
        }
    
    
    
}
