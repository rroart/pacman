package roart.pacman.graphic;

import roart.pacman.game.Colour;

public class Blank extends StaticElement {
         
public Blank() {
    consfn();
    pix(Shapes.BLANK_BITS,Colour.getWallcolour(),Colour.getMybackground());
}

}
