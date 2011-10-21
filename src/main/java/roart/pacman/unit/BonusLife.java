package roart.pacman.unit;

import roart.pacman.game.Gamedata;

public class BonusLife extends Bonus {
   
//public String is_a() {return "classBonusLife";}    

public BonusLife() { 
 setGraphicDynamicElement(new roart.pacman.graphic.BonusLife()); 	//new one
 }

public void eat(Gamedata da) { 
 da.livesup(); 	//specific action: increment lives
}

}
