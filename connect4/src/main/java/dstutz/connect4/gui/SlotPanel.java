package dstutz.connect4.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

public class SlotPanel extends JPanel {
	private Ellipse2D.Double circle;

	public SlotPanel(double padding, double circleDiameter) {
		int panelX = (int) (2 * padding + circleDiameter);
		this.setSize(panelX, panelX);
		this.circle = new Ellipse2D.Double(padding, padding, circleDiameter,
				circleDiameter);
		this.setForeground(Color.WHITE);
		this.setBackground(Color.BLUE);
	}

	public void paintComponent(Graphics g) {
		clear(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.fill(circle);
	}

	// super.paintComponent clears offscreen pixmap,
	// since we're using double buffering by default.
	protected void clear(Graphics g) {
		super.paintComponent(g);
	}

	protected Ellipse2D.Double getCircle() {
		return (circle);
	}
}