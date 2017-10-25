package ooad.model.Shape;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class CompositionLine extends BasicLine {
	private int[] _diamondOrgPointX = new int[] { 0, 10, 20, 10, 0 };
	private int[] _diamondOrgPointY = new int[] { 0, 10, 0, -10, 0 };
	private int[] _diamondPointX = new int[5];
	private int[] _diamondPointY = new int[5];

	@Override
	public void drawShape(Graphics g) {
		super.drawShape(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(3));
		g2.rotate(-1 * getAngle(), getEndX(), getEndY());
		configTrianglePoints(getEndX(), getEndY());
		g2.drawPolyline(_diamondPointX, _diamondPointY, 5);
		g2.rotate(getAngle(), getEndX(), getEndY());
		g2.setStroke(new BasicStroke(1));
	}

	private void configTrianglePoints(int x, int y) {
		for (int i = 0; i < _diamondPointX.length; i++) {
			_diamondPointX[i] = getEndX() + _diamondOrgPointX[i];
			_diamondPointY[i] = getEndY() - _diamondOrgPointY[i];
		}
	}
}
