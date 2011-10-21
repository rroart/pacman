package roart.pacman.graphic;

import roart.pacman.game.Colour;

public class Food extends Edible {
          
    public Food() {
	consfn();
	pix(Shapes.FOOD_BITS,Colour.getFoodcolour(),Colour.getMybackground());

    };

}


