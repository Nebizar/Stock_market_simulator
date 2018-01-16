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
public class RynekWalut extends Rynek{
    private Waluta waluta;
    
    public RynekWalut(){
        Random los = new Random();
        this.ustawPar("Rynek Walut",los.nextDouble() );
    }
    
}
