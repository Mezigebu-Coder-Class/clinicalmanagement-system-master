package com.example.tecno;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DOCTORController implements Initializable {
    DBConnection dbc = new DBConnection();
    Connection c = dbc.ConnectDb();
    PreparedStatement pst;

    @FXML
    private Button Deletedoctor;

    @FXML
    private Button Viewdoctor;

    @FXML
    private Button addDoctor;

    @FXML
    private TableColumn<DOColumnNames, String> addressCol;

    @FXML
    private TextField addresst;

    @FXML
    private TableColumn<DOColumnNames, Integer> ageCol;

    @FXML
    private TextField aget;

    @FXML
    private TableView<DOColumnNames> doctbl;

    @FXML
    private Label doctor;

    @FXML
    private TableColumn<DOColumnNames, String> genderCol;

    @FXML
    private TextField gendert;

    @FXML
    private TextField id;

    @FXML
    private TableColumn<DOColumnNames, String> idCol;

    @FXML
    private Label idt;

    @FXML
    private TableColumn<DOColumnNames, String> nameCol;

    @FXML
    private TextField namet;

    @FXML
    private TableColumn<DOColumnNames, String> passwordCol;

    @FXML
    private PasswordField passwordt;

    @FXML
    private TableColumn<DOColumnNames, String> phonenoCol;

    @FXML
    private TextField phonenot;

    @FXML
    private TableColumn<DOColumnNames, String> usernameCol;

    @FXML
    private TextField usernamet;

    @FXML
    void Deletedoctor(ActionEvent event ) {
        String  Dpass=idt.getText();

        String sql="DELETE FROM `doctbl` WHERE password='"+Dpass+"'";
        try {
            Connection c=dbc.ConnectDb();
            pst=c.prepareStatement(sql);
            pst.executeUpdate();
            if(pst.execute()){
            JOptionPane.showMessageDialog(null,"Deleted Succsesful");}
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Not Deleted ");
        }
    }



    @FXML
    void addDoctor(ActionEvent event)throws SQLException {
         {
            String query = ("insert into `doctbl`(`id`, `name`, `age`, `gender`, `phoneno`, `address`, `username`, `password`) values(?,?,?,?,?,?,?,?)");
            PreparedStatement pst = c.prepareStatement(query);
            try {
                pst.setString(1, id.getText());
                pst.setString(2, namet.getText());
                pst.setString(3, aget.getText());
                pst.setString(4, gendert.getText());
                pst.setString(5, phonenot.getText());
                pst.setString(6, addresst.getText());
                pst.setString(7, usernamet.getText());
                pst.setString(8, passwordt.getText());
                pst.execute();
                JOptionPane.showMessageDialog(null, "insertion done!!!");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<DOColumnNames>list= FXCollections.observableArrayList();

        DBConnection dbc = new DBConnection();
        Connection c = dbc.ConnectDb();
        ResultSet rs;
        try {

            list = FXCollections.observableArrayList();
            rs = c.createStatement().executeQuery("SELECT * FROM doctbl");

            while (rs.next()) {
                list.add(new DOColumnNames(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)));


            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        idCol.setCellValueFactory(new PropertyValueFactory<DOColumnNames, String>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<DOColumnNames, String>("name"));
        ageCol.setCellValueFactory(new PropertyValueFactory<DOColumnNames, Integer>("age"));
        genderCol.setCellValueFactory(new PropertyValueFactory<DOColumnNames, String>("gender"));
        phonenoCol.setCellValueFactory(new PropertyValueFactory<DOColumnNames, String>("phoneno"));
        addressCol.setCellValueFactory(new PropertyValueFactory<DOColumnNames, String>("address"));
        usernameCol.setCellValueFactory(new PropertyValueFactory<DOColumnNames, String>("username"));
        passwordCol.setCellValueFactory(new PropertyValueFactory<DOColumnNames, String>("password"));

        doctbl.setItems(list);

    }
}
