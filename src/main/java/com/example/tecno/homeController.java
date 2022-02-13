package com.example.tecno;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class homeController {

    @FXML
    private Button DOCTOR;

    @FXML
    private Button PATIENT;

    @FXML
    private Button RECEPTIONIST;

    @FXML
    void DOCTOR(ActionEvent  event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(helloapplication.class.getResource("Doctor.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),800,500);
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void PATIENT(ActionEvent  event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(helloapplication.class.getResource("patient.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),800,500);
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void RECEPTIONIST(ActionEvent  event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(helloapplication.class.getResource("receptionsit.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),800,500);
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}
