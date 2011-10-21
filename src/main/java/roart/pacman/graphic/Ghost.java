package roart.pacman.graphic;

import java.awt.*;
import java.awt.image.*;
import roart.pacman.game.Colour;

public class Ghost extends Moveable {

    private BufferedImage pixmapn,pixmapr;	//pixmaps for normal and running colours
          
    public Ghost(Colour colour) {
	consfn();
	pixmapn = pix(Shapes.GHOST_BITS,colour,Colour.getMybackground());
	pixmapr = pix(Shapes.GHOST_BITS,Colour.getRunghostcolour(),Colour.getMybackground());
	setPixmap(pixmapn);
    };
    
    public void draw(Point p,boolean run) {//draw at x,y with running boolean
	if (!run) {
	    setPixmap(pixmapn);
	} else {
	    setPixmap(pixmapr);
	}
	super.draw(p);
    }

}
