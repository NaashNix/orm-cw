package controllers;

import bo.BOFactory;
import bo.custom.ProgramBO;
import entity.Programs;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;

public class AddProgramsFormController {
    public AnchorPane addProgramFormContext;
    public TextField txtPCode;
    public TextField txtDuration;
    public ComboBox<String> cmbMorY;
    public TextField txtPFee;
    public TextField txtPName;
    public Group codeUsedGrp;
    private final ProgramBO programBO = (ProgramBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.PROGRAM);


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
        String programCode = txtPCode.getText();
        String pName = txtPName.getText();
        String durationType = cmbMorY.getValue();
        int duration = Integer.parseInt(txtDuration.getText());
        BigDecimal pFee = BigDecimal.valueOf(Long.parseLong(txtPFee.getText()));
        Programs programs = new Programs(programCode,pName,duration,durationType,pFee);
        boolean save = programBO.save(programs);
        System.out.println(save);
    }


    public void programCodeValidator(KeyEvent keyEvent) {


    }
}
