package roart.pacman.unit;

import roart.pacman.game.Gamedata;
import java.awt.Point;

public class Bonus extends Unmoveable {

private int lifetime; 			//the lifetime of the bonus
            
public void eat(Gamedata g) { };	//a virtual for when pacman eats it

public Bonus() {			//constructor
	setPoint(new Point(roart.pacman.game.Constants.BONUSX, roart.pacman.game.Constants.BONUSY));	//just set the coordinates
}

public int code() {			//code to be done while it exists
return lifetime--;			//just countdown the lifetime
}

public void start() {			//reset the bonus
 lifetime=roart.pacman.game.Constants.BONUSTIME; 			//set lifetime to a certain amount
}

}

