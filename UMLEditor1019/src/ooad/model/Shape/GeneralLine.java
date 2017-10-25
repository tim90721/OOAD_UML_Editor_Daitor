package ooad.model.Shape;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class GeneralLine extends BasicLine {
	private int[] _trianglePointsOrgX = new int[]{ 0, 0, 10, 0, 0 };
	private int[] _trianglePointsOrgY = new int[]{ 0, 5, 0, -5, 0 };
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
	
	private void configTrianglePoints(int x, int y){
		resetTrianglePoints();
		for(int i = 0; i < _trianglePointsX.length;	i++)
			_trianglePointsX[i] = (int)(Math.pow(Math.cos(getAngle()), 2) * (double)_trianglePointsOrgX[i])
			+ (int)(Math.pow(Math.sin(getAngle()), 2) * (double)_trianglePointsOrgX[i])
			+ getEndX();
		for(int i = 0; i < _trianglePointsY.length; i++)
			_trianglePointsY[i] = (int)(Math.pow(Math.cos(getAngle()), 2) * (double)_trianglePointsOrgY[i]) 
			+ (int)(Math.pow(Math.sin(getAngle()), 2) * (double)_trianglePointsOrgY[i]) 
			+ getEndY();
	}
	
	private void resetTrianglePoints(){
		for(int i = 0;i < _trianglePointsOrgX.length; i++){
			_trianglePointsX[i] = _trianglePointsOrgX[i];
			_trianglePointsY[i] = _trianglePointsOrgY[i];
		}
	}
}
