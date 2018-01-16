/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symulatorjava;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author Krzysztof
 */
public class WykresController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private NumberAxis xAxis = new NumberAxis();
    
    @FXML
    private NumberAxis yAxis = new NumberAxis();
           
    @FXML    
    private LineChart<Number,Number> lineChart = new LineChart<Number,Number>(xAxis,yAxis);
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //ArrayList<XYChart.Series> serL= new ArrayList<>();
        //Collection serL;
        ObservableList<XYChart.Series<Number, Number>> serL = FXCollections.observableArrayList();
        double pom;
        xAxis.setLabel("Czas");
        lineChart.setTitle("Procentowe porownanie aktywow");
        int i =0;
        if(SymulatorJava.surowce.size()>0){
        for (Surowiec arg : SymulatorJava.surowce) {
            XYChart.Series ser = new XYChart.Series();
            pom = arg.listaWart.get(0);
            i=0;
            for(double wart: arg.listaWart)
            {
                ser.getData().add(new XYChart.Data(i, (wart-pom)/pom));
                i++;
            }
            ser.setName(arg.getNazwa());
            serL.add(ser);
            ser=null;
        }
        }
        if(SymulatorJava.waluty.size()>0){
        for (Waluta arg : SymulatorJava.waluty) {
            XYChart.Series ser = new XYChart.Series();
            pom = arg.listaWart.get(0);
            i=0;
            for(double wart: arg.listaWart)
            {
                ser.getData().add(new XYChart.Data(i, (wart-pom)/pom));
                i++;
            }
            ser.setName(arg.getNazwa());
            serL.add(ser);
            ser=null;
        }
        }
        if(SymulatorJava.akcje.size()>0){
        for (Akcje arg : SymulatorJava.akcje) {
            XYChart.Series ser = new XYChart.Series();
            pom = arg.listaWart.get(0);
            i=0;
            for(double wart: arg.listaWart)
            {
                ser.getData().add(new XYChart.Data(i, (wart-pom)/pom));
                i++;
            }
            ser.setName(arg.getNazwa());
            serL.add(ser);
            ser=null;
        }
        }
            lineChart.setData(serL);
    }    
    
}
