package ooad.model.Shape;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class ClassGraph extends AbstractShape{

	public ClassGraph() {
		setEndX(getStartX() + 60);
		setEndY(getStartY() + 100);
		setMiddleX(getStartX() + (getEndX() - getStartX()) / 2);
		setMiddleY(getStartY() + (getEndY() - getStartY()) / 2);
	}
	
	@Override
	public void drawShape(Graphics g){
		super.drawShape(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(3));
		g2.drawRect(getStartX(), getStartY(), 60, 100);
	}
}
