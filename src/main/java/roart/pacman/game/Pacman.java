package roart.pacman.game;

import roart.pacman.unit.Ghost;
import roart.pacman.unit.Bonus;
import java.awt.Point;

public class Pacman {

    private static java.util.Random random = new java.util.Random();

    //change my name and you will be sued!!!!!!!!!!!!!!!!!!!!!!!!!!
    private static String PACTITLE = "Enterprise Pacman v. 1_003 (C) 1995,1999,2000,2009,2011,2012 by Roar Thronaes";
    //static String PACTITLE = "Pacman v. 1_003 \xa9 1995,1999,2000,2009 by Roar Thron\xe6s";
    // Copyright 1995 by Roar Thronaes
    // Copyright 1999 by Roar Thronaes
    // Copyright 2000 by Roar Thronaes
    // Copyright 2009 by Roar Thronaes
                  
    // routine to make the game exit if there was a previous detected error
 
    public static void pacexit(String s) { 
	//System.out.println("Exit error: " + s);
    }

    // routine do display a warning if it should be

    public static void pacwarning(String s) { 
	//System.out.println("Warning: " + s);
    }

    // checks whether pacman has eaten the bonus, or pacman or some ghost
    // have met and one of them must "die"
 
    public static Bonus check(Board bo,Gamedata da,roart.pacman.unit.Pacman pa, Ghost[] gh,Bonus bon) {
    	Bonus returnBonus = bon;
	int i;				//counter
	boolean alive;			//is pacman still alive 
	Point p1;			//pacman coordinates
	Point p2;			//coordinates for bonus or a ghost
	p1 = pa.getxy();		//get pacman coordinates
	if (bon != null) {			//if there is a bonus on the board
	    p2 = bon.getxy();		//get bonus coordinates
	    if (p1.equals(p2)) {	//if pacman and bonus coordinates the same
		bon.eat(da);		//then bonus is eaten
		returnBonus=null;} 			//and gone
	}
	for(i=0,alive=true;alive && i<da.ghosts();i++) {	//for all ghosts while p. alive	
	    p2 = gh[i].getxy();	//get coordinates
	    if (p1.equals(p2)) {	//if pacman and ghost coordinates the same
		if (pa.isSuper()) 		//if pacman is super
		    { 
			gh[i].die(da);		//then ghost dies	
		    } else { 
			pa.die(da);		//else pacman dies
			alive=false;			//set not alive
		    }
	    } 
	}
	return returnBonus;
    }

    static void writetext() { //just draw text

	UserInterface u=UserInterface.instance();
	Gamedata da=Gamedata.instance();

	u.write(1,1,"Hiscore");        //print to userinterface at x, y, something
	u.write(1,2,da.getHiscore(),Constants.I8);
	u.write(1,Constants.I4,"Score");
	u.write(1,Constants.I5,da.getScore(),Constants.I8);
	u.write(1,Constants.I7,"Lives");
	u.write(1,Constants.I8,da.getLives(),Constants.I8);
	u.write(1,Constants.I10,"Level");
	u.write(1,Constants.I11,da.getLevel(),Constants.I8);
	u.write(1,Constants.I13,"Bonus");
	u.write(1,Constants.I14,da.getBonus(),Constants.I8);
	u.write(1,Constants.I16,"Supertime");
    }

    // storing the command line arguments
    public static void main(String args[]) {
	//Argument a = new Argument(args); 		

	int i; 			//plain counters
	if (Argument.find("16")) {
	    PacmanFrame.setUnitwidth(PacmanFrame.setUnitheight(Constants.I16));
	} else {
	    PacmanFrame.setUnitwidth(PacmanFrame.setUnitheight(Constants.I8));
	}
	Gamedata da=Gamedata.instance(); //gamedata like score, hiscore, lives, levels etc
	Bonus bon=null; 			//the bonus, it can be bonuslife or bonuspoint
	//boolean g; 				//whether pacman moved
	boolean inp; 		//the result of getinput: whether the game is done
	boolean done; 			//whether game is done
	Direction.direction d; 			//the Direction pacman moved
	UserInterface u=UserInterface.instance(/*Keyboard*/); 	//the userinterface to the user

	//srandom(rand());		//reset random number generator

	Board board=Board.instance(); //the pacman board matrix
	roart.pacman.unit.Pacman pac = new roart.pacman.unit.Pacman(); 			//the pacman itself
	Ghost[] gh = new Ghost[Constants.GHOSTS]; 		//the ghosts
	roart.pacman.unit.BonusLife bonl=new roart.pacman.unit.BonusLife();	//a bonuslife not connected to bonus yet
	roart.pacman.unit.BonusPoint bonp=new roart.pacman.unit.BonusPoint();//a bonuspoint not connected to bonus yet
	for (int k = 0; k < Constants.GHOSTS; k++) {
	    gh[k]= new Ghost(Colour.getGhostcolour()[k],new Point(Constants.GHOSTX[k],Constants.GHOSTY[k])); //initializing ghosts 
	}
    
	inp=u.getinput(); 		//gets whether the game is done

	writetext();

	done=false; 			//means not done
	while (!done) { 		//while not done

	    da.start(); 			//total initialization of the gamedata
	    u.write(1,Constants.I8,da.getLives(),Constants.I8);
	    u.write(1,Constants.I11,da.getLevel(),Constants.I8);
	    u.write(1,Constants.I14,da.getBonus(),Constants.I8);

	    while (!done && da.getLives() > 0) { //while game not done and pacman still alive
		int ghosts = da.ghosts();

		board.start(da.getboardlevel());//resets board to a certain level

		PacmanFrame.instance();
		//pf.addKeyListener(pf);

		try {
		    Thread.sleep(Constants.I1000);
		} catch (Exception e) {
		}

		pac.start(); 			//reset pacman
		for(i=0;i<ghosts;i++) { 		//reset all ghosts
		    gh[i].start();
		}

		board.draw(); 			//draw entire board
		PacmanFrame.setRepaint(true);

		d=Direction.direction.still; 			//pacman got direction still, no moving
		board.deltaDraw(); 		//draw just the changes of the board
		u.write(1,Constants.I8,da.getLives(),Constants.I8);
		Timing timing = new Timing();
		timing.timingstart(); 			//reset the timer

		while (!done && da.getLives() > 0 && !da.eatenall()) { 
		    //while game not done and pacman still alive 
		    // and while not all food eaten
		    bon = handleMoves(false, da, bon, d, board, pac, gh, ghosts, timing, u);
		    d=u.stick();			//pacman got direction
		    bon = bonusRandom(bon, bonl, bonp);
		    if (pac.isSuper()) { 		//if pac has eaten superfood do an extra run
		    	bon = handleMoves(pac.isSuper(), da, bon, d, board, pac, gh, ghosts, timing, u);
		    	
			d=u.stick();			//pacman got direction
		    }
		    if (true) {
			boolean superBool = false;
			for (i = 0; i < ghosts; i++) {
			    if (gh[i].isSuper()) {
				superBool = true;
				gh[i].lookforpac(pac);
				gh[i].go(pac);		//let pacman go direction d
			    }
			}
			if (superBool) {
			    bon = check(board,da,pac,gh,bon);	// checks whether pacman has eaten the bonus, or pacman or some ghost have met and one of them must "die" 
			    board.sprite(pac);		//let it be a sprite
			    for(i=0;i<ghosts;i++) { 
				board.sprite(gh[i]);	//let it be a sprite
			    }
			    if (bon != null) {
			    	board.sprite(bon);	//let it be a sprite
			    }
			    board.deltaDraw();		//draw just the changes of the board
			}
		    }
		    if (pac.isDead()) {  		// do this if pacman died
			bon = pacmanDie(da, u, board, pac, gh, ghosts, timing);
		    }

		    updateDataAndDisplay(da, u, pac);
		    
		    inp=u.getinput();		//get whether the game is wanted to end
		    done=inp;
		}

		if (!done) {			//if not done
		    if (!da.eatenall()) { 		//if not all food eaten
			 u.write(1,Constants.I20,"GAME OVER"); 	//then the game must be over
			 u.waitsync(); 		//wait til everything is printed to screen
			 for(i=0;i<Constants.I4;i++,timing.timing(false)); 	//wait a sec or something
			 u.write(1,Constants.I20,"         "); 	//then write nothing
			 da.start(); 			//reset gamedata
			 u.write(1,Constants.I8,da.getLives(),Constants.I8);
			 u.write(1,Constants.I11,da.getLevel(),Constants.I8);
			 u.write(1,Constants.I14,da.getBonus(),Constants.I8);
		    } else {  			// all food must have been eaten
			 da.scorepluss(da.getBonus()); 	//add score with bonus
			 da.start2(); 			//prepare gamedata for next level
			 u.write(1,Constants.I11,da.getLevel(),Constants.I8);
			 u.write(1,Constants.I14,da.getBonus(),Constants.I8);
		    }
		}
	    }
	}

	// all the rest of this is end of game cleanup
      
	//return 1; 
          
    }

	private static Bonus handleMoves(Boolean isSuper, Gamedata da, Bonus bon,
			Direction.direction d, Board board, roart.pacman.unit.Pacman pac,
			Ghost[] gh, int ghosts, Timing timing, UserInterface u) {
		int i;
		if (isSuper) {
		u.write(1,Constants.I17,pac.getsupertime(),Constants.I8);
		} else {
		for(i=0;i<ghosts;i++) { 		//let all ghosts look for pacman
		gh[i].lookforpac(pac);
		}
		}
		pac.go(d,da); 		//let pacman go direction d
		bon = check(board,da,pac,gh,bon);	// checks whether pacman has eaten the bonus, or pacman or some ghost have met and one of them must "die" 
		if (!isSuper) {
		for(i=0;i<ghosts;i++) {
		gh[i].go(pac); 		//let the ghosts move
		}
		bon = check(board,da,pac,gh,bon);	// checks whether pacman has eaten the bonus, or pacman or some ghost have met and one of them must "die" 
		}
		board.sprite(pac); 		//let it be a sprite
		for(i=0;i<ghosts;i++) {
		board.sprite(gh[i]);		//let it be a sprite
		}
		if (bon != null) {
			board.sprite(bon);	//let it be a sprite
		}
		board.deltaDraw(); 		//draw just the changes of the board
		timing.timing(pac.isSuper()); 	//do timing: make the game go smooth enough
		return bon;
	}

	private static Bonus bonusRandom(Bonus bon,
			roart.pacman.unit.BonusLife bonl, roart.pacman.unit.BonusPoint bonp) {
		Bonus returnBonus = bon;
		if (bon == null) { 			// if no bonus if "on"
		if ((random.nextInt() & /*127*/ Constants.I4095)==0) { 
		    if ((random.nextInt() & /*128*/ Constants.I61440)!=0) { 
			returnBonus=bonp; 			//if seldom start a bonuspoint
		    } else { 
			returnBonus=bonl;		 	//if very seldom start a bonuslife
		    }
		    bon.start(); } 		//reset the spesific bonus thing
		} 
		if (bon != null && bon.code() == 0) { 			//if bonus exists
		 		//returns whether the bonus has lived it's time
		    returnBonus=null;  			// "remove" bonus
		}
		return returnBonus;
	}

	private static void updateDataAndDisplay(Gamedata da, UserInterface u,
			roart.pacman.unit.Pacman pac) {
		da.bondwn();			//countdown bonus
		u.write(1,2,da.getHiscore(),Constants.I8);
		u.write(1,Constants.I5,da.getScore(),Constants.I8);
		u.write(1,Constants.I14,da.getBonus(),Constants.I8);
		if (pac.isSuper()) {		//if pac is super
		u.write(1,Constants.I17,pac.getsupertime(),Constants.I8);	//write remaining supertime
		} else { 
		u.write(1,Constants.I17,"         ");	//write nothing
		}
	}

	private static Bonus pacmanDie(Gamedata da, UserInterface u, Board board,
			roart.pacman.unit.Pacman pac, Ghost[] gh, int ghosts, Timing timing) {
		int i;
		Bonus bon;
		bon=null;                    //no more bonus, is gone
		u.write(1,Constants.I8,da.getLives(),Constants.I8);
		board.sprite(pac);	//let it be a sprite
		board.deltaDraw();	//draw just the changes of the board
		timing.timing(false);		//do timing
		pac.go(Direction.direction.right,da);	//let pacman point right
		board.sprite(pac);	//let it be a sprite
		board.deltaDraw();	//draw just the changes of the board
		timing.timing(false);		//do timing
		pac.go(Direction.direction.up,da);		//let pacman point up
		board.sprite(pac);	//let it be a sprite
		board.deltaDraw();	//draw just the changes of the board
		timing.timing(false);		//do timing
		pac.go(Direction.direction.left,da);		//let pacman point left
		board.sprite(pac);	//let it be a sprite
		board.deltaDraw();	//draw just the changes of the board
		timing.timing(false);		//do timing
		pac.go(Direction.direction.down,da);		//let pacman point down
		board.sprite(pac);	//let it be a sprite
		board.deltaDraw();	//draw just the changes of the board
		timing.timing(false);		//do timing 
		pac.go(Direction.direction.right,da);	//let pacman point right
		board.sprite(pac);	//let it be a sprite
		board.deltaDraw();	//draw just the changes of the board
		timing.timing(false);		//do timing
		pac.start();		//reset pacman
		for(i=0;i<ghosts;i++) {
		    gh[i].start(); 		//reset ghosts
		}
		return bon;
	}

	public static String getPACTITLE() {
		return PACTITLE;
	}

	public static void setPACTITLE(String pACTITLE) {
		PACTITLE = pACTITLE;
	}
  
                
           
}
