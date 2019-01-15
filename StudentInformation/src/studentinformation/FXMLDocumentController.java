/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentinformation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author Shazzad
 */
public class FXMLDocumentController implements Initializable {
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void handleStudentShowAction(ActionEvent event) throws IOException {
        
        String fileName = "StudentTable.fxml";
        PopUp(fileName);
      
    }

    @FXML
    private void handleStudentAddAction(ActionEvent event) throws IOException {
        
        String fileName = "StudentInput.fxml";
        PopUp(fileName);
//        
    }

    @FXML
    private void handleStudentEditAction(ActionEvent event) throws IOException {
        
        String fileName = "StudentEdit.fxml";
        PopUp(fileName);
    }

    @FXML
    private void handleCourseShowAction(ActionEvent event) throws IOException {
        
        String fileName = "CoursesShow.fxml";
        PopUp(fileName);
        
    }

    @FXML
    private void handleCourseAddAction(ActionEvent event) throws IOException{
        
        String fileName = "CoursesInput.fxml";
        PopUp(fileName);
        
    }

    @FXML
    private void handleViewResultAction(ActionEvent event) throws IOException {
        
        String fileName = "resultTable.fxml";
        PopUp(fileName);
        
    }
    
    private void PopUp(String name) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(name));
           Parent root1 = (Parent) fxmlLoader.load();
           Stage stage = new Stage();
           stage.setScene(new Scene(root1));  
           stage.show();
    }
}
