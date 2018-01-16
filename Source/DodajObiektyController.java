/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symulatorjava;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.stage.Stage;
import javafx.stage.Window;


/**
 * FXML Controller class
 *
 * @author Krzysztof
 */
public class DodajObiektyController implements Initializable {

    private ObservableList<String> names = FXCollections.observableArrayList();
    //private ObservableList<String> data = FXCollections.observableArrayList();
    @FXML
    private final Label tytul = new Label();
   
    @FXML
    private ListView<String> obiekty = new ListView<String>();
    
    @FXML
    private Button stworz = new Button();
    
    @FXML
    private Button wstecz = new Button();
    
    @FXML
    public void handlePress(ActionEvent event){
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    public void handleMouseClick(ActionEvent event) throws Exception{
        String pom;
        NameGenerator generator = new NameGenerator();
        Window owner = stworz.getScene().getWindow();
        try{
            pom = obiekty.getSelectionModel().getSelectedItem();
            //System.out.println("Cos dziala");
            if(pom=="Waluta"){
                //System.out.println("Chce walute");
                pom=generator.waluta();
                System.out.println(pom);
                Waluta nowaWaluta = new Waluta(pom);
                //System.out.println("elo");
                synchronized(SymulatorJava.monitorW){
                    SymulatorJava.waluty.add(nowaWaluta);
                }
                //System.out.println("mamy to");
                nowaWaluta=null;
            }
            if(pom=="Surowiec"){
                //System.out.println("Chce surowiec");
                pom=generator.surowiec();
                System.out.println(pom);
                Surowiec nowySurowiec = new Surowiec(pom, generator.jednostka(), generator.waluta());
                //System.out.println("Chce surowiec");
                synchronized(SymulatorJava.monitorS){
                    SymulatorJava.surowce.add(nowySurowiec);
                }
                nowySurowiec=null;
            }
            if(pom=="Giełda"){
                //System.out.println("Chce gielde");
                pom = generator.miasto();
                Gielda nowaGielda = new Gielda(generator.gielda(),generator.kraj(),generator.waluta(),pom,pom);
                Indeks in = new Indeks(generator.indeks());
                nowaGielda.addIndeks(in);
                SymulatorJava.gieldy.add(nowaGielda);
                System.out.println("Nowa giełda w "+ pom);
                nowaGielda=null;
            }
            if(pom=="Indeks")
            {
                if(SymulatorJava.gieldy.size()>0){
                    Indeks nowyIndeks = new Indeks(generator.indeks());
                    Random los = new Random();
                    int wybor = los.nextInt(SymulatorJava.gieldy.size());
                    Gielda gPom;
                    gPom = SymulatorJava.gieldy.get(wybor);
                    gPom.addIndeks(nowyIndeks);
                    SymulatorJava.gieldy.set(wybor, gPom);
                    gPom=null;
                }
                else
                    AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Error!", "W pierwszej kolejności stwórz gielde !");
            }
            if(pom=="Spółka"){
                String sp = generator.spolka();
                Spolka nowaSpolka = new Spolka(sp,generator.data());
                if(SymulatorJava.gieldy.size()>0){
                    Random los = new Random();
                    Gielda gielda = SymulatorJava.gieldy.get(los.nextInt(SymulatorJava.gieldy.size()));
                    gielda.dodajSp(sp);
                    String nazwaAkcji = nowaSpolka.getNazwa() + "(Akcje)";
                    Akcje noweAkcje = new Akcje(nazwaAkcji,sp,nowaSpolka.getlAkcji());
                    System.out.println("Nowa spolka!!");
                    SymulatorJava.spolki.add(nowaSpolka);
                    synchronized(SymulatorJava.monitorA){
                        SymulatorJava.akcje.add(noweAkcje);
                    }
                    new Thread(nowaSpolka).start();
                    noweAkcje=null;
                    nowaSpolka = null;
                }
                else{
                    AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Error!", "W pierwszej kolejności stwórz gielde !");
                }
                
            }
            if(pom=="Inwestor"){
                Inwestor nowyInwestor = new Inwestor(generator.imie(),generator.nazwisko(),generator.pesel());
                System.out.println("Nowy Inwestor!!");
                SymulatorJava.inwestorzy.add(nowyInwestor);
                new Thread(nowyInwestor).start();
                //nowyInwestor = null;
            }
            if(pom=="Fundusz"){
                Fundusz nowyFundusz = new Fundusz(generator.imie(),generator.nazwisko(),generator.fundusz());
                System.out.println("Nowy Fundusz!!");
                SymulatorJava.fundusze.add(nowyFundusz);
                nowyFundusz = null;
            }
            }catch(Exception e){
             AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Error!", 
                    "Wybierz co należy stworzyć!");
        }
    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //data.add("Wybierz obiekt do stworzenia");
        names.addAll("Waluta","Surowiec","Inwestor","Giełda","Indeks","Spółka","Fundusz");
        obiekty.setEditable(true);
        obiekty.setItems(names);
        //obiekty.setCellFactory(ComboBoxListCell.forListView(names));
    }    
    
}
