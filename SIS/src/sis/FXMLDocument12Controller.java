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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

/**
 *
 * @author Shazzad
 */
public class FXMLDocument12Controller implements Initializable {
    
    private final String HOSTNAME = "127.0.0.1";
    private final String DBNAME = "studentinfo";
    private final String USERNAME = "root";
    private final String PASSWORD = "farhana";
    private final String DBURL = "jdbc:mysql://" + HOSTNAME + "/" + DBNAME;

    @FXML
    private TextField StudentIdField;
    @FXML
    private TextField editStudentNameField;
    @FXML
    private TextField editStudentEmailField;
    @FXML
    private TextField editStudentAgeField;
    @FXML
    private TextField editStudentDepartmentField;

    String studentID;
    
   
    
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  

    @FXML
    private void handleEditStudentSearchAction(ActionEvent event) {
        
        
         studentID = StudentIdField.getText();
        
        
        try {
            Connection connection = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
            

            Statement statement = connection.createStatement();

            // Search ID form Student Table
            
            String query = "select *from student where studentID='"+studentID+"';";
            
             ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String sID = resultSet.getString("studentID");
                String sAge = resultSet.getString("studentAge");
                String sName = resultSet.getString("studentName");
                String sEmail = resultSet.getString("studentEmail");
                String sDept = resultSet.getString("studentDept");
                
            
            
        editStudentNameField.setText(sName);
        editStudentEmailField.setText(sEmail);
        editStudentAgeField.setText(sAge);
        editStudentDepartmentField.setText(sDept);
            }
            
            
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Something went wrong");
            alert.show();
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException nfe) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "You're supposed to enter numbers in the id fields");
            alert.show();
        }
        
//        if id match in database table then show data in textField
        
        
        StudentIdField.clear();
    }

    @FXML
    private void handleAllClearAction(ActionEvent event) {
        StudentIdField.clear();
        editStudentNameField.clear();
        editStudentEmailField.clear();
        editStudentAgeField.clear();
        editStudentDepartmentField.clear();
    }

    @FXML
    private void handleStudentUpdateAction(ActionEvent event) {
        
        String studentName = editStudentNameField.getText();
        String studentEmail = editStudentEmailField.getText();
        String studentAge = editStudentAgeField.getText();
        String studentDept = editStudentDepartmentField.getText();
        
        
        
        System.out.println(studentName);
        System.out.println(studentEmail);
        System.out.println(studentAge);
        System.out.println(studentDept);
        
        
        try {
            Connection connection = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
            

            Statement statement = connection.createStatement();

            // Student Table data update 
            
            String query = "UPDATE student  SET studentName ='"+studentName+"',studentEmail ='"+studentEmail+"',studentAge ='"+ studentAge+"',studentDept ='"+studentDept+"'WHERE studentID = '" + studentID+"';";
            
           System.out.println(query);
            int row = statement.executeUpdate(query);
            System.out.println("Rows affected " + row);
            
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Something went wrong");
            alert.show();
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException nfe) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "You're supposed to enter numbers in the id fields");
            alert.show();
        }
        
        
        
        StudentIdField.clear();
        editStudentNameField.clear();
        editStudentEmailField.clear();
        editStudentAgeField.clear();
        editStudentDepartmentField.clear();
        
        
    }

    
}
