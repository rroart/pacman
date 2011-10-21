package roart.pacman.graphic;

import roart.pacman.game.Colour;

public class VerticalWall extends StraightWall {
         
    public VerticalWall() {
	consfn();
	pix(Shapes.VERTWALL_BITS,Colour.getWallcolour(),Colour.getMybackground());
    };

}
