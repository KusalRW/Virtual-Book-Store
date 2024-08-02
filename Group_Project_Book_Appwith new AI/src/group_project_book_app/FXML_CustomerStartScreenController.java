/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package group_project_book_app;

import javafx.scene.control.CheckBox;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import java.util.Iterator;

/**
 * FXML Controller class
 *
 * @author victorbarnett
 */
public class FXML_CustomerStartScreenController extends FXMLController implements Initializable {
    private Customer cust;
    @FXML
    private Text customer_intro_text;
    @FXML
    private TableView<Book> tableView;
    @FXML
    private TableColumn<Book, String> nameCol;
    @FXML
    private TableColumn<Book, Float> priceCol;
    @FXML
    private TableColumn<Book, CheckBox> selectCol;
    @FXML
    private Button customer_buy_book;
    @FXML
    private Button customer_redeem_buy;
    @FXML
    private Button customer_logout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cust = data.getOwner().getCurrCustomer();
        String intro = "Welcome " + cust.getUsername() + ". You have " + cust.getPoints()
                        + " points. Your status is ";
        if (cust.getPoints() >= 1000) {
            intro += "Gold.";
        }
        else {
            intro += "Silver.";
        }
        customer_intro_text.setText(intro);
        
        nameCol.setCellValueFactory(cvf -> cvf.getValue().nameProperty());
        priceCol.setCellValueFactory(cvf -> cvf.getValue().priceProperty().asObject());
        selectCol.setCellValueFactory(new PropertyValueFactory<>("selected"));
        //selectCol.setCellFactory(column -> new CheckBoxTableCell<>());
        
        tableView.getColumns().add(selectCol);
        ObservableList<Book> booksData = data.getOwner().getBooks();

        // Add data to the table
        tableView.setItems(booksData);
    }    

    @FXML
    private void customerBuyBook(ActionEvent event) throws Exception {
        Iterator<Book> itr = data.getOwner().getBooks().iterator();
        float cost = 0;
        while (itr.hasNext()) {
            Book b = itr.next();
            if (b.getSelected().isSelected()) {
                cost += b.getPrice();
                itr.remove();
            }
        }
        data.setCurrent_cost(cost);
        cust.setPoints(cust.getPoints() + cost*10);
        main.switchScreen("FXML_CustomerBuyScreen.fxml");
    }

    @FXML
    private void customerRedeemBuy(ActionEvent event) throws Exception{
        Iterator<Book> itr = data.getOwner().getBooks().iterator();
        float cost = 0;
        while (itr.hasNext()) {
            Book b = itr.next();
            if (b.getSelected().isSelected()) {
                cost += b.getPrice();
                itr.remove();
            }
        }
        float pointsUsed = 0;
        float totalPoints = cust.getPoints();
        if (totalPoints >= cost*100) {
            pointsUsed = cost*100;
            cost = 0;
        }
        else {
            pointsUsed = totalPoints;
            cost -= totalPoints/100;
        }
        data.setCurrent_cost(cost);
        cust.setPoints(cust.getPoints() - pointsUsed + cost*10);
        main.switchScreen("FXML_CustomerBuyScreen.fxml");
    }

    @FXML
    private void customerLogout(ActionEvent event) throws Exception {
        main.switchScreen("FXML_LoginScreen.fxml");
    }
    
}
