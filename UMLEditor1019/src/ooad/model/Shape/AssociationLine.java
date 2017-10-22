package ooad.model.Shape;

import java.awt.Graphics;

public class AssociationLine extends AbstractShape{

	@Override
	public void drawShape(Graphics g) {
		g.drawLine(getStartX(), getStartY(), getEndX(), getEndY());
	}
}
