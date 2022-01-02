package controllers;

import bo.BOFactory;
import bo.custom.StudentBO;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import view.tdm.StudentDetails;

import java.util.List;

public class ViewStudentDetailsController {
    public TableView<StudentDetails> tblStudentDetails;
    public TableColumn colStudentId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colNic;
    public TableView tblProgramDetails;
    public TableColumn colProgramID;
    public TableColumn colProgramName;
    public TableColumn colRegisteredDate;
    public TableColumn colProgramDuration;
    private final StudentBO studentBO = (StudentBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.STUDENT);

    public void initialize(){
        colStudentId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colNic.setCellValueFactory(new PropertyValueFactory<>("nic"));

        getStudentDetailsList();


        tblStudentDetails.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            StudentDetails selectedItem = tblStudentDetails.getSelectionModel().getSelectedItem();

        });
    }



    public void getStudentDetailsList(){
        List<StudentDetails> studentList = studentBO.getStudentList();
        ObservableList<StudentDetails> tableDataForStudentDetails = FXCollections.observableArrayList();
        tableDataForStudentDetails.addAll(studentList);
        tblStudentDetails.setItems(tableDataForStudentDetails);
    }
}
