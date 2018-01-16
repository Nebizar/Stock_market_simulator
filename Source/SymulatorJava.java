/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symulatorjava;

import java.util.ArrayList;
import java.util.Set;
import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.collections.ArrayChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Krzysztof
 */
public class SymulatorJava extends Application {
    
    public static ObservableList<Waluta> waluty = FXCollections.observableArrayList();
    public static ObservableList<Surowiec> surowce = FXCollections.observableArrayList();
    public static ObservableList<Akcje> akcje = FXCollections.observableArrayList();
    public static ObservableList<Gielda> gieldy = FXCollections.observableArrayList();
    public static ObservableList<Spolka> spolki = FXCollections.observableArrayList();
    public static ObservableList<Inwestor> inwestorzy = FXCollections.observableArrayList();
    public static ObservableList<Fundusz> fundusze = FXCollections.observableArrayList();
    public static RynekWalut rw = new RynekWalut();
    public static RynekSurowcow rs = new RynekSurowcow();
    public static final Object monitorW = new Object();
    public static final Object monitorS = new Object();
    public static final Object monitorA = new Object();
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Thread(new Aktualizer()).start();
        launch(args);
        Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
        for (Thread t : Thread.getAllStackTraces().keySet()) 
        {  if (t.getState()==Thread.State.RUNNABLE) 
            t.interrupt(); 
        } 

        for (Thread t : Thread.getAllStackTraces().keySet()) 
        {  if (t.getState()==Thread.State.RUNNABLE) 
            t.stop(); 
        }
    }
}
