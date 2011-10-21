package roart.pacman.graphic;

import roart.pacman.game.Colour;

public class HorizontalWall extends StraightWall {
         
    public HorizontalWall() {
	consfn();
	pix(Shapes.HORIWALL_BITS,Colour.getWallcolour(),Colour.getMybackground());
    };

}
