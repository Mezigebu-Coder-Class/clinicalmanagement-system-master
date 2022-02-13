package com.example.tecno;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;


public class PATIENTControllers implements Initializable {
        DBConnection dbc = new DBConnection();
        Connection c = dbc.ConnectDb();
        PreparedStatement pst;
        @FXML
        private Button Addpatient;

        @FXML
        private Button Deletepatient;

        @FXML
        private Button PATIENT;

        @FXML
        private TableColumn<PAColumnNames, Integer> ageCol;

        @FXML
        private TextField aget;


        @FXML
        private TableColumn<PAColumnNames, String> genderCol;

        @FXML
        private TextField gendert;

        @FXML
        private TableColumn<PAColumnNames, String> idCol;

        @FXML
        private TextField idt;

        @FXML
        private TableColumn<PAColumnNames, String> nameCol;

        @FXML
        private TextField namet;

        @FXML
        private TableView<PAColumnNames> patbl;

        @FXML
        private TableColumn<PAColumnNames, String> roomnoCol;

        @FXML
        private TextField roomnot;

        @FXML
        private Button viewpatient;


        @FXML
        void Deletepatient(ActionEvent event) {
                String  delid=idt.getText();
                String sql="DELETE FROM `patbl` where id='"+delid+"'";
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



        @FXML
        void Addpatient(ActionEvent event) throws SQLException {

                String query =("insert into `patbl`( `id`, `name`, `age`, `gender`, `roomno`) values(?,?,?,?,?)");
                PreparedStatement pst = c.prepareStatement(query);
                try {
                        pst.setString(1, idt.getText());
                        pst.setString(2, namet.getText());
                        pst.setString(3, aget.getText());
                        pst.setString(4, gendert.getText());
                        pst.setString(5, roomnot.getText());

                        pst.execute();
                        JOptionPane.showMessageDialog(null, "insertion done!!!");

                } catch (Exception e) {
                        e.printStackTrace();

                }
        }

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
                ObservableList<PAColumnNames>list= FXCollections.observableArrayList();
                list = FXCollections.observableArrayList();

                DBConnection dbc = new DBConnection();
                Connection c = dbc.ConnectDb();
                ResultSet rs;
                try {

                        list = FXCollections.observableArrayList();
                        rs = c.createStatement().executeQuery("SELECT * FROM `patbl`");

                        while (rs.next()) {
                                list.add(new PAColumnNames(
                                        rs.getString("id"),
                                        rs.getString("name"),
                                        rs.getString("age"),
                                        rs.getString("gender"),
                                        rs.getString("roomno")));


                        }

                } catch (SQLException e) {

                        e.printStackTrace();
                }


                idCol.setCellValueFactory(new PropertyValueFactory<PAColumnNames, String>("id"));
                nameCol.setCellValueFactory(new PropertyValueFactory<PAColumnNames, String>("name"));
                ageCol.setCellValueFactory(new PropertyValueFactory<PAColumnNames, Integer>("age"));
                genderCol.setCellValueFactory(new PropertyValueFactory<PAColumnNames, String>("gender"));
                roomnoCol.setCellValueFactory(new PropertyValueFactory<PAColumnNames, String>("roomno"));

                patbl.setItems(list);
        }
        void viewpatient(ActionEvent event) {

        }
}
