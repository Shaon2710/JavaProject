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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class FXMLDocument33Controller implements Initializable {
    
    private final String HOSTNAME = "127.0.0.1";
    private final String DBNAME = "studentinfo";
    private final String USERNAME = "root";
    private final String PASSWORD = "farhana";
    private final String DBURL = "jdbc:mysql://" + HOSTNAME + "/" + DBNAME;
    
    
    @FXML
    private TableView<Result> resultTableView;
    private ObservableList<Result> resultList;
    
    @FXML
    private TableColumn<Result, String> resultCourseColumn;
    @FXML
    private TableColumn<Result, String> resultColumn;
    @FXML
    private TableColumn<Result, String> resultSemesterColumn;
    
    @FXML
    private TextField ShowResultStudentidField;
    @FXML
    private TextField showResultSemesterField;

   
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  

    @FXML
    private void handleResultTableClearButtonAction(ActionEvent event) {
        ShowResultStudentidField.clear();
        showResultSemesterField.clear();
    }

    @FXML
    private void handleResultSearchAction(ActionEvent event) {
        
        String studentID = ShowResultStudentidField.getText();
        String semester = showResultSemesterField.getText().toLowerCase();
        

        resultList = FXCollections.observableArrayList();
        resultTableView.setItems(resultList);
        
        resultCourseColumn
            .setCellValueFactory(
                data ->
                    new SimpleStringProperty(
                        data.getValue().getCourse()));
        
        resultColumn
            .setCellValueFactory(
                data ->
                    new SimpleStringProperty(
                        data.getValue().getGpa()));
        
        resultSemesterColumn
            .setCellValueFactory(
                data ->
                    new SimpleStringProperty(
                        data.getValue().getSemester()));
        
        try {
            Connection connection = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
            

            Statement statement = connection.createStatement();

            // result show
            
//            select course, result, semester from result whare studentid = studentID and semester = semester;
            
            String query = "select *from result where studentID = '"+studentID+"' and semester = '"+semester+"'; ";
            System.out.println(query);
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String course = resultSet.getString("course");
                String gpa = resultSet.getString("result");
                String semester1 = resultSet.getString("semester");
                Result t = new Result(studentID, gpa,course, semester1);
                resultList.add(t);
            }
            
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Something went wrong");
            alert.show();
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException nfe) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "You're supposed to enter numbers in the id fields");
            alert.show();
        }
    }
      
}
        
        
        
        
        
        
//        System.out.println(studentName);
//        System.out.println(studentEmail);
//        System.out.println(studentAge);
//        System.out.println(studentDept);
        
        
    
    
    

