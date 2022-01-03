package controllers;

import bo.BOFactory;
import bo.custom.ProgramBO;
import bo.custom.StudentBO;
import dto.ProgramDTO;
import dto.StudentRegistration;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class AddNewProgramToExistingStudent {
    public TextField txtName;
    public TextField txtStudentId;
    public ComboBox<String> cmbPrograms;
    public TextField txtProgramCode;
    public TextField txtDuration;
    public Group notFoundError;
    public AnchorPane parentContext;
    public TextField searchText;
    private final ProgramBO programBO = (ProgramBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.PROGRAM);
    private final StudentBO studentBO = (StudentBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.STUDENT);
    List<ProgramDTO> programCodes;

    public void initialize(){
        programCodes = programBO.getProgramDTO();
        for (ProgramDTO program: programCodes
        ) {
            cmbPrograms.getItems().addAll(program.getProgramName());
        }

        cmbPrograms.valueProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("Event Fired");
            int selectedIndex = cmbPrograms.getSelectionModel().getSelectedIndex();
            ProgramDTO selectedProgram = programCodes.get(selectedIndex);
            txtProgramCode.setText(selectedProgram.getProgramId());
            txtDuration.setText(selectedProgram.getDuration()+"  "+selectedProgram.getDuration_type());
        });

    }

    public void navigateToDashboard(MouseEvent mouseEvent) throws IOException {
        URL resource = getClass().getResource("../view/Dashboard.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) parentContext.getScene().getWindow();
        window.setScene(new Scene(load));
        window.show();
        window.centerOnScreen();
    }

    public void searchOnClicked(MouseEvent mouseEvent) {
        StudentRegistration studentDetailsPacket = studentBO.findAndGet(searchText.getText());
        if (studentDetailsPacket == null){
            notFoundError.setVisible(true);
        }else{
            notFoundError.setVisible(false);
            setDataToFields(studentDetailsPacket);
        }
    }

    private void setDataToFields(StudentRegistration studentDetailsPacket) {
        txtName.setText(studentDetailsPacket.getName());
        txtStudentId.setText(studentDetailsPacket.getStudentId());
    }
    
}
