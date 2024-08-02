package group_project_book_app;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 *
 * @author victorbarnett
 */
public class BookAppFXMain extends Application {
    //private StackPane stackPane = new StackPane();
    private Stage primaryStage;
    private Parent pane;
    protected AppWideData data = AppWideData.getInstance();
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        System.out.println("Starting app");
        data.readCurrentData();
        switchScreen("FXML_LoginScreen.fxml");
        primaryStage.setOnCloseRequest(e -> {
            // Perform actions before the application is closed
            data.writeCurrentData();
        });
    }
    public void switchScreen(String fxmlFile) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        pane = loader.load();
        FXMLController controller = loader.getController();
        controller.setMain(this);
        Scene scene = new Scene( pane );
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
