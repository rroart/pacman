package roart.pacman.unit;

import roart.pacman.game.Gamedata;

public abstract class Moveable extends DynamicElement {
    //protected UserInterface userInterface = null;		//pointer to the userinterface
    //protected Board board = null;			//pointer to the board

    abstract void die(Gamedata g);	//virtual die function
        
};
