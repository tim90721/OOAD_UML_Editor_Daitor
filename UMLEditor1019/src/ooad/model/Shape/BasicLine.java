package ooad.model.Shape;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class BasicLine extends AbstractShape{
	private int _offset = 10;
	private Direction _direction;
	
	public BasicLine(){
		_direction = Direction.VERTICAL;
	}
	
	@Override
	public void drawShape(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(5));
		g2.drawLine(getStartX(), getStartY(), getEndX(), getEndY());
	}
	
	protected void setMiddle() {
		int difX = _startX - _endX;
		int difY = _startY - _endY;
		int absDifX = getABSValue(difX);
		int absDifY = getABSValue(difY);
	}
	
	private int getABSValue(int input){
		if(input < 0)
			return -input;
		else
			return input;
	}
	
	public void setDirection(Direction direction){
		_direction = direction;
	}
	
	public Direction getDirection(Direction direction){
		return _direction;
	}
}

enum Direction{
	VERTICAL,
	HORIZONTAL
}
