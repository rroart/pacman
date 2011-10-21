package roart.pacman.game;

public class Gamedata {

private static Gamedata instance=null;
  private int hiscore=0;
 private int score=0;
 private int bonus=0;
private int level=0;
private int boardlevel=0;
private int lives=0;
private int eats=0;

public Gamedata() { 
	setLevel(0); 
	lives=0; 
	hiscore=0; 
	score=0; 
	bonus=0; 
	eats=Board.getFoods();
	}

    private static java.util.Random random = new java.util.Random();

public static Gamedata instance() {      //returns the pointer to the instance
 if (instance==null)  {
  instance=new Gamedata();
 }
 return instance;
}

//initializing of gamedata before game starts 
public void start() { 
	level=1; 
	setboardlevel(); 
	lives=Constants.START_LIVES; 
	score=0; 
	bonus=Constants.BONUS_SCORE; 
	eats=Board.getFoods();
	}

//initializing of gamedata after completed level
public void start2() { 
	levelup(); 
	bonus=Constants.BONUS_SCORE; 
	eats=Board.getFoods();
	}

public void scorepluss(int sc) {
	score+=sc; 
	if (score>hiscore) {
		hiscore=score;
		}
	}

public void bondwn() {
	if (bonus > 0) { 
		bonus-=Constants.BONUS_DEC;
		}
	}

    public int ghosts() {
	int ghosts = Constants.START_GHOSTS;
	ghosts += getLevel() / Constants.GHOSTS_DIV;
	if (ghosts > roart.pacman.game.Constants.GHOSTS) {
	    ghosts = roart.pacman.game.Constants.GHOSTS;
	}
	return ghosts;
    }

    public void levelup() {/*level+=9; */ level++;
setboardlevel();
}

public void livesdwn() {if (lives > 0) { lives--;} }

public void livesup() {lives++;}

public int getScore() {return score;}

public int getHiscore() {return hiscore;}

public int getBonus() {return bonus;}

public int getLives() {return lives;}

public int getLevel() {return level;}

public void resetscore() {score=0;}

public void setBonus( int b) {bonus=b;}

public void setLevel(int l) {level=l; setboardlevel();} 

public void setboardlevel() {
 if (level>Constants.LEVELS) {
	 boardlevel=1+(random.nextInt(Constants.LEVELS));
 } else {
	 boardlevel=level;
 }
 //System.out.println("bl " + boardlevel);
}
 
public int getboardlevel() {
return boardlevel;
}

public void setlives(int l) {
	lives=l;
}

public void seteatone() { 
	eats = 1; 
}

public void reseteats() {
	eats=Board.getFoods(); 
}

public boolean eatenall() {
	return eats == 0; 
}

public void foodeat() {
	if (eats > 0) {
		eats--; 
	} else {
		roart.pacman.game.Pacman.pacexit("food"); 
		}
	}

}
