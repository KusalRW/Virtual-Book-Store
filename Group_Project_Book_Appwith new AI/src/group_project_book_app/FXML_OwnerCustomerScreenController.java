/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package group_project_book_app;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * FXML Controller class
 *
 * @author victorbarnett
 */
public class FXML_OwnerCustomerScreenController extends FXMLController implements Initializable {
    @FXML
    private TableView<Customer> tableView;
    @FXML
    private TextField owner_customer_add_username;
    @FXML
    private TextField owner_customer_add_password;
    @FXML
    private Button owner_customer_add;
    @FXML
    private Button owner_customer_delete;
    @FXML
    private Button owner_customer_back;
    @FXML
    private TableColumn<Customer, String> usernameCol;
    @FXML
    private TableColumn<Customer, String> passwordCol;
    @FXML
    private TableColumn<Customer, Float> pointsCol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        usernameCol.setCellValueFactory(cvf -> new SimpleStringProperty(cvf.getValue().getUsername()));
        passwordCol.setCellValueFactory(cvf -> new SimpleStringProperty(cvf.getValue().getPassword()));
        pointsCol.setCellValueFactory(cvf -> new SimpleFloatProperty(cvf.getValue().getPoints()).asObject());
        
        ObservableList<Customer> customersData = data.getOwner().getCustomers();

        // Add data to the table
        tableView.setItems(customersData);
    }    

    @FXML
    private void ownerCustomerAddUsername(ActionEvent event) {
    }

    @FXML
    private void ownerCustomerAddPassword(ActionEvent event) {
    }

    @FXML
    private void ownerAddCustomer(ActionEvent event) {
        String username = owner_customer_add_username.getText();
        String password = owner_customer_add_password.getText();
        data.getOwner().addCustomer(new Customer(username, password, 0));
        tableView.refresh();
    }

    @FXML
    private void ownerDeleteCustomer(ActionEvent event) {
        TableViewSelectionModel tvsm = tableView.getSelectionModel();
        Customer selCust = (Customer) tvsm.getSelectedItem();
        data.getOwner().deleteCustomer(selCust);
        tableView.refresh();
    }

    @FXML
    private void ownerCustomerBack(ActionEvent event) throws Exception {
        main.switchScreen("FXML_OwnerStartScreen.fxml");
    }
    
}
