package controllers;

import bo.BOFactory;
import bo.custom.ProgramBO;
import bo.custom.StudentBO;
import com.jfoenix.controls.JFXCheckBox;
import dto.ProgramDTO;
import dto.RegistrationDTO;
import dto.StudentRegistration;
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
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class AddStudentFormController {

    public AnchorPane addStudentFormContext;
    public TextField txtName;
    public TextField txtAddress;
    public ComboBox<String> cmbSelectedProgram;
    public TextField txtNic;
    public DatePicker pickerBirthday;
    private final ProgramBO programBO = (ProgramBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.PROGRAM);
    private final StudentBO studentBO = (StudentBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.STUDENT);
    public JFXCheckBox tickDone;
    public JFXCheckBox tickNotPaid;
    private List<ProgramDTO> programCodes;

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
        programCodes = programBO.getProgramCodes();
        for (ProgramDTO program: programCodes
             ) {
            cmbSelectedProgram.getItems().addAll(program.getProgramName());
        }
        if (programCodes.get(0) != null){
            cmbSelectedProgram.getSelectionModel().clearAndSelect(0);
        }
    }


    public void proceedMouseClicked(MouseEvent mouseEvent) {
        String name = txtName.getText();
        String address = txtAddress.getText();
        String nic = txtNic.getText();
        LocalDate birthday = pickerBirthday.getValue();
        System.out.println("Birthday : "+birthday);
        int selectedIndex = cmbSelectedProgram.getSelectionModel().getSelectedIndex();
        ProgramDTO selectedProgram = programCodes.get(selectedIndex);
        StudentRegistration studentRegistration = new StudentRegistration(nic,name,nic,address,birthday);
        RegistrationDTO registrationDTO = new RegistrationDTO
                (nic+selectedProgram.getProgramId(),LocalDate.now(),
                        selectedProgram,studentRegistration);
        studentBO.save(registrationDTO);

    }

    public void navigateToAddExisting(MouseEvent mouseEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddNewProgram.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) addStudentFormContext.getScene().getWindow();
        window.setScene(new Scene(load));
        window.show();
        window.centerOnScreen();
    }
}
