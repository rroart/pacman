package roart.pacman.game;

// java.awt.geom.Point2D
import java.awt.Point;

public class Direction {
public enum direction {up,down,left,right,none,still;
};

//defines possible directions
//    public direction dir;

//get next coordinates going in a certain direction
public static Point next(direction d,Point pp) {
int x=(int)pp.getX();
int y=(int)pp.getY();
switch (d) {
 case none: break;
case still: break;
case up: y--; break;
case down: y++; break;
case left: x--; break;
case right: x++; break;
}
return new Point(x,y);
}

}
