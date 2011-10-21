package roart.pacman.graphic;

import roart.pacman.game.Colour;

public class SpecialWall extends StaticElement {

    public SpecialWall() {
	consfn();
	pix(Shapes.SPECWALL_BITS,Colour.getWallcolour(),Colour.getMybackground());

    };

}


