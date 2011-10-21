package roart.pacman.unit;

import java.awt.Point;

public class DynamicElement extends Element {		//from now on it is a sprite

private Point point;					//the sprites coordinates
public Point getPoint() {
	return point;
}
public void setPoint(Point point) {
	this.point = point;
}
private roart.pacman.graphic.DynamicElement graphicDynamicElement = null;		//pointer to the sprite's graphic element

public Point getxy() {	//get it's coordinates
    return point;
}

public void draw(Point p) {			//for drawing the sprite
getGraphicDynamicElement().draw(p);
}

public void draw() {			//for drawing the sprite
getGraphicDynamicElement().draw(point);
}

public /*GID_TYPE*/ java.awt.image.BufferedImage getgid() {		//get it's grahical id
    return getGraphicDynamicElement().getgid();
}
public roart.pacman.graphic.DynamicElement getGraphicDynamicElement() {
	return graphicDynamicElement;
}
public void setGraphicDynamicElement(roart.pacman.graphic.DynamicElement graphicDynamicElement) {
	this.graphicDynamicElement = graphicDynamicElement;
}

}
