package roart.pacman.graphic;

import roart.pacman.game.Colour;

public class BonusPoint extends Bonus {
   
    public BonusPoint() {
	consfn();
	pix(Shapes.BONUSPOINT_BITS,Colour.getBonuspointcolour(),Colour.getMybackground());
    };

}


