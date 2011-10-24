package roart.pacman.unit;

import roart.pacman.unit.Pacman;
import roart.pacman.game.Direction;
import roart.pacman.game.Gamedata;
import roart.pacman.game.Board;
import roart.pacman.game.Colour;

import java.awt.Point;

//the status: whether the ghost is going at random, it has seen pacman and is hunting him down, if pacman is super and hunting the ghosts, and whether the ghost itself is eaten by the pacman

public class Ghost extends Moveable {

    private static java.util.Random random = new java.util.Random();

    public enum gstat {randm,hunter,hunted,eaten};

    private Point startp; 	//starting coordinates
    private Point goP; 		//if it hunts pacman, this is were it was last seen
    //int dx,dy;     		//increments to get go where pacman was last seen     
    private gstat st;		//the ghost's status
    private boolean superBool;
    private int supertime;
    private Direction.direction d;		//the direction the ghost is going
    private int deadtime;	//the remaing time for the ghost to be dead if it's eaten
    private int randmv;	//a random number for changing direction when moving at random
    private roart.pacman.graphic.Ghost g;		//a pointer to the ghost graphical element

    private int ghostseaten=0;			//initializing

    private Board b;

    public Ghost(Colour colour,Point pp) {	//constructor
	b=Board.instance();				//get the instance of the board
	d=Direction.direction.up; 						//direction to move is up
	g=new roart.pacman.graphic.Ghost(colour);				//a new one
	startp = new Point(pp);					//set initial coordinates
	setPoint(new Point(pp));
	st=gstat.randm;					//move at random
	randmv=Constants.GHOST_RANDOM_BASE;
	randmv=(random.nextInt(Constants.GHOST_RANDOM)) + Constants.GHOST_RANDOM_BASE;//a random number about changing direction when randoming
	superBool = false;
	supertime = 0;
    }

    public    void start() {	//reset ghost
	setPoint(startp);		//set initial coordinates
	st=gstat.randm;		//move at random
	d=Direction.direction.up;			//direction is up
	ghostseaten=0;		//number of ghosts eaten is zero
	superBool = false;
	supertime = 0;
    }

    public /*GID_TYPE*/ java.awt.image.BufferedImage getgid() {
	return g.getgid();
    }
 
    public void die(Gamedata da) {	//when pacman eats ghost
	int i, 				//plain counter
	    sc; 				//score temporary
	ghostseaten++;			//another ghost eaten by pacman
	for(i=ghostseaten,sc=roart.pacman.game.Constants.GHOSTSCORE;i>1;i--,sc*=2) { };
	da.scorepluss(sc);
	deadtime=roart.pacman.game.Constants.DEADTIME;		//set time to be dead
	st=gstat.eaten;			//set status to eaten
	setPoint(startp);			//set initial coordinates
	d=Direction.direction.still;			//direction is still
	superBool = false;
	supertime = 0;
    }

    public    void draw() {	//draw the ghost
	g.draw(getPoint(),st==gstat.hunted);//3rd parameter is about colour: ghost hunted or not
    }

    void eat() {		//when pacman eats ghost
	deadtime=roart.pacman.game.Constants.DEADTIME;		//set time to be dead
	st=gstat.eaten;			//set status to eaten
	setPoint(startp);			//set initial coordinates
    }

    boolean otherdir(Point pp,Direction.direction dd) {//is there an other direction to go
	try {
	    Point ppp;			//coordinates
	    Direction.direction goleft=Direction.direction.still,goright=Direction.direction.still;	//the relative left/right to where a ghost goes
	    switch (dd) {			//find out relative direction
	    case up: {goleft=Direction.direction.left; goright=Direction.direction.right; } break;
	    case down: {goleft=Direction.direction.right; goright=Direction.direction.left; } break;
	    case left: {goleft=Direction.direction.up; goright=Direction.direction.down; } break;
	    case right: {goleft=Direction.direction.down; goright=Direction.direction.up; } break;
	    }
	    ppp = Direction.next(goleft,pp);	//next coordinates if left
	    if (Class.forName(Constants.WALLS).isAssignableFrom(b.whatis(ppp).getClass())) {
		goleft=Direction.direction.none;//set none if a wall is left
	    }
	    if (Class.forName(Constants.WALLS).isAssignableFrom(b.whatis(ppp).getClass())) {
		goright=Direction.direction.none;//set none if a wall is right
	    }
	    // 	// printf("%d\n",goleft.dir!=none && goright!=Direction.direction.none);
	    return (goleft!=Direction.direction.none || goright!=Direction.direction.none);//whether left or right is not a wall
	} catch (Exception e) {
	    //System.out.println("Exception " + e);
	    java.io.StringWriter sw = new java.io.StringWriter();
	    java.io.PrintWriter pw = new java.io.PrintWriter(sw);
	    e.printStackTrace(pw);
	    //System.out.println("st " + sw.toString());
	}
	return false;
    }

    Direction.direction newdir(Point pp,Direction.direction dd) {//gets a new direction to go
	try {
	    Point ppp;			//coordinates
	    Direction.direction goleft=Direction.direction.still,goright=Direction.direction.still;	//the relative left/right to where a ghost goes
	    switch (dd) {			//find out relative direction
	    case up: {goleft=Direction.direction.left; goright=Direction.direction.right; } break;
	    case down: {goleft=Direction.direction.right; goright=Direction.direction.left; } break;
	    case left: {goleft=Direction.direction.up; goright=Direction.direction.down; } break;
	    case right: {goleft=Direction.direction.down; goright=Direction.direction.up; } break;
	    }
	    ppp = Direction.next(goleft,pp);	//next coordinates if left
	    if (Class.forName(Constants.WALLS).isAssignableFrom(b.whatis(ppp).getClass())) {
		goleft=Direction.direction.none;//set none if a wall is left
	    }
	    ppp = Direction.next(goright,pp);//next coordinates if right
	    if (Class.forName(Constants.WALLS).isAssignableFrom(b.whatis(ppp).getClass())) {
		goright=Direction.direction.none;//set none if a wall is right
	    }
	    //if (goleft==none && goright==none) exit(1);
	    //if either is none return the other
	    // if (startx==15 && starty==9) printf("change at %d %d\n",x,y);
	    if (goleft==Direction.direction.none) { return goright; }
	    if (goright==Direction.direction.none) { return goleft; }
	    //if both is not none then choose one at random
	    if (random.nextBoolean()) { 
	    	return goright; 
	    } else { 
	    	return goleft;
	    }
	} catch (Exception e) {
	    //System.out.println("Exception " + e);
	    java.io.StringWriter sw = new java.io.StringWriter();
	    java.io.PrintWriter pw = new java.io.PrintWriter(sw);
	    e.printStackTrace(pw);
	    //System.out.println("st " + sw.toString());
	}
	return dd;
    }

    //    private boolean searchpac(Direction.direction dd, Point gop,Pacman pac) 
    private boolean searchpac(Object[] arr,Pacman pac) {//look for pacman
	Direction.direction dd = (Direction.direction) arr[0];
	Point gop = (Point) arr[1];
	try {
	    Point pp;			//coordinates
	    double dx,dy;				//delta goto coordinates
	    Point gopp;			//goto coordinates
	    gopp = pac.getxy();	//get pacman coordinates
	    if (gopp.getX()==getPoint().getX() || gopp.getY()==getPoint().getY()) {	//if either x or y coordinates same
		//System.out.println("co ");
		dx=gopp.getX()-getPoint().getX();
		dy=gopp.getY()-getPoint().getY();
		//set deltas dx dy to add to x,y to get to goxx goyy
		if (dx<0) { 
			dx=-1 ;
		}
		if (dx>0) { 
			dx=1;
		}
		if (dy<0) { 
			dy=-1;
		}
		if (dy>0) {
			dy=1;
		}
		pp = new Point(getPoint());
		while (!(pp.equals(gopp)) && !Class.forName(Constants.WALLS).isAssignableFrom(b.whatis(pp).getClass())) {
		    //System.out.println("w " + b.what_is(pp).getClass());
		    pp = new Point((int)(pp.getX() + dx), (int)(pp.getY() + dy));
		}
		//checks whether there is a wall between pacman and ghost
		if (pp.equals(gopp)) {//if no wall hunt pacman
		    getNewDirection(arr, dx, dy, gopp);
		    return true;
		}
	    }
	} catch (Exception e) {
	    //System.out.println("Exception " + e);
	    java.io.StringWriter sw = new java.io.StringWriter();
	    java.io.PrintWriter pw = new java.io.PrintWriter(sw);
	    e.printStackTrace(pw);
	    //System.out.println("st " + sw.toString());
	}
	return false;
    }

	private void getNewDirection(Object[] arr, double dx, double dy, Point gopp) {
		Direction.direction dd;
		Point gop;
		gop = gopp;
		if (st==gstat.hunted) { dx=-dx; dy=-dy; } //if pacman is super then run
		dd=Direction.direction.up; // dummy
		if (dx==0 && dy==-1) { 
			dd=Direction.direction.up;
		}
		if (dx==0 && dy==1) {
			dd=Direction.direction.down;
		}
		if (dx==1 && dy==0) {
			dd=Direction.direction.right;
		}
		if (dx==-1 && dy==0) {
			dd=Direction.direction.left;
		}
		arr[0] = dd;
		arr[1] = gop;
	}

    public void lookforpac(Pacman pac) {//look for pacman
	boolean i=true;			//ghost moved?
	Point pp;			//coordinates

	if (pac.isSuper())		// if pacman is super 
	    { if (st!=gstat.eaten) { st=gstat.hunted; } }	//then if ghost is not eaten then it is hunted
	else { 				//if pacman not super
	    if (st==gstat.hunted) {	//if ghost is (was) hunted it must now be random
		st=gstat.randm; 			//must be random
		ghostseaten=0;		//set number of ghosts eaten back to zero
	    } 
	} 
	switch (st) {			//case ghost status of
	case hunter: {			//if ghost is hunter
	    Object[] arr = new Object[]{ d, goP };
	    i=searchpac(arr,pac);//then search for pacman
	    d = (Direction.direction) arr[0];
	    goP = (Point) arr[1];
	    if (i) {			//if found 
		pp = pac.getxy();		//and pacman coordinates
		if (getPoint().equals(pp)) {
			d=Direction.direction.still;	//are equal to ghosts's: stand still
		}
	    }
	}
	    break;
	case randm: {
	    Object[] arr = { d, goP };
	    i=searchpac(arr,pac);	//then search for pacman
	    d = (Direction.direction) arr[0];
	    goP = (Point) arr[1];
	    if (i) {				//if found
		st=gstat.hunter;				//then ghost is a hunter
	    }
 
	} break;
	case hunted: {
	    Object[] arr = new Object[]{ d, goP };
	    i=searchpac(arr,pac);	//then search for pacman
	    d = (Direction.direction) arr[0];
	    goP = (Point) arr[1];
	} break;
	case eaten: {
	} break;
	}
    }

    public void go(Pacman pac) {	//go for pacman: do ghost code
	String w;				//what type is at next coordinates
	boolean i=true;			//moved or not?
	Point pp;			//coordinates

	if (pac.isSuper()) 		//if pacman is super
	    { if (st!=gstat.eaten) {
	    	st=gstat.hunted; } 	//if st is not eaten then ghost is hunted
	    }
	else { if (st==gstat.hunted) {
		st=gstat.randm; } 	//else if pacman is not and ghost
	}
	//is still hunted then it is now random
	switch (st) {			//if ghost status is
	case hunter: {			//hunter
	    Object[] arr = new Object[]{ d, goP };
	    i=searchpac(arr,pac);//then search for pacman
	    d = (Direction.direction) arr[0];
	    goP = (Point) arr[1];
	    if (i) { 			//if found
		pp = pac.getxy();		//and pacman coordinates
		if (getPoint().equals(pp)) {
			d=Direction.direction.still;	//are equal to ghosts's: stand still
		}
		break;
	    }
	    if (goP.equals(getPoint())) {//if ghost has reached pacman last known coordinates
		pp = pac.getxy();	//get pacman coordinates
		//if (!otherdir(x,y,d)) //and if there is not an other possible l/r direction
		d = newdir(getPoint(),d); 	//change direction
		st=gstat.randm; 		//and do random movements.
	    }
	} break;
	case randm: {				//if ghost moves at random
	    Object[] arr = new Object[]{ d, goP };
	    i=searchpac(arr,pac);	//then search for pacman
	    d = (Direction.direction) arr[0];
	    goP = (Point) arr[1];
	    if (i) {				//if found
		st=gstat.hunter;				//then ghost is hunter
	    } else {
		if (otherdir(getPoint(),d)) {//and if there is an other possible l/r direction
		    // check randmv could not be
		    if (randmv > 0 && (random.nextInt(randmv)) == 0) {	//if random "hits" 
			d = newdir(getPoint(),d); 		//then change direction
		    }
		}
	    }
	} break;
	case hunted: {			//if the ghost is hunted
	    Object[] arr = new Object[]{ d, goP };
	    i=searchpac(arr,pac);//then search for pacman
	    d = (Direction.direction) arr[0];
	    goP = (Point) arr[1];
	} break;
	case eaten: {			//if ghost is eaten
	    if (deadtime > 0) { 		//is > 0
		deadtime--;  		//decrement it by one
	    } else 
		{
		    st=gstat.randm; 		//else, if it is zero, then it's status is random
		    d=Direction.direction.up; 		//and direction is up
		}
	} break;
	}

	if (superBool) {
	    if (supertime > 0) { 	//if supertime is > 0
		supertime--; 	//decrement supertime
	} else { 
		superBool = false;   	//if supertime is zero then status is normal
	}
    }

	//if (dd!=none) d=dd;
	pp = Direction.next(d,getPoint());		//find next coordinates
	w=b.whatis(pp).getClass().getName();		//what's at those new coordinates then
	//if (x==xx && y==yy) printf("%d %d\n\n",st,d);
	//printf("%d %d %d %d %d %d %d %d %d
	//%d\n\n",up,down,left,right,none,still,randm,hunter,hunted,eaten);
	//exit(1);
	//if w is a
	if (!w.equals(Constants.WALLS)) {
	    setPoint(pp);
	} else {
	    i=false; 				//can not go through walls
	    d = newdir(getPoint(),d); 		//find a new direction
	    pp = Direction.next(d,getPoint()); 		//find next coordinates
	    setPoint(pp); 			//set to new coordinates 
	}
	if (w.equals(Constants.SUPER_FOOD)) {
	    superBool = true;			//set status to super
	    //set supertime, too 
	    supertime = Constants.SUPERTIME_BASE + Gamedata.instance().getLevel();
	    if (supertime > roart.pacman.game.Constants.SUPERTIME/2) {
		supertime = roart.pacman.game.Constants.SUPERTIME/2;
	    }
	} 
    }

    public boolean isSuper() {
	return superBool;
    }
}

//   if (otherdir(x,y,d)) {//and if there is an other possible l/r direction
//    if (!(random()%randmv))	//if random "hits" 
//     newdir(x,y,d); 	//then change direction


// if (go_x==x && go_y==y) {//if ghost has reached pacman last known coordinates
//  pac.getxy(xx,yy);	//get pacman coordinates
//if (!otherdir(x,y,d));	//and if there is an other possible l/r direction
//   newdir(x,y,d);	//change direction
//   st=randm;		//and do random movements.
