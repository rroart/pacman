package roart.pacman.game;

import java.awt.Point;
import roart.pacman.unit.DynamicElement;
import java.awt.image.BufferedImage;

public class BoardElement {
    private DynamicElement graphicDynamicElement;
    public DynamicElement getGraphicDynamicElement() {
		return graphicDynamicElement;
	}
    public void setGraphicDynamicElement(DynamicElement graphicDynamicElement) {
		this.graphicDynamicElement = graphicDynamicElement;
	}
    
    private BufferedImage gid;
    public BufferedImage getGid() {
		return gid;
	}
    public void setGid(BufferedImage gid) {
		this.gid = gid;
	}
    
    private Point point;
    public Point getPoint() {
		return point;
	}
    public void setPoint(Point point) {
		this.point = point;
	}
}
