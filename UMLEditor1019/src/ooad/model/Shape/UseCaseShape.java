package ooad.model.Shape;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class UseCaseShape extends AbstractAreaShape{

	public UseCaseShape() {
		setWidth(100);
		setHeight(60);
		_name = "UseCase";
	}
	
	@Override
	public void drawShape(Graphics g) {
		super.drawShape(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(3));
		g2.drawOval(getStartX(), getStartY(), getWidth(), getHeight());
		g2.setStroke(new BasicStroke(1));
	}
	
	/* (non-Javadoc)
	 * add string to shape
	 */
	@Override
	public void addShapeString(IStringField stringField, String name) {
		stringField.setStart(getStartX() + stringField.getFontSize(),
				getStartY() + (int)(1.8 * stringField.getFontSize()));
	}
}
