package roart.pacman.unit;
  
import java.awt.Point;
import roart.pacman.graphic.GraphicElement;

public class Element {

private GraphicElement graphicElement;

public void draw(Point p) {	//for drawing the element
graphicElement.draw(p);
}

public void setGraphicElement(GraphicElement gg) {//set the pointer to the graphic element
graphicElement=gg;
}

public GraphicElement getGraphicElement() {
	return graphicElement;
}

}
