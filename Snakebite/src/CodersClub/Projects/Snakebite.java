package CodersClub.Projects;

import java.awt.*;
import java.util.*;
import java.net.*;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Snakebite extends JFrame
{
    private Image image;
    
	public static void main(String[] args) 
	{
		new Snakebite();
		
	}
	
	public Snakebite()
	{
		super("Snakebite Game");
		setSize(1000,800);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit tk = Toolkit.getDefaultToolkit();
		image = tk.getImage(getURL("griffin_logo_noBG.png"));
	}
	
	private URL getURL(String filename)
	{
		URL url = null;
		try {
			url = this.getClass().getResource(filename);
		}
		catch (Exception e) {}
		return url;
	}

	public void paint(Graphics g)
	{
		Graphics2D  g2d = (Graphics2D) g;
		g2d.setColor(Color.black);
		g2d.fillRect(0, 0, getSize().width, getSize().height);
		
		g2d.drawImage(image, 0, 40, this);
		
	}
}
