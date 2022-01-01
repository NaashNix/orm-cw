package controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class AddProgramsFormController {
    public AnchorPane addProgramFormContext;
    public TextField txtPCode;
    public TextField txtDuration;
    public ComboBox<String> cmbMorY;
    public TextField txtPFee;
    public TextField txtPName;


    public void initialize(){
        cmbMorY.getItems().setAll("Months","Years");
        cmbMorY.getSelectionModel().clearAndSelect(0);

    }

    public void navigateToDashboard(MouseEvent mouseEvent) throws IOException {
        URL resource = getClass().getResource("../view/Dashboard.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) addProgramFormContext.getScene().getWindow();
        window.setScene(new Scene(load));
        window.show();
        window.centerOnScreen();
    }

    public void proceedButtonClicked(MouseEvent mouseEvent) {
        
    }
}
