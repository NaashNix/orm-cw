package controllers;

import bo.BOFactory;
import bo.custom.RegistrationBO;
import bo.custom.StudentBO;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import view.tdm.ProgramTDM;
import view.tdm.StudentDetails;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class ViewStudentDetailsController {
    public TableView<StudentDetails> tblStudentDetails;
    public TableColumn colStudentId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colNic;
    public TableView<ProgramTDM> tblProgramDetails;
    public TableColumn colProgramID;
    public TableColumn colProgramName;
    public TableColumn colRegisteredDate;
    public TableColumn colProgramDuration;
    private final StudentBO studentBO = (StudentBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.STUDENT);
    private final RegistrationBO registrationBO = (RegistrationBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.REGISTRATION);
    public AnchorPane viewStudentContext;

    public void initialize(){
        colStudentId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colNic.setCellValueFactory(new PropertyValueFactory<>("nic"));

        colProgramID.setCellValueFactory(new PropertyValueFactory<>("programId"));
        colProgramName.setCellValueFactory(new PropertyValueFactory<>("programName"));
        colRegisteredDate.setCellValueFactory(new PropertyValueFactory<>("registeredDate"));
        colProgramDuration.setCellValueFactory(new PropertyValueFactory<>("programDuration"));

        getStudentDetailsList();


        tblStudentDetails.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            StudentDetails selectedItem = tblStudentDetails.getSelectionModel().getSelectedItem();
            System.out.println("SelectedItem : "+selectedItem.getStudentId());
            List<ProgramTDM> programDetails = registrationBO.getProgramDetails(selectedItem.getStudentId());
            System.out.println("table Listner : "+programDetails.get(0).getProgramName());
            System.out.println("Event Fired with value : "+newValue);
            setDataToProgramDetailsTable(programDetails);
        });
    }

    private void setDataToProgramDetailsTable(List<ProgramTDM> programDetails) {
        ObservableList<ProgramTDM> programTDMS = FXCollections.observableArrayList();
        programTDMS.clear();
        programTDMS.addAll(programDetails);
        System.out.println("setDataToProgramDetailsTable : "+programTDMS.get(0).getProgramName());
        tblProgramDetails.refresh();
        tblProgramDetails.setItems(programTDMS);
    }


    public void getStudentDetailsList(){
        List<StudentDetails> studentList = studentBO.getStudentList();
        ObservableList<StudentDetails> tableDataForStudentDetails = FXCollections.observableArrayList();
        tableDataForStudentDetails.addAll(studentList);
        tblStudentDetails.setItems(tableDataForStudentDetails);
    }

    public void backButton(MouseEvent mouseEvent) throws IOException {
        URL resource = getClass().getResource("../view/Dashboard.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) viewStudentContext.getScene().getWindow();
        window.setScene(new Scene(load));
        window.show();
        window.centerOnScreen();
    }
}
