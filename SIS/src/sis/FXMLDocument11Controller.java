/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sis;

import java.sql.Statement;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

/**
 *
 * @author Shazzad
 */
public class FXMLDocument11Controller implements Initializable {
    
    private final String HOSTNAME = "127.0.0.1";
    private final String DBNAME = "studentinfo";
    private final String USERNAME = "root";
    private final String PASSWORD = "farhana";
    private final String DBURL = "jdbc:mysql://" + HOSTNAME + "/" + DBNAME;

    @FXML
    private TextField studentNameField;
    @FXML
    private TextField studentEmailField;
    @FXML
    private TextField studentAgeField;
    @FXML
    private TextField studentDepartmentField;
    
    @FXML
    private TextField studentIDField;
  
    
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  

    @FXML
    private void handleStudentResetButtonAction(ActionEvent event) {
        studentNameField.clear();
        studentEmailField.clear();
        
        studentAgeField.clear();
        studentDepartmentField.clear();
        studentIDField.clear();
    }

    @FXML
    private void handleStudentSubmitButtonAction(ActionEvent event) {
        String studentID = studentIDField.getText();
        String studentName = studentNameField.getText();
        String studentEmail = studentEmailField.getText();
        String studentAge = studentAgeField.getText();
        String studentDept = studentDepartmentField.getText();
      
        try {
            Connection connection = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);

            Statement statement = connection.createStatement();

            // insert student information 
            
            String query = "INSERT INTO student VALUES ('" + studentID+ "', '" + studentName+"', '"+ studentAge+"', '"+ studentEmail+"', '" + studentDept+"');";
            
            System.out.println(query);
            int row = statement.executeUpdate(query);
            System.out.println("Rows affected " + row);
            
        } catch (SQLException ex) {
            Alert alert = new Alert(AlertType.ERROR, "Something went wrong");
            alert.show();
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException nfe) {
            Alert alert = new Alert(AlertType.ERROR, "You're supposed to enter numbers in the id fields");
            alert.show();
        }
        
        
        studentNameField.clear();
        studentEmailField.clear();
        studentAgeField.clear();
        studentDepartmentField.clear();
        studentIDField.clear();

    }
        
        
}
        
        
        
        
        
        
//        System.out.println(studentName);
//        System.out.println(studentEmail);
//        System.out.println(studentAge);
//        System.out.println(studentDept);
        
        
    
    
    

