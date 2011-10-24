package roart.pacman.unit;

import java.awt.Point;
import roart.pacman.game.Board;
import roart.pacman.game.Direction;
import roart.pacman.game.Gamedata;

public class Pacman extends Moveable {

    enum stat {dead,normal,super_;
    };

    private static    Board b;

    private roart.pacman.graphic.Pacman g;		//pointer to the pacman graphic element
    private stat st;		//what't it's state: dead, normal or super
    private int supertime;		//the remaning time pacman is super
    private Direction.direction d,tryDir;	//what direction is it going, what direction was tried

    public Pacman() {	//constructon
	b=Board.instance();	//get the instance of the board
	//System.out.println("Pacman b " + b);
	g=new roart.pacman.graphic.Pacman();	//a new one
	supertime=0;		//supertime must be set to zero
    }

    public void start() {
	setPoint(new Point(roart.pacman.game.Constants.PACX, roart.pacman.game.Constants.PACY)); 		//set it's initial coordinates
	st=stat.normal;		//set status to normal
	d=Direction.direction.still; 		//direction is still
	tryDir=Direction.direction.right;		//face right
	supertime=0;		//supertime must be set to zero
    }

    public boolean isDead() {	//is pacman dead?
	return st==stat.dead;
    }

    public void die(Gamedata da) {	//let pacman die a life
	st=stat.dead; 				//status is dead
	da.livesdwn();			//decrement a life
    }

    public int getsupertime() {	//get the remaning time pacman is super
	return supertime;}

    public boolean isSuper() { 	//is pacman super?
	return st==stat.super_;
    }

    public void draw() {	//specific draw for pacman
	g.draw(getPoint(),d,tryDir);	//draw pacman direction it was going and was tried
    }

    public    java.awt.image.BufferedImage /*GID_TYPE*/ getgid() {
	return g.getgid(d,tryDir);
    }

    public boolean go(Direction.direction dd,Gamedata da) {//what direction to try to move it
	try {
	    String w;					//what's at new coordinates
	    boolean i=true;	//this i is returned: it is whether pacman moved or not.
	    Point pp;	//possible next coordinates
	    if (dd!=Direction.direction.none) {
	    	d = dd;//if a direction!=none given, set the two directions
	    	tryDir = dd;
	    }
	    if (st==stat.dead) { 	//if pacman died
		d=Direction.direction.still; 		//then actual moving direction is still 
		return false;		//and return not moved
	    }
	    handleSupertime();

	    pp = Direction.next(d,getPoint());	//compute next coordinates
	    w=b.whatis(pp).getClass().getName();	//what's at new coordinates

	    //if it's
	    if (w.equals("roart.pacman.unit.SpecialWall") || w.equals("roart.pacman.unit.Walls")) //can't move through walls
		{ i=false; d=Direction.direction.still; }
	    if (w.equals("roart.pacman.unit.Food")) {
		setPoint(pp); 				//set to new coordinates
		b.eat(getPoint());				//eat food at board coordinates
		da.foodeat(); 			//let gamedata know a food is eaten
		da.scorepluss(roart.pacman.game.Constants.FOODSCORE); 		//increase the score
	    }
	    if (w.equals("roart.pacman.unit.SuperFood")) {
		setPoint(pp); 				//set to new coordinates
		b.eat(getPoint()); 				//eat superfood at board coordinates
		st=stat.super_; 				//set status to super
		supertime=roart.pacman.game.Constants.SUPERTIME;			//set supertime, too 
	    } 
	    if (w.equals("roart.pacman.unit.Blank")) {
		setPoint(pp);  				//set to new coordinates
	    }
	    // case BonusLife: { x=xx; y=yy; b.eat(x,y); } break;
	    // case BonusPoint: { x=xx; y=yy; b.eat(x,y); } break;
	    //default: /*printf("caseerror\n");*/ break;

	    //printf("%d\n",d);	   
	    //printf("%s",w);	   
	    return i;	//this i is returned: it is whether pacman moved or not.
	} catch (Exception e) {
	    //System.out.println("Exception " + e);
	}
	return false;
    }

	private void handleSupertime() {
		switch (st) {
	    case super_: {		//if super
		if (supertime > 0) { 	//if supertime is > 0
		    supertime--; 	//decrement supertime
		} else { 
		    st=stat.normal;   	//if supertime is zero then status is normal
		}
		} break;
	    case normal: break;
	    }
	}

}
