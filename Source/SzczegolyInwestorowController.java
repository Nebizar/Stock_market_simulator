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
public class SzczegolyInwestorowController implements Initializable {

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
    private Label pesel = new Label();
    
    @FXML
    private Label budzet = new Label();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        imie.setText(FXMLDocumentController.pomI.getImie());
        nazwisko.setText(FXMLDocumentController.pomI.getNazwisko());
        pesel.setText(FXMLDocumentController.pomI.getPesel());
        double pom = FXMLDocumentController.pomI.getBudzet();
        budzet.setText(String.valueOf(pom));
    }    
    
}
