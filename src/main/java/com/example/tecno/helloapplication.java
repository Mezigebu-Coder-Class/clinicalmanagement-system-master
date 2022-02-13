package com.example.tecno;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class helloapplication extends Application {



    @Override
   public void start(Stage stage) throws IOException {
        DBConnection Connection = new DBConnection();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(helloapplication.class.getResource("Login.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
