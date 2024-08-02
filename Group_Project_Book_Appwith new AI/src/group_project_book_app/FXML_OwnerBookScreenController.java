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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;


/**
 * FXML Controller class
 *
 * @author victorbarnett
 */
public class FXML_OwnerBookScreenController extends FXMLController implements Initializable {
    @FXML
    private TextField book_screen_add_name;
    @FXML
    private TextField book_screen_add_price;
    @FXML
    private Button book_screen_add;
    @FXML
    private Button book_screen_delete;
    @FXML
    private Button book_screen_back;
    @FXML
    private TableView<Book> tableView;
    @FXML
    private TableColumn<Book, String> nameColumn;
    @FXML
    private TableColumn<Book, Float> priceColumn;
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        nameColumn.setCellValueFactory(cvf -> cvf.getValue().nameProperty());
        priceColumn.setCellValueFactory(cvf -> cvf.getValue().priceProperty().asObject());

        //tableView.getColumns().addAll(nameColumn, priceColumn);

        // Assuming data.getOwner().getBooks() returns an ObservableList<Book>
        ObservableList<Book> booksData = data.getOwner().getBooks();

        // Add data to the table
        tableView.setItems(booksData);
        //assert owner_book_table.getItems() == booksData;
         
    }    

    @FXML
    private void bookScreenAddName(ActionEvent event) {
    }

    @FXML
    private void bookScreenAddPrice(ActionEvent event) {
    }

    @FXML
    private void bookScreenAdd(ActionEvent event) {
        try {
            String name = book_screen_add_name.getText();
            float price = Float.parseFloat(book_screen_add_price.getText());
            data.getOwner().addBook(new Book(name, price));
            tableView.refresh();
        }
        catch (Exception e) {
            
        }
    }

    @FXML
    private void bookScreenDelete(ActionEvent event) {
        TableViewSelectionModel tvsm = tableView.getSelectionModel();
        Book selBook = (Book) tvsm.getSelectedItem();
        data.getOwner().deleteBook(selBook);
        tableView.refresh();
    }

    @FXML
    private void bookScreenBack (ActionEvent event) throws Exception {
        main.switchScreen("FXML_OwnerStartScreen.fxml");
    }
    
}
