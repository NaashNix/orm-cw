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

<<<<<<< HEAD
    public void initialize(){

    }

=======
>>>>>>> b95a5887ce743d8473be1e362ea764364f8b21b3
    public void navigateToDashboard(MouseEvent mouseEvent) throws IOException {
        URL resource = getClass().getResource("../view/Dashboard.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) addProgramFormContext.getScene().getWindow();
        window.setScene(new Scene(load));
        window.show();
        window.centerOnScreen();
    }
<<<<<<< HEAD


=======
>>>>>>> b95a5887ce743d8473be1e362ea764364f8b21b3
}
