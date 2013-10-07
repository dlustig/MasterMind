
import java.awt.*;
import java.awt.event.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zgoodwyn
 */
public class ActionList implements ActionListener {
    
    public boolean buttonpushed = false;
    public void actionPerformed(ActionEvent e){
        
        buttonpushed = true;
    }
    public void buttonback(){
        
        buttonpushed = false;
    }
    
}
