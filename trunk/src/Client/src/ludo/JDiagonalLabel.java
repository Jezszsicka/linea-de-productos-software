package ludo;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class JDiagonalLabel extends JLabel {

	public JDiagonalLabel() {
		super();

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // paint background
		g.setColor(Color.black);
		g.drawLine(30, 0, 60, 30);
		g.drawLine(30 - 1, 0, 60 - 1, 30);
		ui.update(g, this);

	}
}
