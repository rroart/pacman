package roart.pacman.unit;

import roart.pacman.game.Gamedata;

public class BonusPoint extends Bonus {
   
public BonusPoint() { 
 setGraphicDynamicElement(new roart.pacman.graphic.BonusPoint()); 		//new one
 }

public void eat(Gamedata da) { 
 da.scorepluss(roart.pacman.game.Constants.BONUSSCORE);	//specific action: increase score 
}
}
