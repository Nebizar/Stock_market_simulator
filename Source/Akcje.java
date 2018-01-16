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
public class Akcje extends Aktywa{
    private double wartosc;
    private String spolka;
    
    public Akcje(String n, String sp, int lA){
        this.ustawParam(n, lA);
        Random los = new Random();
        wartosc = los.nextDouble()*100;
        spolka = sp;
    }
    
    public Akcje(){}
    
    public void kopiuj(Akcje a){
        this.wartosc = a.wartosc;
        this.ustawParam(this.getNazwa(), this.getIlosc());
        this.spolka = a.spolka;
    }
    
    public void aktualizuj(){
        Random los = new Random();
        //synchronized(SymulatorJava.monitorS){
        this.DodajWart(wartosc);
        int iloscOp = this.getOp();
        if(iloscOp==0 && wartosc>0){
            wartosc -= los.nextDouble()%wartosc;
        }
        else{
            wartosc += iloscOp*los.nextDouble()%0.55;
        }
        iloscOp = 0;
                //System.out.println("AKtual");
    }

    public double getWartosc() {
        return wartosc;
    }

    public String getSpolka() {
        return spolka;
    }
    
    
    
    
    
}
