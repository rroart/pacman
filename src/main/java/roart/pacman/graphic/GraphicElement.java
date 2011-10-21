package roart.pacman.graphic;

import roart.pacman.game.UserInterface;
import roart.pacman.game.Colour;
import roart.pacman.game.PacmanFrame;

import java.awt.*;
import java.awt.image.*;

public abstract class GraphicElement {
    private BufferedImage pixmap; 			//this is the pixmap
    //    public /*protected*/ static   BufferedImage img;
    
    public BufferedImage get() {
	return getPixmap();
    }
 
    public void draw(Point p) {	//draw graphical element
	//int factor = 8;
	//System.out.print("d");
	//XCopyArea(display,pixmap,window,gc,0,0,UNITWIDTH,UNITHEIGHT,TEXTSPACE+UNITWIDTH*x,UNITWIDTH*y);				//copy pixmap to window
	BufferedImage img = getPixmap();
	//Frame frame = new Frame();

	Frame frame = roart.pacman.game.PacmanFrame.instance();
	Graphics2D g = (Graphics2D) frame.getGraphics(); //img.createGraphics();
	//roart.pacman.game.PacmanFrame.img = img;
	//boolean succ = g.drawImage(img, 0, 0, Color.BLACK, null);
	//System.out.print(" " + p.getX() + " " + p.getY());
	g.drawImage(img, Constants.I32 + PacmanFrame.getTextwidth()*Constants.I20+PacmanFrame.getUnitwidth()*((int)p.getX()), Constants.I32+PacmanFrame.getUnitheight()*((int)p.getY()), PacmanFrame.getUnitwidth(), PacmanFrame.getUnitheight(), frame);
	//frame.paint(g);
	//System.out.println("success " + succ + " img " + img.toString()/* + " data " + img.getData()*/);
	//frame.update(g);
	//frame.show();
	//Graphics2D g2 = (Graphics2D) g; //frame.getGraphics(); //img.createGraphics();

	//Canvas canvas = new Canvas();
	//canvas.setSize(100,100);
	//      canvas.setBackground(Color.WHITE);
	// frame.add(canvas/*jsc*/);
	// frame.add(new Button("Grr"));
	// frame.show();
	//  canvas.paint(g2);
	//  canvas.show();
	//     g.setColor(Color.CYAN);
	//     g.drawLine(0,0,200,200);
	//     g.drawRect(20,20,40,40);
	//     g.drawString("Bla",40,40);
	//try {
	    //Thread.sleep(4000);
	    //} catch (Exception e) {
	    //}
	//System.out.println("sleep 0");
	//frame.setVisible(false);
	//try {
	    //Thread.sleep(4000);
	    //} catch (Exception e) {
	    //}
	//System.out.println("sleep 1");
	//frame.setVisible(true);
	//canvas.paint(g2);
	//frame.add(g);
	//frame.show();
	//System.out.println("draw");
	//try {
	//    Thread.sleep(4000);
	//} catch (Exception e) {
	//}
    }

    void consfn() {		//function to help with constructing
	UserInterface.instance();	//get UserInterface instance
	//display=u->getdisplay();		//get pointer to display connection
	//window=u->getwindow();			//get window
	//screen=u->getscreen();			//get screen
	//gc=u->getgc();				//get graphic context
	//int wx,wy;				//dummies
	//Window root;				//dummy
	//unsigned int wwidth,wheight,wdepth,wborder,width,height,status;
	//dummies, except wdepth
	//XGetGeometry(display,window,&root,&wx,&wy,&wwidth,&wheight,
	//  &wborder,&wdepth);			//get X data
	//depth=wdepth;				//setting depth
    }

    //create pixmap
    public BufferedImage pix(byte[] map, Colour colour, Colour back) {
	//*p=XCreatePixmapFromBitmapData(display,window,map,UNITWIDTH,UNITHEIGHT,
	//			   myforeground,mybackground,depth);
	//System.out.println("maplen " + map.length);
	DataBufferByte databuffer = new DataBufferByte(map, map.length);
	//System.out.println("databuffer " + databuffer.getNumBanks() + " off " + databuffer.getOffsets().length+" "+databuffer.getSize());
	// or: int[] bm=new int[]{0xff0000,0xff00,0xff,0xff000000};
	// or: SampleModel samplemodel = new SinglePixelPackedSampleModel(databuffer.getDataType(), 8, 8, 1, bm);
	//SampleModel samplemodel = new MultiPixelPackedSampleModel(databuffer.getDataType(), 8, 8, 1);
	ColorModel colorModel = colour.get();
	//System.out.println("colormodel " + colorModel);
	WritableRaster raster = Raster.createPackedRaster(databuffer, Constants.I8, Constants.I8, 1, null);
	// or: raster = Raster.createWritableRaster (samplemodel, databuffer, null);
	//System.out.println("raster " + raster.getWidth() + " " + raster.getHeight() + " " + raster.getNumBands() + " " + raster.getNumDataElements()+ " " + raster.getBounds() + " " + ((byte[])raster.getDataElements(0,0, null)).length);
	BufferedImage bufferedimage = new BufferedImage(colorModel, (WritableRaster)raster, false, null);
	setPixmap(bufferedimage);
	return bufferedimage;
    }

	public BufferedImage getPixmap() {
		return pixmap;
	}

	public void setPixmap(BufferedImage pixmap) {
		this.pixmap = pixmap;
	}

};
