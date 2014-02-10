package CodersClub.Projects;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import java.io.InterruptedIOException;
import java.net.*;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Snakebite extends JFrame implements Runnable, KeyListener
{
    private Image image;
    private Image bgimage;
    
    private String bgImageFile = "NightHides.jpg";
  //  private String bgImageFile = "starfield.JPG";
    private String imageFile   = "griffin_logo_noBG.png";
    
    Thread gameloop;
    
    private int posX = 100;
    private int posY = 100;
    private int SCREENWIDTH = 1000;
    private int SCREENHEIGHT = 600;
    
    boolean showInfo = true;
    
    int imageWidth, imageHeight;
  
    
	public static void main(String[] args) 
	{
		new Snakebite();
		
	}
	
	public Snakebite()
	{
		super("Snakebite Game");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(SCREENWIDTH	, SCREENHEIGHT);		
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		image = tk.getImage(getURL(imageFile));
		bgimage = tk.getImage(getURL(bgImageFile));
        imageWidth = 175;
        imageHeight = 175;
	
		gameloop = new Thread(this);
	//	gameloop.start();
		
		addKeyListener(this);

		
	}
	
	private URL getURL(String filename)
	{
		URL url = null;
		try {
			url = this.getClass().getResource(filename);
		}
		catch (Exception e) {e.printStackTrace();}
		return url;
	}

	public void paint(Graphics g)
	{
		Graphics2D  g2d = (Graphics2D) g;  // cast to Graphics2D for versatility later

     //	g2d.setColor(Color.black);
     // g2d.fillRect(0, 0, getSize().width, getSize().height);  // for drawing a colored background

		g2d.drawImage(bgimage, 0, 0,  this);     // draw a background image
		g2d.drawImage(image, posX, posY, this);  // draw an image to move around
		
		// show information
		if (showInfo)
		{
			g2d.setColor(Color.green);
			g2d.drawString("The Background image is: " + getURL(bgImageFile) , 10, 40);
			g2d.drawString("The Background image is: " + getURL(imageFile)   , 10, 55);
			g2d.drawString("The image is located at: " + posX + "," + posY   , 10, 70);
			g2d.drawString("The image size is: " + imageWidth + "," +imageHeight   , 10, 85);
		}
	}

	@Override
	public void update(Graphics g)
	{

		paint(g);
	}
	
	@Override
	public void run() 
	{
		Thread t = Thread.currentThread();
		while(t==gameloop)
		{
			try {
				Thread.sleep(20);
			}
			catch (InterruptedException ie) {
				ie.printStackTrace();
			}
			
			repaint();
		}
		

	}

	@Override
	public void keyPressed(KeyEvent ke) 
	{
		switch(ke.getKeyCode())	
		{
		case KeyEvent.VK_UP:
			posY -= 5;
			if(posY < 0 - imageHeight) posY = SCREENHEIGHT;
			repaint();
			break;
		case KeyEvent.VK_DOWN:
			posY += 5;
			if(posY > SCREENHEIGHT) posY = 0 - imageHeight;
			repaint();
			break;
		case KeyEvent.VK_LEFT:
			posX -= 5;
			if(posX < 0 -imageWidth) posX = SCREENWIDTH;
			repaint();
			break;
		case KeyEvent.VK_RIGHT:
			posX += 5;
			if (posX > SCREENWIDTH) posX= 0 - imageWidth;
			repaint();
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
