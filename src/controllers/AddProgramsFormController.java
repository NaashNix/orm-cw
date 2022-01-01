package controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class AddProgramsFormController {
    public AnchorPane addProgramFormContext;

    public void initialize(){

    }

    public void navigateToDashboard(MouseEvent mouseEvent) throws IOException {
        URL resource = getClass().getResource("../view/Dashboard.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) addProgramFormContext.getScene().getWindow();
        window.setScene(new Scene(load));
        window.show();
        window.centerOnScreen();
    }


}
