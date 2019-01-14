package java1;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

        
public class Gui extends JFrame{
    
    private JTextField item1;
    private JTextField item2;
    private JTextField item3;
    private JPasswordField pf; 
    
    public Gui(){
        
        super("My Page");
        setLayout(new FlowLayout());
        item1 = new JTextField(20);
        add(item1);
        
        item2 = new JTextField("Write hear");
        add(item2);
        
        item3 = new JTextField("dont write hear");
        item3.setEditable(false);
        add(item3);
        
        pf = new JPasswordField("Shaon");
        add(pf);
        
        new2 ob =  new new2();
        
        item1.addActionListener(ob);
        item2.addActionListener(ob);
        item3.addActionListener(ob);
        pf.addActionListener(ob);
               
    }
    
    private class new2 implements ActionListener{
        
        public void actionPerformed(ActionEvent event){
            String string = "";
            
            if(event.getSource()==item1)
                string = String.format("Field 1 : %s", event.getActionCommand());
            
            else if(event.getSource()==item2)
                string = String.format("Field 2 : %s", event.getActionCommand());
            
            else if(event.getSource()==item3)
                string = String.format("Field 3 : %s", event.getActionCommand());
            
            else if(event.getSource()==pf)
                string = String.format("Field Password : %s", event.getActionCommand());
            
            JOptionPane.showMessageDialog(null, string);
            
        }
        
    }
    
}
