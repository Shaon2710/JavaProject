/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sis;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
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
public class FXMLDocument22Controller implements Initializable {
    
    private final String HOSTNAME = "127.0.0.1";
    private final String DBNAME = "studentinfo";
    private final String USERNAME = "root";
    private final String PASSWORD = "farhana";
    private final String DBURL = "jdbc:mysql://" + HOSTNAME + "/" + DBNAME;

    @FXML
    private TextField courseCodeField;
    @FXML
    private TextField courseNameField;
    @FXML
    private TextField courseCreaditField;

  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  

    @FXML
    private void handleCourseResetButtonAction(ActionEvent event) {
        courseCodeField.clear();
        courseNameField.clear();
        courseCreaditField.clear();
                
    }

    @FXML
    private void handleCourseSubmitButtonAction(ActionEvent event) {
        String courseCode = courseCodeField.getText();
        String courseName = courseNameField.getText();
        int credit = Integer.parseInt(courseCreaditField.getText());
        
        
        try {
            Connection connection = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);

            Statement statement = connection.createStatement();

            // insert student information 
            
            String query = "INSERT INTO course VALUES ('" +courseCode+ "', '" + courseName+"',"+credit +");";
            
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
        
        System.out.println(courseCode);
        System.out.println(courseName);
        System.out.println(credit);
        
        courseCodeField.clear();
        courseNameField.clear();
        courseCreaditField.clear();
                
    }

}
