package ooad.model.Shape;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class UseCaseShape extends AbstractAreaShape{

	public UseCaseShape() {
		setWidth(100);
		setHeight(60);
	}
	
	@Override
	public void drawShape(Graphics g) {
		super.drawShape(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(3));
		g2.drawOval(getStartX(), getStartY(), getWidth(), getHeight());
		g2.setStroke(new BasicStroke(1));
	}
}
