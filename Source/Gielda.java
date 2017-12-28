/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symulator;

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
    private Indeks listaIndeks[];
    
    public void Gielda(String n, String k, String w, String m, String a, double ma){
        this.ustawPar(n, ma);
        kraj = k;
        waluta = w;
        miasto = m;
        adres = a;
    }
    
}
