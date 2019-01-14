/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.time.LocalDate;
import java.util.ArrayList;
  

/**
 *
 * @author SHAON
 */
public class TodoList {

    private LocalDate date;
    private String titel;
    private ArrayList<String> todoItems;
    private ArrayList<String> complitelist;

    private LocalDate newDate;
    private String newTitel;
    private ArrayList<String> newTodoItems;

    public TodoList() {
        todoItems = new ArrayList<>();
        complitelist = new ArrayList<>();
        newTodoItems = new ArrayList<>();
    }

    public TodoList(LocalDate date, String titel) {
        this();
        this.date = date;
        this.titel = titel;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getTitel() {
        return titel;
    }

    public ArrayList<String> getTodoItems() {
        return todoItems;
    }

    public ArrayList<String> getComplitelist() {
        return complitelist;
    }

    @Override
    public String toString() {
        return titel;

    }

    public LocalDate getNewDate() {
        return newDate;
    }

    public String getNewTitel() {
        return newTitel;
    }

    public ArrayList<String> getNewTodoItems() {
        return newTodoItems;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public void setTodoItems(ArrayList<String> todoItems) {
        this.todoItems = todoItems;
    }

    public void setComplitelist(ArrayList<String> complitelist) {
        this.complitelist = complitelist;
    }

    public void setNewDate(LocalDate newDate) {
        this.newDate = newDate;
    }

    public void setNewTitel(String newTitel) {
        this.newTitel = newTitel;
    }

    public void setNewTodoItems(ArrayList<String> newTodoItems) {
        this.newTodoItems = newTodoItems;
    }

}
