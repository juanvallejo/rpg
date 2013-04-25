import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;
public class window extends JPanel implements ActionListener, KeyListener, constants
{
	private static final long serialVersionUID = 1L;
	hero player1 = null;
	private boolean moveLeft, moveRight, jump = false;
	private int jc, dc = 0;
	public window()
	{
		setBackground(Color.DARK_GRAY);
		addKeyListener(this);
		setFocusable(true);
		player1 = new hero();
		
		System.out.println("new window");
		Timer timer = new Timer(10, game);
		timer.start();		
	}
	
	
	ActionListener game = new ActionListener() {
	      public void actionPerformed(ActionEvent evt) {
	    	  if(moveRight)
	    		  player1.moveX(player1.dx);
	    	  
	    	  if(moveLeft)
	    		  player1.moveX(-player1.dx);
	    	  
	    	  if(jump)
	    	  {
	    		  jc++;
	    		  if(player1.up)
	    			  player1.moveY(-3);
	    		  
	    		  if(!player1.up)
	    		  {
	    			  player1.moveY(3);
	    			  dc++;
	    			  if(dc==10)
	    			  {
	    				  jump = false;
	    				  dc = 0;
	    			  }
	    		  }
	    		  if(jc==10)
	    		  {
	    			  player1.up = false;
	    			  jc = 0;
	    		  }
	    	  }
	    	  
	    	  repaint();
	      }
	  };
	
	
	public void paint(Graphics g)
	{
		Graphics2D g2d = ( Graphics2D ) g;
		super.paintComponent(g);
		g2d.setColor(Color.white);
		player1.paint(g);
		
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyChar()=='w')
		{
			if(!jump)
			{
				jump = true;
				player1.up = true;
			}
		}
		if(e.getKeyChar()=='a')
			moveLeft = true;
		
		if(e.getKeyChar()=='s')
			player1.up = false;
		
		if(e.getKeyChar()=='d')
			moveRight = true;
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			if(!jump)
			{
				jump = true;
				player1.up = true;
			}
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyChar()=='d')
			moveRight = false;
		if(e.getKeyChar()=='a')
			moveLeft = false;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}
	
}