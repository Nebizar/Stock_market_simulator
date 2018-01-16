/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symulatorjava;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import java.io.*;

/**
 *
 * @author Krzysztof
 */
public class FXMLDocumentController implements Initializable {
    
    public static Waluta pomW;
    public static Akcje pomA;
    public static Surowiec pomS;
    public static Spolka pomSp;
    public static Inwestor pomI;
    public static Fundusz pomF;
    private final String plik = "data.ser";
    
    @FXML
    private Label label;
    
    
    @FXML
    private ListView<Waluta> walutyL = new ListView<>();
    
    //@FXML
    @FXML public void handleWaluty(Event event){
        //Window owner = button.getScene().getWindow();
        try {
            pomW = walutyL.getSelectionModel().getSelectedItem();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SzczegolyWalut.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));  
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
          }
    }
    
    @FXML
    private ListView<Akcje> akcjeL = new ListView<>();
    
    @FXML public void handleAkcje(Event event){
        //Window owner = button.getScene().getWindow();
        try {
            pomA = akcjeL.getSelectionModel().getSelectedItem();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SzczegolyAkcji.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));  
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
          }
    }
    
    @FXML
    private ListView<Surowiec> surowceL = new ListView<>();
    
    @FXML public void handleSurowce(Event event){
        //Window owner = button.getScene().getWindow();
        try {
            pomS = surowceL.getSelectionModel().getSelectedItem();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SzczegolySurowcow.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));  
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
          }
    }
    
    @FXML
    private ListView<Spolka> spolkiL = new ListView<>();
    
    @FXML public void handleSpolka(Event event){
        //Window owner = button.getScene().getWindow();
        try {
            pomSp = spolkiL.getSelectionModel().getSelectedItem();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SzczegolySpolek.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));  
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
          }
    }
    
    @FXML
    private ListView<Inwestor> inwestorzyL = new ListView<>();
    
    @FXML public void handleInwestor(Event event){
        //Window owner = button.getScene().getWindow();
        try {
            pomI = inwestorzyL.getSelectionModel().getSelectedItem();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SzczegolyInwestorow.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));  
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
          }
    }
    
    @FXML
    private ListView<Fundusz> funduszeL = new ListView<>();
    
    @FXML public void handleFundusz(Event event){
        //Window owner = button.getScene().getWindow();
        try {
            pomF = funduszeL.getSelectionModel().getSelectedItem();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SzczegolyFunduszy.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));  
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
          }
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DodajObiekty.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));  
                stage.show();
        } catch(Exception e) {
            e.printStackTrace();
          }
    }
    
    @FXML
    private void handleSave(ActionEvent event) throws IOException{
        Seria zapis = new Seria();
        try{
        ObjectOutputStream out = new ObjectOutputStream(
                               new BufferedOutputStream(
                                 new FileOutputStream(plik)));
        out.writeObject(zapis);
        out.close();
        }catch(IOException e){
            System.out.println("ERROR");
        }
    }
    
    @FXML
    private void handleChart(ActionEvent event) throws Exception{
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Wykres.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));  
                stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void handleLoad(ActionEvent event) throws IOException{
        Seria odczyt;
        try{
        ObjectInputStream in = new ObjectInputStream(
                             new BufferedInputStream(
                               new FileInputStream(plik)));
        try{
        odczyt =(Seria) in.readObject();
        in.close();
        odczyt.odczytaj();
        }catch(ClassNotFoundException e){
            System.out.println("ERROR");
        }
        }catch(IOException e){
            System.out.println("ERROR LOAD");
        }
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        surowceL.setItems(SymulatorJava.surowce);
        akcjeL.setItems(SymulatorJava.akcje);
        walutyL.setItems(SymulatorJava.waluty);
        spolkiL.setItems(SymulatorJava.spolki);
        inwestorzyL.setItems(SymulatorJava.inwestorzy);
        funduszeL.setItems(SymulatorJava.fundusze);
        // TODO
    }    
    
}
