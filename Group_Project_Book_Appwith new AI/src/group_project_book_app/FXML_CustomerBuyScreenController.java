/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package group_project_book_app;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author victorbarnett
 */
public class FXML_CustomerBuyScreenController extends FXMLController implements Initializable {
    private Customer cust;
    @FXML
    private Text customer_buy_tc;
    @FXML
    private Text customer_buy_status;
    @FXML
    private Button customer_buy_logout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cust = data.getOwner().getCurrCustomer();
        String tc = "Total Cost: " + data.getCurrent_cost();
        String status = "Points: " + cust.getPoints() + ", Status: ";
        if (cust.getPoints() >= 1000) {
            status += "Gold.";
        }
        else {
            status += "Silver.";
        }
        customer_buy_tc.setText(tc);
        customer_buy_status.setText(status);
    }    

    @FXML
    private void customerBuyLogout(ActionEvent event) throws Exception {
        main.switchScreen("FXML_LoginScreen.fxml");
    }
    
}
