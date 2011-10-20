package roart.pacman.game;

public class Argument {

    static String args[];	//pointer to argument strings
    
    public Argument(String s[]) {	//initializes;
	args=s;
    }

    public static boolean find(String s) {
	if (args == null) {
	    return false;
	}
	for (int i = 0; i < args.length; i++) {
	    if (args[0].equals(s)) {
		return true;
	    }
	}
	return false;
    }

}
