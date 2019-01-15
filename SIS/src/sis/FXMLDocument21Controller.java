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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 *
 * @author Shazzad
 */
public class FXMLDocument21Controller implements Initializable {
    
    private final String HOSTNAME = "127.0.0.1";
    private final String DBNAME = "studentinfo";
    private final String USERNAME = "root";
    private final String PASSWORD = "farhana";
    private final String DBURL = "jdbc:mysql://" + HOSTNAME + "/" + DBNAME;

    @FXML
    private TableView<Courses> courseListTableView;
    private ObservableList<Courses>CourseList;
    @FXML
    private TableColumn<Courses, String> courseCodeColumn;
    @FXML
    private TableColumn<Courses, String> couresTitleColumn;
    @FXML
    private TableColumn<Courses, Number> creaditColumn;

    
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CourseList = FXCollections.observableArrayList();
        courseListTableView.setItems(CourseList);
        
         courseCodeColumn
            .setCellValueFactory(
                data -> 
                    new SimpleStringProperty(
                        data.getValue().getCode()));
          couresTitleColumn
            .setCellValueFactory(
                data -> 
                    new SimpleStringProperty(
                        data.getValue().getTitle()));
          
          creaditColumn
            .setCellValueFactory(
                data ->
                    new SimpleIntegerProperty(
                        data.getValue().getCreadit()));
          
   try {
            Connection connection = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
          

            Statement statement = connection.createStatement();

            // show data from course table
            
            String query = "select *from course";
            
           
             ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String course = resultSet.getString("code");
                String title = resultSet.getString("tittle");
                int credit = resultSet.getInt("credit");
                
                Courses t = new Courses(course,title,credit);
                CourseList.add(t);
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
