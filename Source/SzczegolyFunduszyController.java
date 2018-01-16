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
public class SzczegolyFunduszyController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label title = new Label();
    
    @FXML
    private Label imie = new Label();
    
    @FXML
    private Label nazwisko = new Label();
    
    @FXML
    private Label nazwa = new Label();
    
    @FXML
    private Label budzet = new Label();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        imie.setText(FXMLDocumentController.pomF.getImie());
        nazwisko.setText(FXMLDocumentController.pomF.getNazwisko());
        nazwa.setText(FXMLDocumentController.pomF.getNazwa());
        double pom = FXMLDocumentController.pomF.getBudzet();
        budzet.setText(String.valueOf(pom));
    }    
    
}
