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
public class NameGenerator {
    private final String[] imiona = {"Krzysztof","Maciej","Szymon","Filip","Agnieszka","Barbara","Zofia","Stanisław"};
    private final String[] nazwiska ={"Nowak","Kowalski","Kartofel","Kiełbasa","Kołek","Bolec","Zawadzki","Pawlak"};
    private final String[] nazwaF = {"Fundusz1","fundusz2","Fundusz3","Fundusz4","Fundusz5"};
    private final String[] nazwaS = {"Spolka1","Spolka2","Spolka3","Spolka4","Spolka5"};
    private final String[] sufix = {"DC","FX","XD","ORG","COM","EU","PL"};
    private final String[] jednostki = {"kilogram","uncja","tona","gram"};
    private final String[] waluty = {"Dolar","PLN","Rubel","Funt","Euro","Jen","Frank","Kuna"};
    private final String[] surowce = {"Złoto","Stal","Miedź","Uran","Kobalt","Diament"};
    private final String[] rynki = {"Nowojorska","Wall Street","Tokio",};
    private final String[] miasta = {"Nowy Jork","Londyn","Poznan","Pekin","Tokio","Moskwa","Johannesburg"};
    private final String[] kraje = {"USA","WIelka Brytania","Polska","Chiny","Japonia","Rosja","RPA"};
    private final String[] indeksy = {"WIG20","WIG30","WIG","mWIG40","sWIG80","NCIndex"};
    private int pom =0;
    private String kombo = "";
    private Random los = new Random();
    private long pesel;
    
    public String imie(){
        pom=los.nextInt(imiona.length);
        return imiona[pom];
    }
    
    public String nazwisko(){
        pom = los.nextInt(nazwiska.length);
        return nazwiska[pom];
    }
    
    public String fundusz(){
        pom = los.nextInt(nazwaF.length);
        kombo = nazwaF[pom];
        pom = los.nextInt(sufix.length);
        kombo += sufix[pom];
        return kombo;
    }
    
    public String pesel(){
        pesel = los.nextLong()%99999;
        long pom = los.nextLong()%99999;
        String wyj = String.valueOf(pesel) + String.valueOf(pom);
        return wyj;
    }
    
    public String data(){
        int d, m, r;
        String wyj;
        d = los.nextInt(30)+1;
        m=los.nextInt(12)+1;
        r = los.nextInt(10)+2007;
        wyj = String.valueOf(d)+"."+String.valueOf(m)+"."+String.valueOf(r);
        return wyj;
    }
    
    public String spolka(){
        pom = los.nextInt(nazwaS.length);
        kombo = nazwaS[pom];
        pom = los.nextInt(sufix.length);
        kombo += sufix[pom];
        return kombo;
    }
    
    public String surowiec(){
        pom=los.nextInt(surowce.length);
        return surowce[pom];
    
    }
    public String jednostka(){
        pom = los.nextInt(jednostki.length);
        return jednostki[pom];
    }
    
    public String waluta(){
        pom = los.nextInt(waluty.length);
        return waluty[pom];
    }
    
    public String miasto(){
        pom = los.nextInt(miasta.length);
        return miasta[pom];
    }
    
    public String kraj(){
        pom = los.nextInt(kraje.length);
        return kraje[pom];
    }
    
    public String indeks(){
        pom = los.nextInt(indeksy.length);
        return indeksy[pom];
    }
    
    public String gielda(){
        pom = los.nextInt(rynki.length);
        return rynki[pom];
    }
    
}
