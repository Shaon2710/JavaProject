package java1;

import java.util.Scanner;
import javax.swing.JFrame;


public class Java1 {


    public static void main(String[] args) {
     
          Gui name = new Gui();
          Scanner input = new Scanner(System.in);
        
        name.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        name.setSize(350,250);
        name.setVisible(true);
        
    }
    
}
