package ooad.model.Shape;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

import ooad.model.IPaintObserver;

public abstract class BasicLine extends AbstractShape implements IBasicLine{
	private int _offset = 10;
	protected double _distance;
	protected Direction _direction;
	protected int _difX, _difY;
	protected double _angle;
	
	public BasicLine(){
		_direction = Direction.VERTICAL;
	}
	
	@Override
	public void drawShape(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(5));
		g2.rotate(getAngle(), getStartX(), getStartY());
		g2.drawLine(getStartX(), getStartY(), getEndX(), getEndY());
		g2.setStroke(new BasicStroke(1));
		g2.rotate(-1 * getAngle(), getStartX(), getStartY());
	}
	
	@Override
	public void setMiddle() {
		setDifX(_startX - _endX);
		setDifY(_startY - _endY);
		int absDifX = Math.abs(getDifX());
		int absDifY = Math.abs(getDifY());
	}
	
	@Override
	public void setDirection(Direction direction){
		_direction = direction;
	}
	
	@Override
	public Direction getDirection(){
		return _direction;
	}
	
	@Override
	public void setDifX(int difX){
		_difX = difX;
	}
	
	@Override
	public void setDifY(int difY){
		_difY = difY;
	}
	
	@Override
	public int getDifX(){
		return _difX;
	}
	
	@Override
	public int getDifY(){
		return _difY;
	}

	@Override
	public void setAngle(double angle) {
		_angle = angle;
	}

	@Override
	public void setAngle(int difX, int difY) {
		_angle = Math.atan2(difY, difX);
	}

	@Override
	public double getAngle() {
		return _angle;
	}

	@Override
	public void setEnd(int endX, int endY) {
		setDifX(endX - getStartX());
		setDifY(endY - getStartY());
		setAngle(getDifX(), getDifY());
		_distance = getDistance(endX, endY, getStartX(), getStartY());
		setEndX(getStartX() + (int)_distance);
		setEndY(getStartY());
	}

	@Override
	public void setSelected(boolean isSelect) {
	}
}

enum Direction{
	VERTICAL,
	HORIZONTAL
}
