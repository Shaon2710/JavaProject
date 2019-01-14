/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author SHAON
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private ListView<TodoList> TitelListView;
    private ObservableList<TodoList> titellist;
    

    private ListView<String> InputListView;
    private ObservableList<String> newtodo;

    @FXML
    private Button NewSaveButton;
    @FXML
    private Button ResetButton;
    @FXML
    private ListView<String> TodoListView;
    private ObservableList<String> todolist;
   // private ObservableList<String> eventList = FXCollections.observableArrayList();
    @FXML
    private Button TodoSaveButton;
    @FXML
    private ListView<String> CompliteLIstView;
    private ObservableList<String> complitelist;

    @FXML
    private Button UndoButton;
    @FXML
    private DatePicker newDatePicker;
    private TextField newTitelField;
    @FXML
    private DatePicker todoDatePicker;

    @FXML
    private TextField TodoTitelField;
    @FXML
    private Button DoneButton;
    @FXML
    private Button pushButton;
    @FXML
    private TextField writeTodoField;
    @FXML
    private TextField writeNewTodoField;

    @FXML
    private Button newbutton;

    private TodoList selectedTodo;
    @FXML
    private TextField eventName;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        titellist = FXCollections.observableArrayList();
        todolist = FXCollections.observableArrayList();
        complitelist = FXCollections.observableArrayList();
        newtodo = FXCollections.observableArrayList();

        try {
            RandomAccessFile input = new RandomAccessFile("todoList.txt", "rw");

            while (true) {
                String date = input.readLine();
                if (date == null) {
                    break;
                }
                String titel = input.readLine();

                TodoList t = new TodoList(LocalDate.parse(date), titel);

                String line;
                while ((line = input.readLine()) != null) {

                    if (line.equals("#")) {
                        break;
                    }
                    t.getTodoItems().add(line);
                }
                while ((line = input.readLine()) != null) {

                    if (line.equals("##")) {
                        break;
                    }
                    t.getComplitelist().add(line);
                }
                titellist.add(t);
            }

        } catch (FileNotFoundException fnfe) {
            System.err.println("File not found!");
        } catch (IOException ex) {
            System.err.println("IOE occured");
        }
        TitelListView.setItems(titellist);
        TodoListView.setItems(todolist);
        CompliteLIstView.setItems(complitelist);

    }

    @FXML
    private void HandleSelectTitelIteamAction(MouseEvent event) {
        TodoList text = TitelListView.getSelectionModel().getSelectedItem();
        if (text != null) {
            todoDatePicker.setValue(text.getDate());
            TodoTitelField.setText(text.getTitel());

            todolist.clear();
            todolist.addAll(text.getTodoItems());

            complitelist.clear();
            complitelist.addAll(text.getComplitelist());

            selectedTodo = text;
        }

    }

    @FXML
    private void HandleResetButtonAction(ActionEvent event) {
        clearFields();

    }

    private void clearFields() {
        newDatePicker.setValue(null);
        todoDatePicker.setValue(null);
        newTitelField.clear();
        newtodo.clear();
        TodoTitelField.clear();
        TodoListView.getSelectionModel().getSelectedItems().removeAll();
        CompliteLIstView.getSelectionModel().getSelectedItems().removeAll();

    }

    @FXML
    private void HandlePushButtonAction(ActionEvent event) {
        String addnewtodo = writeNewTodoField.getText();

        newtodo.add(addnewtodo);
        InputListView.setItems(newtodo);
        writeNewTodoField.clear();

    }

    @FXML
    private void HandleNewSaveButtonAction(ActionEvent event) {
        LocalDate date = newDatePicker.getValue();
        String newtitel = newTitelField.getText();
        ArrayList<String> newlist;
        if (selectedTodo != null) {

            selectedTodo.setNewDate(date);
            selectedTodo.setNewTitel(newtitel);

            try {
                RandomAccessFile output = new RandomAccessFile("todoList.txt", "rw");
//                output.setLength(0);
                for (int i = 0; i < titellist.size(); i++) {
                    TodoList td = titellist.get(i);
                    output.writeBytes(td.getNewDate() + "\n");
                    output.writeBytes(td.getNewTitel() + "\n");
                }

            } catch (FileNotFoundException fnfe) {
                System.err.println("File not found!");
            } catch (IOException ex) {
                System.err.println("IOE occured");
            }

        }
    }

    @FXML
    private void HandleTodoSaveButtonAction(ActionEvent event) {
        String addTodo = writeTodoField.getText();
        todolist.add(addTodo);
        TodoListView.setItems(todolist);
//        writeTodoField.clear();

    }

    @FXML
    private void HandleDoneButtonAction(ActionEvent event) {

    }

    @FXML
    private void HandleUndoButtonAction(ActionEvent event) {
    }

    @FXML
    private void HandleNewButtonAction(ActionEvent event) {
        TodoList todo = new TodoList();
        titellist.add(todo);
        selectedTodo = todo;
        TitelListView.getSelectionModel().select(todo);
        clearFields();

    }


    @FXML
    private void HandleSelectTodoIteamAction(MouseEvent event) {
         if (!todolist.isEmpty()) {
            String todoString = TodoListView.getSelectionModel().getSelectedItem();
            if (todoString != null) {
                todolist.remove(todoString);
                complitelist.add(todoString);
                TodoListView.getSelectionModel().clearSelection();
            }
        }
    }

    @FXML
    private void HandleSelectCompliteIteamAction(MouseEvent event) {
            if (!complitelist.isEmpty()) {
            String todoString = CompliteLIstView.getSelectionModel().getSelectedItem();
            if(todoString != null){
               complitelist.remove(todoString);
               todolist.add(todoString);
               CompliteLIstView.getSelectionModel().clearSelection();
            }
        }
    }
  
    

    @FXML
    private void addEventHandle(ActionEvent event) {
    }
}

