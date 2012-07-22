package ludo;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;

public class JVertLabel extends JLabel{
	  private String text;

	  public JVertLabel(String s){
	    text = s;
	  }

	  public void paintComponent(Graphics g){
	    super.paintComponent(g);
	    Graphics2D g2d = (Graphics2D)g;

	    g2d.rotate(Math.toRadians(270.0)); 
	    g2d.drawString(text, 0, 0);
	  }
	}