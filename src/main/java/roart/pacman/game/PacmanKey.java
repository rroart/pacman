package roart.pacman.game;

import java.awt.event.*;
import java.awt.*;

@SuppressWarnings("serial")
public class PacmanKey extends Frame
    implements KeyListener/*,
			    ActionListener*/
{
        public void keyTyped(KeyEvent e) {
	//System.out.println("e3");
	    //displayInfo(e, "KEY TYPED: ");
     }
    
    /** Handle the key pressed event from the text field. */
    public void keyPressed(KeyEvent e) {
	//System.out.println("e");
	//        displayInfo(e, "KEY PRESSED: ");
    }
    
    /** Handle the key released event from the text field. */
     public void keyReleased(KeyEvent e) {
	//System.out.println("e2");
    //    displayInfo(e, "KEY RELEASED: ");
     }


}
