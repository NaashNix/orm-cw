package controllers;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Dashboard {
    public Label lblTime;
    public AnchorPane dashboardContext;

    public void initialize(){
        liveTime();
    }

    private void liveTime() {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
            lblTime.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }


    public void navigateToAddStudents(MouseEvent mouseEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddStudentForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) dashboardContext.getScene().getWindow();
        window.setScene(new Scene(load));
        window.show();
        window.centerOnScreen();
    }


    public void openSearchStudent(MouseEvent mouseEvent) throws IOException {
        URL resource = getClass().getResource("../view/ViewStudentDetails.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) dashboardContext.getScene().getWindow();
        window.setScene(new Scene(load));
        window.show();
        window.centerOnScreen();
    }

    public void searchStudentCancelButton(MouseEvent mouseEvent) throws IOException {
        URL resource = getClass().getResource("../view/Dashboard.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) dashboardContext.getScene().getWindow();
        window.setScene(new Scene(load));
        window.show();
        window.centerOnScreen();
    }

    public void navigateToAddPrograms(MouseEvent mouseEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddProgramsForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) dashboardContext.getScene().getWindow();
        window.setScene(new Scene(load));
        window.show();
        window.centerOnScreen();
    }
}
