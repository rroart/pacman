package roart.pacman.graphic;

import roart.pacman.game.Colour;

import java.awt.Point;
import java.awt.image.BufferedImage;

import roart.pacman.game.Direction;

public class Pacman extends Moveable {
    private BufferedImage pix0,pixl,pixr,pixu,pixd;	//pixmaps for mouth shut, and mouth
    //open in left right up down direction

    private static Direction.direction look;				//direction to look
    private static boolean mouth;				//mouth open?

    public Pacman() {

	consfn();
	pix0 = pix(Shapes.PACMAN0_BITS,Colour.getPacmancolour(),Colour.getMybackground());
	pixl = pix(Shapes.PACMANLEFT_BITS,Colour.getPacmancolour(),Colour.getMybackground());
	pixr = pix(Shapes.PACMANRIGHT_BITS,Colour.getPacmancolour(),Colour.getMybackground());
	pixu = pix(Shapes.PACMANUP_BITS,Colour.getPacmancolour(),Colour.getMybackground());
	pixd = pix(Shapes.PACMANDOWN_BITS,Colour.getPacmancolour(),Colour.getMybackground());
	setPixmap(pixr); 
	look=Direction.direction.right;
	mouth=true;
    };
 
    public void draw(Point p,Direction.direction d,Direction.direction tryDir) { 
	if (d==Direction.direction.still) {
		mouth=true; 
	}
	//System.out.println("test " + mouth + " " + d);
	if (tryDir!=Direction.direction.still) {
		look=tryDir;
	}
	//if (d==still) mouth=true; else look=d;
	if (mouth) {
	    switch (look) {
	    case up: setPixmap(pixu); break;
	    case down: setPixmap(pixd); break;
	    case left: setPixmap(pixl); break;
	    case right: setPixmap(pixr); break;
	    default: roart.pacman.game.Pacman.pacwarning("Gpac");
	    }
	} else {
		setPixmap(pix0);
	}
	mouth=!mouth;			//if moving, mouth opens/closing alternating
	super.draw(p);
    }

    //returns graphical id according whether mouth is open or which direction
    public    BufferedImage /*GID_TYPE*/ getgid(Direction.direction d,Direction.direction tryDir) {
	BufferedImage pixmap=null;
           
	if (d==Direction.direction.still) {
		mouth=true; 
	}
	if (tryDir!=Direction.direction.still) {
		look=tryDir;
	}
	//if (d==still) mouth=1; else look=d;
	if (mouth) {
	    switch (look) {
	    case up: pixmap=pixu; break;
	    case down: pixmap=pixd; break;
	    case left: pixmap=pixl; break;
	    case right: pixmap=pixr; break;
	    default: roart.pacman.game.Pacman.pacwarning("Gpac");
	    }
	} else {
		pixmap=pix0;
	}
	return pixmap;
    }

}
