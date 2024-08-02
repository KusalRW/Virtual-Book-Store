package group_project_book_app;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author victorbarnett
 */
public class FXML_OwnerStartScreenController extends FXMLController implements Initializable {
    @FXML
    private Button books_owner_start_screen;
    @FXML
    private Button customers_owner_start_screen;
    @FXML
    private Button logout_owner_start_screen;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void booksOwnerStartScreen(ActionEvent event) throws Exception  {
        main.switchScreen("FXML_OwnerBookScreen.fxml");
    }

    @FXML
    private void customersOwnerStartScreen(ActionEvent event) throws Exception {
        main.switchScreen("FXML_OwnerCustomerScreen.fxml");
    }

    @FXML
    private void logoutOwnerStartScreen(ActionEvent event) throws Exception  {
        main.switchScreen("FXML_LoginScreen.fxml");
    }
    
}
