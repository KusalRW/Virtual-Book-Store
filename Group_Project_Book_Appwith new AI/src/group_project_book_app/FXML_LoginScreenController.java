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
import javafx.scene.control.TextField;
import javafx.scene.text.Text;



import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author victorbarnett
 */
public class FXML_LoginScreenController extends FXMLController implements Initializable {
    @FXML
    private TextField username_login;
    @FXML
    private TextField password_login;
    @FXML
    private Button login_button;
    @FXML
    private Text login_display;

    /**
     * Initializes the controller class.
     */
   /* @FXML
    ImageView myImageView; */
    @FXML
    Button myButton;
    
    private Image myImage = new Image(getClass().getResourceAsStream("Books.jpeg"));
    ImageView myImageView = new ImageView(myImage);
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //System.out.println("Login controller initialized");
        myImageView.setImage(myImage);
        
    }    
    
    
 

    @FXML
    private void usernameLogin(ActionEvent event) {
    }

    @FXML
    private void passwordLogin(ActionEvent event) {
    }

    @FXML
    private void loginButton(ActionEvent event) throws Exception {
        String username = username_login.getText();
        String password = password_login.getText();
        if (username.equals(data.getOwner_username()) && password.equals(data.getOwner_password())) {
            main.switchScreen("FXML_OwnerStartScreen.fxml");
            
            return;
        }
        else {
            for (Customer c : data.getOwner().getCustomers()) {
                if (username.equals(c.getUsername()) && password.equals(c.getPassword())) {
                    data.getOwner().setCurrCustomer(c);
                    main.switchScreen("FXML_CustomerStartScreen.fxml");
                    return;
                }
            }
        }
        login_display.setText("Invalid username/password combination");
    }
    
}
