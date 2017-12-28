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
public class Waluta extends Aktywa{
    private double kupno;
    private double sprzedaz;
    private String[] listaKraj;
    
    public void Waluta(String n){
        Random los = new Random();
        kupno = los.nextDouble();
        sprzedaz = los.nextDouble();
        int j = los.nextInt();
        this.ustawParam(n, j);
    }
}
