/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symulatorjava;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author Krzysztof
 */
public class Waluta extends Aktywa{
    private double kupno;
    private double sprzedaz;
    private ArrayList<String> listaKraj;
    
    public Waluta(String n){
        Random los = new Random();
        kupno = los.nextDouble();
        sprzedaz = los.nextDouble();
        int j = los.nextInt();
        this.ustawParam(n,los.nextInt()%1000000000);
        listaKraj = new ArrayList<String>();
    }
    
    public Waluta(){
        
    }
    
    public void kopiuj(Waluta wal){
        kupno = wal.kupno;
        sprzedaz = wal.sprzedaz;
        ustawParam(wal.getNazwa(),wal.getIlosc());
        listaKraj = wal.listaKraj;
    }
    
    public void aktualizuj(){
        Random los = new Random();
        this.DodajWart(kupno);
        //synchronized(SymulatorJava.monitorW){
        int iloscOp = this.getOp();
        if(iloscOp==0 && kupno>0){
            kupno -= los.nextDouble()%kupno;
        }
        else{
            kupno += iloscOp*los.nextDouble()%0.55;
        }
        if(iloscOp==0 && sprzedaz>0){
            sprzedaz -= los.nextDouble()%sprzedaz;
        }
        else{
            sprzedaz += iloscOp*los.nextDouble()%0.55;
        }
        iloscOp=0;
        
        //System.out.println("Zaktualizowano");
    }
    
    public double getSprzedaz(){
        return sprzedaz;
    }
    
    public double getKupno(){
        return kupno;
    }
    
   
}
