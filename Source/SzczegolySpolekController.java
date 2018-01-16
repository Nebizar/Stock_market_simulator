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
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Krzysztof
 */
public class SzczegolySpolekController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label title = new Label();
    
    @FXML
    private Label nazwa = new Label();
    
    @FXML
    private Label data = new Label();
    
    @FXML
    private Label kapO = new Label();
    
    @FXML
    private Label kapA = new Label();
    
    @FXML
    private Label kMin = new Label();
    
    @FXML
    private Label kMax = new Label();
    
    @FXML
    private Label lAkcji = new Label();
    
    @FXML
    private Label zysk = new Label();
    
    @FXML
    private Label przychod = new Label();
    
    @FXML
    private Label kapWl = new Label();
    
    @FXML
    private Label kapZ = new Label();
    
    @FXML
    private Label wolumen = new Label();
    
    @FXML
    private Label obroty = new Label();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        int pom1;
        double pom2;
        nazwa.setText(FXMLDocumentController.pomSp.getNazwa());
        data.setText(FXMLDocumentController.pomSp.getData());
        pom2 = FXMLDocumentController.pomSp.getkO();
        kapO.setText(String.valueOf(pom2));
        pom2 = FXMLDocumentController.pomSp.getkA();
        kapA.setText(String.valueOf(pom2));
        pom2 = FXMLDocumentController.pomSp.getkMin();
        kMin.setText(String.valueOf(pom2));
        pom2 = FXMLDocumentController.pomSp.getkMax();
        kMax.setText(String.valueOf(pom2));
        pom1 = FXMLDocumentController.pomSp.getlAkcji();
        lAkcji.setText(String.valueOf(pom1));
        pom2 = FXMLDocumentController.pomSp.getZysk();
        zysk.setText(String.valueOf(pom2));
        pom2 = FXMLDocumentController.pomSp.getPrzychod();
        przychod.setText(String.valueOf(pom2));
        pom2 = FXMLDocumentController.pomSp.getKapitalWl();
        kapWl.setText(String.valueOf(pom2));
        pom2 = FXMLDocumentController.pomSp.getKapitalZ();
        kapZ.setText(String.valueOf(pom2));
        pom1 = FXMLDocumentController.pomSp.getWolumen();
        wolumen.setText(String.valueOf(pom1));
        pom1 = FXMLDocumentController.pomSp.getObroty();
        obroty.setText(String.valueOf(pom1));
        
    }    
    
}
