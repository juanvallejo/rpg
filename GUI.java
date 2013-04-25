import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class GUI extends JFrame implements constants
{
	private static final long serialVersionUID = 1L;
	public static void main(String args[])
	{
		new GUI();
	}
	
	public GUI()
	{
		new JFrame("Testing");
		setSize(constants.HEIGHT, constants.WIDTH);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((d.width-500)/2, (d.height-450)/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		window w = new window();
		getContentPane().add(w);
		
		setVisible(true);
	}
}