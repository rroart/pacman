package roart.pacman.graphic;

import java.awt.image.IndexColorModel;

import roart.pacman.game.ColourConstants;

public class Colour {

	private IndexColorModel icm;

	    public IndexColorModel get() {
		return icm;
	    }
	
	public Colour(byte rPar, byte gPar, byte bPar) {
		int r = rPar, g = gPar, b = bPar;
	if (roart.pacman.game.Argument.find("grey")) {
	    r = (byte) ColourConstants.I250;
	    g = b;
	    b = g;
	}
	icm = new IndexColorModel(1, 2, new byte[] { 	(byte) 0, (byte) r} ,  new byte[] {(byte) 0,  (byte) g },  new byte[] {      (byte) 0, (byte) b });
	}
}
