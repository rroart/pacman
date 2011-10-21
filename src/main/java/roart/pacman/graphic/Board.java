package roart.pacman.graphic;

import roart.pacman.game.UserInterface;

public class Board {

    //pointers to the graphic elements

    private static roart.pacman.graphic.Blank blank;
    private static roart.pacman.graphic.VerticalWall vertical;
    private static roart.pacman.graphic.HorizontalWall horizontal;
    private static roart.pacman.graphic.Cross cross;
    private static roart.pacman.graphic.SpecialWall specwall;
    private static roart.pacman.graphic.Food food;
    private static roart.pacman.graphic.SuperFood superfood;
    private static roart.pacman.graphic.E0 e0;
    private static roart.pacman.graphic.E90 e90;
    private static roart.pacman.graphic.E180 e180;
    private static roart.pacman.graphic.E270 e270;
    private static roart.pacman.graphic.T0 t0;
    private static roart.pacman.graphic.T90 t90;
    private static roart.pacman.graphic.T180 t180;
    private static roart.pacman.graphic.T270 t270;
    private static roart.pacman.graphic.Corner1 corner1;
    private static roart.pacman.graphic.Corner2 corner2;
    private static roart.pacman.graphic.Corner3 corner3;
    private static roart.pacman.graphic.Corner4 corner4;

    //int eqpat(char [3][3],char[10]);	//equality with wildcard

    private static Board instance;

    public static Board instance() {//returns the pointer to the instance
	if (instance==null) {
	    instance=new Board();
	}
	return instance;
    }

    boolean eqpat(char[] pat,String en){	//equality with wildcard
	int i;
 	for(i=0;i<Constants.I9;i++)  {
 	    if (en.charAt(i)!='?') {
 		if (pat[i]!=en.charAt(i)) {
		    return false; 
		}
	    }
	}
	return true;
    }
 
    //in:board with coordinates, out: the belonging code for the graphic element
    public char pattern(String[][] brett1,int y,int x) {
	char t,u;  	//some temps
	char[] pat = new char[Constants.I9];	//to contain the pattern to be compared
	int i,j;   	//plain counters

	t=brett1[y][0].charAt(x);
	switch (t) {	//get the code for the Element

	    //if it is simple enough, it don't need translation, just return it
	case '_': case '.': case 'o': case' ': return t; /*break;*/}

	for(i=-1;i<=1;i++) { 	//traverse the elements around x,y
	    for(j=-1;j<=1;j++) {
		t='\0';//null
		if (i+x==-1 || i+x==roart.pacman.game.Sizes.BOARDWIDTH) {
		    t=' ';	//if x,y is on border
		}
		if (j+y==-1 || j+y==roart.pacman.game.Sizes.BOARDHEIGHT) {
		    t=' ';	//then space is what's beyond it
		}
		if (i+x==-1 || j+y==-1 || i+x==roart.pacman.game.Sizes.BOARDWIDTH || j+y==roart.pacman.game.Sizes.BOARDHEIGHT) {
		    u=' ';
		} else {
		    u=brett1[y+j][0].charAt(x+i);				//what's at x+i,y+j coordinates
		}
		if (u=='_') {
		    u='O';				//if u is a specialwall then 
		}
		//it is just a wall 

		switch (u) {					//if it's a food or superfood 
		    //(but not at x,y) it 
		    //counts as space
		case '.': case 'o': u=' '; break;
		} 
		//if (t=='\0') pat[j+1][i+1]=u; else pat[j+1][i+1]=t;
		if (t=='\0') {
			pat[Constants.I3*(j+1)+i+1]=u; 
		} else {
			pat[Constants.I3*(j+1)+i+1]=t;
		}
		//if if not beyond border then it is u else it is t, space
	    }
	    }

	if (eqpat(pat,"? ?OOO? ?")) { return '-'; }//check if patterns matches and return
	if (eqpat(pat,"?O? O ?O?")) { return '|'; }
	if (eqpat(pat,"  ? OO?O ")) { return 'n'; }
	if (eqpat(pat,"?  OO  O?")) { return 'b'; }
	if (eqpat(pat," O?OO ?  ")) { return 'v'; }
	if (eqpat(pat,"?O  OO  ?")) { return 'c'; }
	if (eqpat(pat,"    O ?O?")) { return 'e'; }
	if (eqpat(pat,"  ? OO  ?")) { return 's'; }
	if (eqpat(pat,"?  OO ?  ")) { return 'd'; }
	if (eqpat(pat,"?O? O    ")) { return 'x'; }
	if (eqpat(pat,"? ?OOO O ")) { return 't'; }
	if (eqpat(pat,"?O  OO?O ")) { return 'y'; }
	if (eqpat(pat," O OOO? ?")) { return 'u'; }
	if (eqpat(pat," O?OO  O?")) { return 'i'; }
	if (eqpat(pat," O OOO O ")) { return '+'; }
	roart.pacman.game.Pacman.pacwarning("pattern");			//give warning if not returned yet
	//pacwarning(pat);
	return '|';				//just to return something
    }

    public Board() {			//constructor 

	if (UserInterface.instance() == null) { roart.pacman.game.Pacman.pacexit("no userinterface"); }

	cross=new roart.pacman.graphic.Cross();			//make a lot of new graphical elements
	vertical=new roart.pacman.graphic.VerticalWall();
	horizontal=new roart.pacman.graphic.HorizontalWall();
	blank=new roart.pacman.graphic.Blank();
	food=new roart.pacman.graphic.Food();
	superfood=new roart.pacman.graphic.SuperFood();
	corner1=new roart.pacman.graphic.Corner1();
	corner2=new roart.pacman.graphic.Corner2();
	corner3=new roart.pacman.graphic.Corner3();
	corner4=new roart.pacman.graphic.Corner4();
	specwall=new roart.pacman.graphic.SpecialWall();
	e0=new roart.pacman.graphic.E0();
	e90=new roart.pacman.graphic.E90();
	e180=new roart.pacman.graphic.E180();
	e270=new roart.pacman.graphic.E270();
	t0=new roart.pacman.graphic.T0();
	t90=new roart.pacman.graphic.T90();
	t180=new roart.pacman.graphic.T180();
	t270=new roart.pacman.graphic.T270();
    }

    //translate element on board to graphic element depending on context
    public GraphicElement graphele(String[][] brett,int i,int j) {
	char t;   
	t=pattern(brett,j,i);
	return chartograph(t);
    }

    //translate element on board to graphic element depending on context
    public GraphicElement graphele(char c) {
	return chartograph(c);
    }


    public GraphicElement chartograph(char c) {	//return translated code
	GraphicElement g;
	switch (c) {
	case ' ':g = (roart.pacman.graphic.GraphicElement) blank; break;
	case '+':g = (roart.pacman.graphic.GraphicElement) cross; break;
	case '|':g = (roart.pacman.graphic.GraphicElement) vertical; break;
	case '-':g = (roart.pacman.graphic.GraphicElement) horizontal; break;
	case '.':g = (roart.pacman.graphic.GraphicElement) food; break;
	case 'o':g = (roart.pacman.graphic.GraphicElement) superfood; break;
	case '_':g = (roart.pacman.graphic.GraphicElement) specwall; break;
	case 'e':g = (roart.pacman.graphic.GraphicElement) e90; break;
	case 's':g = (roart.pacman.graphic.GraphicElement) e180; break;
	case 'd':g = (roart.pacman.graphic.GraphicElement) e0; break;
	case 'x':g = (roart.pacman.graphic.GraphicElement) e270; break;
	case 't':g = (roart.pacman.graphic.GraphicElement) t0; break;
	case 'y':g = (roart.pacman.graphic.GraphicElement) t90; break;
	case 'u':g = (roart.pacman.graphic.GraphicElement) t180; break;
	case 'i':g = (roart.pacman.graphic.GraphicElement) t270; break;
	case 'c':g = (roart.pacman.graphic.GraphicElement) corner1; break;
	case 'v':g = (roart.pacman.graphic.GraphicElement) corner2; break;
	case 'b':g = (roart.pacman.graphic.GraphicElement) corner3; break;
	case 'n':g = (roart.pacman.graphic.GraphicElement) corner4; break;
	default: { g = (roart.pacman.graphic.GraphicElement) blank; /*printf("error%d\n",c);*/} break;
	}
	return g;
    }


 
}
