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
public class Surowiec extends Aktywa{
    private String jednostka;
    private Waluta waluta;
    private double wartosc;
    private double wMin;
    private double wMax;
    
    public void Surowiec(String n, String j, Waluta w){
        Random los = new Random();
        this.ustawParam(n, los.nextInt());
        jednostka = j;
        waluta = w;
        wartosc = los.nextDouble();
        wMin = wartosc;
        wMax = wartosc;
    }
}
