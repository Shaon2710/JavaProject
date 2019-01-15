/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sis;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 *
 * @author Shazzad
 */
public class FXMLDocument13Controller implements Initializable {
    
    private final String HOSTNAME = "127.0.0.1";
    private final String DBNAME = "studentinfo";
    private final String USERNAME = "root";
    private final String PASSWORD = "farhana";
    private final String DBURL = "jdbc:mysql://" + HOSTNAME + "/" + DBNAME;


    @FXML
    private TableView<Student> StudentShowTableView;
    private ObservableList<Student> StudentList;
    
    @FXML
    private TableColumn<Student, String> studentIDColumn;
    @FXML
    private TableColumn<Student, String> studentNameColumn;
    @FXML
    private TableColumn<Student, String> studentEmailColumn;
    @FXML
    private TableColumn<Student,String> studentAgeColumn;
    @FXML
    private TableColumn<Student, String> studentDeptColumn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        StudentList = FXCollections.observableArrayList();
        StudentShowTableView.setItems(StudentList);
        
        
        studentIDColumn
            .setCellValueFactory(
                data -> 
                    new SimpleStringProperty(
                        data.getValue().getId()));
        
        studentNameColumn
            .setCellValueFactory(
                data -> 
                    new SimpleStringProperty(
                        data.getValue().getName()));
        
        studentEmailColumn
            .setCellValueFactory(
                data -> 
                    new SimpleStringProperty(
                        data.getValue().getEmail()));
        
        
        studentAgeColumn
            .setCellValueFactory(
                data -> 
                    new SimpleStringProperty(
                        data.getValue().getAge()));
        
        
        studentDeptColumn
            .setCellValueFactory(
                data -> 
                    new SimpleStringProperty(
                        data.getValue().getDept()));
        
        try {
            Connection connection = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
            

            Statement statement = connection.createStatement();

            String query = "select *from student;";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String sID = resultSet.getString("studentID");
                String sAge = resultSet.getString("studentAge");
                String sName = resultSet.getString("studentName");
                String sEmail = resultSet.getString("studentEmail");
                String sDept = resultSet.getString("studentDept");
                Student t = new Student(sID, sName, sAge, sEmail,sDept);
                StudentList.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }
}
