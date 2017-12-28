/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symulator;
import java.util.Random;
/**
 *
 * @author Krzysztof
 */
public class Spolka {
    private String nazwa;
    private String data1;
    private int kO;
    private int kA;
    private int kMin;
    private int kMax;
    private int lAkcji;
    private double zysk;
    private double przychod;
    private double kapitalWl;
    private double kapitalZ;
    private int wolumen;
    private int obroty;
    
    public void Spolka(String n){
        Random los = new Random();
        nazwa = n;
        kO = los.nextInt();
        kA = kO;
        kMin = kA;
        kMax = kA;
        lAkcji = los.nextInt();
        zysk =0;
        przychod = 0;
        kapitalWl = los.nextDouble();
        kapitalZ = los.nextDouble();
        wolumen = los.nextInt();
        obroty = 0;
        
    }
    
    public int getlAkcji(){
        return lAkcji;
    }
    
    public int getkA(){
        return kA;
    }
    
    public boolean sprzedaj(int ilosc, double marza){
        double pom;
        if(lAkcji>=ilosc)
        {
            lAkcji -= ilosc;
            pom = ilosc*kA;
            przychod = pom - (pom*marza);
            return true;
        }
        else return false;
    }
}
