package ooad.model.shape;

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
	private int _mouseEndX;
	private int _mouseEndY;
	
	public BasicLine(){
		_direction = Direction.VERTICAL;
		_isLine = true;
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
	public void setMouseEndXY(int x, int y) {
		_mouseEndX = x;
		_mouseEndY = y;
	}

	@Override
	public int getMouseEndX() {
		return _mouseEndX;
	}

	@Override
	public int getMouseEndY() {
		return _mouseEndY;
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
		setDifX(getMouseEndX() - getStartX());
		setDifY(getMouseEndY() - getStartY());
		setAngle(getDifX(), getDifY());
		_distance = getDistance(getMouseEndX(), getMouseEndY(), getStartX(), getStartY());
		setEndX(getStartX() + (int)_distance);
		setEndY(getStartY());
	}

	@Override
	public void setSelected(boolean isSelect) {
	}

	@Override
	public void setLineStartPos(IShape line) {
	}

	@Override
	public void setLineEndPos(IShape line) {
	}

	@Override
	public void isLineEnclose(IShape line, int mouseLineX, int mouseLineY,
			int closeOffset) {
	}

	@Override
	public boolean isLineEnclose(int mouseLineX, int mouseLineY, int closeOffset) {
		return false;
	}

	@Override
	public void movePos(int difX, int difY) {
	}

	@Override
	public boolean isGrouped() {
		return false;
	}
}

enum Direction{
	VERTICAL,
	HORIZONTAL
}
