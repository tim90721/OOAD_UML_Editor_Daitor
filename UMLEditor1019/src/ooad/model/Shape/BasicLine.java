package ooad.model.Shape;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class BasicLine extends AbstractShape{
	
	@Override
	public void drawShape(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(5));
		g2.drawLine(getStartX(), getStartY(), getEndX(), getEndY());
	}
}
