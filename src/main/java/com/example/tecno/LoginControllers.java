package com.example.tecno;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginControllers  {
DBConnection db = new DBConnection();
        @FXML
        private Label Password;

        @FXML
        private Label Username;

        @FXML
        private TextField Usernametxtf;

        @FXML
        private Button login_btn;

        @FXML
        private Label ADMINPAGE;
        @FXML
        private PasswordField pass_txt;


        Connection conn=null;
        ResultSet rs=null;
    PreparedStatement pst=null;
        @FXML

        void Login(ActionEvent event) throws IOException {
            if(Usernametxtf.getText().equals("")||pass_txt.getText().equals("")){
                JOptionPane.showMessageDialog(null,"please fill requirments");
            }

               String sql="select * from logtbl where username=? and password=?";

               try{
                   conn = db.ConnectDb();
                   pst =conn.prepareStatement(sql);
                    pst.setString(1,Usernametxtf.getText());
                   pst.setString(2,pass_txt.getText());
                   rs=pst.executeQuery();
                   while (rs.next()){
                       FXMLLoader fxmlLoader = new FXMLLoader(helloapplication.class.getResource("hom.fxml"));
                  Scene scene = new Scene(fxmlLoader.load(),800,500);
                  Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                  stage.setScene(scene);
                  stage.show();
                   }

               }catch (Exception e){

                       e.printStackTrace();

               }

        }
    }


