package ooad.model.Shape;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class GeneralLine extends BasicLine {
	private int[] _trianglePointsOrg = new int[]{ 0, 5, 10, -5, 0 };
	private int[] _trianglePointsX = new int[5];
	private int[] _trianglePointsY = new int[5];

	@Override
	public void drawShape(Graphics g) {
		super.drawShape(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(3));
		g2.rotate(getAngle(), getEndX(), getEndY());
		configTrianglePoints(getEndX(), getEndY());
		g2.drawPolyline(_trianglePointsX, _trianglePointsY, 5);
		g2.rotate(-1 * getAngle(), getEndX(), getEndY());
	}
	
	private void configTrianglePoints(int x, int y) {
		_trianglePointsX[0] = (int)(Math.cos(getAngle()) * _trianglePointsOrg[0]);
		_trianglePointsX[1] = (int)(Math.sin(getAngle()) * _trianglePointsOrg[1]);
		_trianglePointsX[2] = (int)(Math.cos(getAngle()) * _trianglePointsOrg[2]);
		_trianglePointsX[3] = (int)(Math.sin(getAngle()) * _trianglePointsOrg[3]);
		_trianglePointsX[4] = (int)(Math.cos(getAngle()) * _trianglePointsOrg[4]);
		_trianglePointsY[0] = (int)(Math.sin(getAngle()) * _trianglePointsOrg[0]);
		_trianglePointsY[1] = (int)(Math.cos(getAngle()) * _trianglePointsOrg[1]);
		_trianglePointsY[2] = (int)(Math.sin(getAngle()) * _trianglePointsOrg[2]);
		_trianglePointsY[3] = (int)(Math.cos(getAngle()) * _trianglePointsOrg[3]);
		_trianglePointsY[4] = (int)(Math.sin(getAngle()) * _trianglePointsOrg[4]);
		for(int i = 0;i < _trianglePointsX.length; i++) {
			_trianglePointsX[i] += getEndX();
			_trianglePointsY[i] += getEndY();
		}
	}
}
