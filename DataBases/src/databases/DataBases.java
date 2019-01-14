/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databases;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SHAON
 */
public class DataBases {

    private final String HOSTNAME = "localhost";
    private final String DBNAME = "dummybd";
    private final String USERNAME = "shaon2710";
    private final String PASSWORD = "shaon2710";
    private final String DBURL = "jdbc:mysql://" + HOSTNAME + "/" + DBNAME;
    
    public DataBases() {
        try {
            Connection  connection =  DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
            System.out.println("Connection okk");
        } catch (SQLException ex) {
            Logger.getLogger(DataBases.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       new DataBases();
    }
    
}
