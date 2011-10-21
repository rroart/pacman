package roart.pacman.game;

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class PacmanFrame extends Frame implements KeyListener, WindowListener {
    private static PacmanFrame instance = null;

    private static int textwidth, textheight;
    private FontMetrics fontmetrics;
    private static int unitwidth, unitheight;

    public static PacmanFrame instance() {
	if (instance == null) {
	    instance = new PacmanFrame();
	}
	return instance;
    }

    @SuppressWarnings("deprecation")
	public PacmanFrame() {
	super("Pacman");
	//System.out.println("hello2");
	//Frame frame = new Frame(); // check X11 if exc -> text
	if (Argument.find("16")) {
	    setBounds(0, 0, Constants.I800, Constants.I600);
	    setSize(Constants.I800, Constants.I600);
	} else {
	    setBounds(0, 0, Constants.I600, Constants.I400);
	    setSize(Constants.I600, Constants.I400);
	}
	setTitle(Pacman.getPACTITLE());
	setVisible(true);
	//System.out.println("hello3");
	show();
	fontmetrics = this.getGraphics().getFontMetrics();
	setTextheight(fontmetrics.getHeight());
	//String space = " ";
	//byte[] spaceb = space.getBytes();
	char[] spacec = new char[]{ ' ' };
	setTextwidth(fontmetrics.charsWidth(spacec, 0, 1));
	//System.out.println("hello4");
	this.addKeyListener(this);
	this.addWindowListener(this);
	if (instance == null) {
	    instance = this;
	}
    }

    public void update(Graphics g){
	//not used?
	//System.out.println("hello1");
	paint(g);
    }

    //    public static BufferedImage img;

    private static boolean repaint = false;

    public void paint(Graphics g) {
	if (isRepaint()) {
	//System.out.println("paint");
	Pacman.writetext();
	Board board=Board.instance(); //the pacman board matrix
	board.draw();
	board.resetoldlist();
	}
	//firstpaint = false;
// 	try {
// 	    String s= null;
// 	    if (s.equals("s")) {
// 	    }
// 	} catch (Exception e) {
// 	    e.printStackTrace();
// 	}
    }

        public void keyTyped(KeyEvent e) {
	    //System.out.println("e3");
	    //displayInfo(e, "KEY TYPED: ");
     }


    private static int key;
    
    /** Handle the key pressed event from the text field. */
    public void keyPressed(KeyEvent e) {
	//        displayInfo(e, "KEY PRESSED: ");
	setKey(e.getKeyCode());
	//System.out.println("e " + key);
    }
    
    /** Handle the key released event from the text field. */
     public void keyReleased(KeyEvent e) {
	 //System.out.println("e2");
    //    displayInfo(e, "KEY RELEASED: ");
     }

    public void windowDeactivated(WindowEvent e) {
	//System.out.println("windowDeactivated " + e.toString());
    }

    public void windowActivated(WindowEvent e) {
	//System.out.println("windowActivated " + e.toString());
    }

    public void windowDeiconified(WindowEvent e) {
	//System.out.println("windowDeiconified " + e.toString());
    }

    public void windowIconified(WindowEvent e) {
	//System.out.println("windowIconified " + e.toString());
    }

    public void windowClosed(WindowEvent e) {
	//System.out.println("windowClosed " + e.toString());
    }

    public void windowClosing(WindowEvent e) {
	//System.out.println("windowClosing " + e.toString());
    }

    public void windowOpened(WindowEvent e) {
	//System.out.println("windowOpened " + e.toString());
    }

	public static int getKey() {
		return key;
	}

	public static void setKey(int key) {
		PacmanFrame.key = key;
	}

	public static int getTextheight() {
		return textheight;
	}

	public static void setTextheight(int textheight) {
		PacmanFrame.textheight = textheight;
	}

	public static int getTextwidth() {
		return textwidth;
	}

	public static void setTextwidth(int textwidth) {
		PacmanFrame.textwidth = textwidth;
	}

	public static boolean isRepaint() {
		return repaint;
	}

	public static void setRepaint(boolean repaint) {
		PacmanFrame.repaint = repaint;
	}

	public static int getUnitwidth() {
		return unitwidth;
	}

	public static void setUnitwidth(int unitwidth) {
		PacmanFrame.unitwidth = unitwidth;
	}

	public static int getUnitheight() {
		return unitheight;
	}

	public static int setUnitheight(int unitheight) {
		PacmanFrame.unitheight = unitheight;
		return unitheight;
	}

}
