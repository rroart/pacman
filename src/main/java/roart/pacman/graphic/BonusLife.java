package roart.pacman.graphic;

import roart.pacman.game.Colour;

public class BonusLife extends Bonus {
   
    public BonusLife() {
	consfn();
	pix(Shapes.BONUSLIFE_BITS,Colour.getBonuslifecolour(),Colour.getMybackground());
    };

}
