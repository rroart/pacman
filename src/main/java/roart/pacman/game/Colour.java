package roart.pacman.game;

import java.awt.image.IndexColorModel;

//import roart.pacman.graphic.Colour;

public class Colour {
	
	private roart.pacman.graphic.Colour graphicColour;
	
	public Colour(byte r, byte g, byte b) {
		graphicColour = new roart.pacman.graphic.Colour(r, g, b);
	}

    public IndexColorModel get() {
	return graphicColour.get();
    }

	public static Colour getMyforeground() {
		return myforeground;
	}

	public static void setMyforeground(Colour myforeground) {
		Colour.myforeground = myforeground;
	}

	public static Colour getMybackground() {
		return mybackground;
	}

	public static void setMybackground(Colour mybackground) {
		Colour.mybackground = mybackground;
	}

	public static Colour getWallcolour() {
		return wallcolour;
	}

	public static void setWallcolour(Colour wallcolour) {
		Colour.wallcolour = wallcolour;
	}

	public static Colour getPacmancolour() {
		return pacmancolour;
	}

	public static void setPacmancolour(Colour pacmancolour) {
		Colour.pacmancolour = pacmancolour;
	}

	public static Colour getGhostcolour1() {
		return ghostcolour1;
	}

	public static void setGhostcolour1(Colour ghostcolour1) {
		Colour.ghostcolour1 = ghostcolour1;
	}

	public static Colour getGhostcolour2() {
		return ghostcolour2;
	}

	public static void setGhostcolour2(Colour ghostcolour2) {
		Colour.ghostcolour2 = ghostcolour2;
	}

	public static Colour getGhostcolour3() {
		return ghostcolour3;
	}

	public static void setGhostcolour3(Colour ghostcolour3) {
		Colour.ghostcolour3 = ghostcolour3;
	}

	public static Colour getGhostcolour4() {
		return ghostcolour4;
	}

	public static void setGhostcolour4(Colour ghostcolour4) {
		Colour.ghostcolour4 = ghostcolour4;
	}

	public static Colour[] getGhostcolour() {
		return ghostcolour;
	}

	public static void setGhostcolour(Colour[] ghostcolour) {
		Colour.ghostcolour = ghostcolour;
	}

	public static Colour getRunghostcolour() {
		return runghostcolour;
	}

	public static void setRunghostcolour(Colour runghostcolour) {
		Colour.runghostcolour = runghostcolour;
	}

	public static Colour getFoodcolour() {
		return foodcolour;
	}

	public static void setFoodcolour(Colour foodcolour) {
		Colour.foodcolour = foodcolour;
	}

	public static Colour getSuperfoodcolour() {
		return superfoodcolour;
	}

	public static void setSuperfoodcolour(Colour superfoodcolour) {
		Colour.superfoodcolour = superfoodcolour;
	}

	public static Colour getBonuspointcolour() {
		return bonuspointcolour;
	}

	public static void setBonuspointcolour(Colour bonuspointcolour) {
		Colour.bonuspointcolour = bonuspointcolour;
	}

	public static Colour getBonuslifecolour() {
		return bonuslifecolour;
	}

	public static void setBonuslifecolour(Colour bonuslifecolour) {
		Colour.bonuslifecolour = bonuslifecolour;
	}

	private static Colour cyan=(new Colour((byte)ColourConstants.I0,(byte)ColourConstants.I255,(byte)ColourConstants.I255));
    private static Colour black=(new Colour((byte)ColourConstants.I0,(byte)ColourConstants.I0,(byte)ColourConstants.I0));
    private static Colour white=(new Colour((byte)ColourConstants.I255,(byte)ColourConstants.I255,(byte)ColourConstants.I255));
    private static Colour lightblue=(new Colour((byte)ColourConstants.I173,(byte)ColourConstants.I216,(byte)ColourConstants.I230));
    private static Colour yellow=(new Colour((byte)ColourConstants.I255,(byte)ColourConstants.I255,(byte)ColourConstants.I0));
    private static Colour red=(new Colour((byte)ColourConstants.I255,(byte)ColourConstants.I0,(byte)ColourConstants.I0));
    private static Colour orangered=(new Colour((byte)ColourConstants.I255,(byte)ColourConstants.I69,(byte)ColourConstants.I0));
    private static Colour violetred=(new Colour((byte)ColourConstants.I208,(byte)ColourConstants.I32,(byte)ColourConstants.I144));
    private static Colour violet=(new Colour((byte)ColourConstants.I238,(byte)ColourConstants.I130,(byte)ColourConstants.I238));
    private static Colour deepskyblue=(new Colour((byte)ColourConstants.I0,(byte)ColourConstants.I191,(byte)ColourConstants.I255));
    private static Colour gold=(new Colour((byte)ColourConstants.I255,(byte)ColourConstants.I215,(byte)ColourConstants.I0));
    private static Colour lightyellow=(new Colour((byte)ColourConstants.I255,(byte)ColourConstants.I255,(byte)ColourConstants.I0));

    private static Colour myforeground =cyan;
    private static Colour mybackground =black;
    private static Colour wallcolour =deepskyblue;
    private static Colour pacmancolour =yellow;
    private static Colour ghostcolour1 =red;
    private static Colour ghostcolour2 =violetred;
    private static Colour ghostcolour3 =violet;
    private static Colour ghostcolour4 =orangered;
    private static Colour[] ghostcolour = new Colour[] { red, violetred, violet, orangered, red, violetred, violet, orangered };
    private static Colour runghostcolour =lightblue;
    private static Colour foodcolour =lightyellow;
    private static Colour superfoodcolour =gold;
    private static Colour bonuspointcolour =gold;
    private static Colour bonuslifecolour =gold;

}

