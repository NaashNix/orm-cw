package controllers;

import bo.BOFactory;
import bo.custom.ProgramBO;
import com.jfoenix.controls.JFXCheckBox;
import dto.ProgramDTO;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class AddStudentFormController {

    public AnchorPane addStudentFormContext;
    public TextField txtName;
    public TextField txtAddress;
    public ComboBox<String> cmbSelectedProgram;
    public TextField txtNic;
    public DatePicker pickerBirthday;
    private final ProgramBO programBO = (ProgramBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.PROGRAM);
    public JFXCheckBox tickDone;
    public JFXCheckBox tickNotPaid;

    public void navigateToDashboard(MouseEvent mouseEvent) throws IOException {
        URL resource = getClass().getResource("../view/Dashboard.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) addStudentFormContext.getScene().getWindow();
        window.setScene(new Scene(load));
        window.show();
        window.centerOnScreen();
    }

    public void initialize(){
        getAllPrograms();
    }

    private void getAllPrograms() {
        List<ProgramDTO> programCodes = programBO.getProgramCodes();
        for (ProgramDTO program: programCodes
             ) {
            cmbSelectedProgram.getItems().addAll(program.getProgramName());
        }
        if (programCodes.get(0) != null){
            cmbSelectedProgram.getSelectionModel().clearAndSelect(0);
        }
    }


    public void proceedMouseClicked(MouseEvent mouseEvent) {

    }
}
