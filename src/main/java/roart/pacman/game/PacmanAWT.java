package roart.pacman.game;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

@SuppressWarnings("serial")
public class PacmanAWT extends Applet implements ActionListener {

    public void init(){
	try {
	Runtime.getRuntime().exec("/bin/touch /tmp/h0");
	} catch (Exception e) {
	}
	//System.out.println("hello0");
	setLayout(new GridLayout(Constants.I10,0));

	roart.pacman.game.Pacman.main(null);

    }

    public void actionPerformed(ActionEvent event){
	//System.out.println("hello2");

 

    }

    public void start() {
	try{
	Runtime.getRuntime().exec("/bin/touch /tmp/h2");
	} catch (Exception e) {
	}
	//System.out.println("hello3");
    }

    public void paint(Graphics g) {
	try {
	Runtime.getRuntime().exec("/bin/touch /tmp/h1");
	} catch (Exception e) {
	}
	g.drawString("Hello World!", Constants.I50, Constants.I25);
    }

}

