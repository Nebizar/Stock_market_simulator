/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symulatorjava;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Krzysztof
 */
public class SzczegolySurowcowController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label title = new Label();
    
    @FXML
    private Label wart = new Label();
    
    @FXML
    private Label wMin = new Label();
    
    @FXML
    private Label wMax = new Label();
    
    @FXML
    private Label nazwa = new Label();
    
    @FXML
    private Label jednostka = new Label();
    
    @FXML
    private Label waluta = new Label();
    
    @FXML
    private NumberAxis xAxis = new NumberAxis();
    
    @FXML
    private NumberAxis yAxis = new NumberAxis();
           
    @FXML    
    private LineChart<Number,Number> lineChart = new LineChart<Number,Number>(xAxis,yAxis);
                
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        double pom;
        nazwa.setText(FXMLDocumentController.pomS.getNazwa());
        jednostka.setText(FXMLDocumentController.pomS.getJednostka());
        waluta.setText(FXMLDocumentController.pomS.getWaluta());
        pom = FXMLDocumentController.pomS.getWartosc();
        wart.setText(String.valueOf(pom));
        pom = FXMLDocumentController.pomS.getwMin();
        wMin.setText(String.valueOf(pom));
        pom = FXMLDocumentController.pomS.getwMax();
        wMax.setText(String.valueOf(pom));
        xAxis.setLabel("Czas");
        lineChart.setTitle("Wartosc surowca w czasie");
        XYChart.Series series = new XYChart.Series();
        series.setName(FXMLDocumentController.pomS.getNazwa());
        int i =0;
        double arg;
        for (int j = 0; j < FXMLDocumentController.pomS.listaWart.size(); j++)
        {
            arg =FXMLDocumentController.pomS.listaWart.get(j);
            series.getData().add(new XYChart.Data(i, arg));
            //System.out.println(arg);
            i+=10;
        }
        lineChart.getData().add(series);
        
    }    
    
}
