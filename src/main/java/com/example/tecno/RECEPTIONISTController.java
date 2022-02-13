package com.example.tecno;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class RECEPTIONISTController implements Initializable {
        DBConnection dbc = new DBConnection();
        Connection c = dbc.ConnectDb();
        PreparedStatement pst;
        @FXML
        private TableColumn<REColumnNames, String > Phoneno;

        @FXML
        private Button addRecpetionst;

        @FXML
        private TableColumn<REColumnNames, String> password;
        @FXML
        private TableColumn<REColumnNames, String> address;

        @FXML
        private TextField addresst;

        @FXML
        private TableColumn<REColumnNames, String> age;

        @FXML
        private TextField aget;

        @FXML
        private TableColumn<REColumnNames, String > date;

        @FXML
        private TextField datet;

        @FXML
        private Button deleterecpetionst;

        @FXML
        private TableColumn<REColumnNames, String> gender;

        @FXML
        private TextField gendert;

        @FXML
        private TableColumn<REColumnNames, String> id;

        @FXML
        private TextField idt;

        @FXML
        private TableColumn<REColumnNames, String> name;

        @FXML
        private TextField namet;

        @FXML
        private PasswordField passwordt;

        @FXML
        private TextField phonenot;

        @FXML
        private Label recpetionst;

        @FXML
        private TableView<REColumnNames> reptbl;

        @FXML
        private TableColumn<REColumnNames, String> username;

        @FXML
        private TextField usernamet;

        @FXML
        private Button viewRecpetionst;

        @FXML
        void addRecpetionst(ActionEvent event) throws SQLException {

                String query =("insert into `rectbl`(`date`, `id`, `name`, `age`, `gender`, `phoneno`, `address`, `username`, `password`) values(?,?,?,?,?,?,?,?,?)");
                PreparedStatement pst = c.prepareStatement(query);
                try {
                        pst.setString(1, datet.getText());
                        pst.setString(2, idt.getText());
                        pst.setString(3, namet.getText());
                        pst.setString(4, aget.getText());
                        pst.setString(5, gendert.getText());
                        pst.setString(6, phonenot.getText());
                        pst.setString(7, addresst.getText());
                        pst.setString(8, usernamet.getText());
                        pst.setString(9, passwordt.getText());

                        pst.execute();
                        JOptionPane.showMessageDialog(null, "insertion done!!!");

                } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("e");
                }
        }

        @FXML
        void deleterecpetionst(ActionEvent event) {
          String  deleteid=idt.getText();
        String sql="DELETE FROM `rectbl` where id='"+deleteid+"'";
        try {
                Connection c=dbc.ConnectDb();
               pst=c.prepareStatement(sql);
               pst.executeUpdate();
               JOptionPane.showMessageDialog(null,"Deleted Succsesful");
        } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,"Not Deleted ");
        }
        }


        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
                ObservableList<REColumnNames>list= FXCollections.observableArrayList();
                list = FXCollections.observableArrayList();

                DBConnection dbc = new DBConnection();
                Connection c = dbc.ConnectDb();
                ResultSet rs;
                try {

                        list = FXCollections.observableArrayList();
                        rs = c.createStatement().executeQuery("SELECT * FROM rectbl");

                        while (rs.next()) {
                                list.add(new REColumnNames(
                                        rs.getString(1),
                                        rs.getString(2),
                                        rs.getString(3),
                                        rs.getString(4),
                                        rs.getString(5),
                                        rs.getString(6),
                                        rs.getString(7),
                                        rs.getString(8),
                                        rs.getString(9)
                                ));

                        };

                } catch (SQLException e) {

                        e.printStackTrace();
                }

                date.setCellValueFactory(new PropertyValueFactory<REColumnNames,String >("date"));
                id.setCellValueFactory( new PropertyValueFactory<REColumnNames, String>("id"));
                name.setCellValueFactory( new PropertyValueFactory<REColumnNames,String>("name"));
                age.setCellValueFactory(  new PropertyValueFactory<REColumnNames, String >("age"));
                gender.setCellValueFactory(new PropertyValueFactory<REColumnNames, String>("gender"));
                Phoneno.setCellValueFactory(new PropertyValueFactory<REColumnNames, String >("Phoneno"));
                address.setCellValueFactory(new PropertyValueFactory<REColumnNames, String>("address"));
                username.setCellValueFactory(new PropertyValueFactory<REColumnNames, String>("username"));
                password.setCellValueFactory(new PropertyValueFactory<REColumnNames, String>("password"));


                reptbl.setItems(list);
        }

}


