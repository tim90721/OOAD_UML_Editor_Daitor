package ooad.model.Shape;

import java.awt.Graphics;

public abstract class AbstractAreaShape extends AbstractShape implements IAreaShape{
	protected int _widthOffset;
	protected int _heightOffset;
	
	public void setWidth(int width){
		_widthOffset = width;
	}
	
	public void setHeight(int height){
		_heightOffset = height;
	}
	
	public int getWidth(){
		return _widthOffset;
	}
	
	public int getHeight(){
		return _heightOffset;
	}

	@Override
	public void setStartX(int x) {
		super.setStartX(x);
		setEndX(getStartX() + _widthOffset);
		setMiddleX(getStartX() + (getEndX() - getStartX()) / 2);
	}

	@Override
	public void setStartY(int y) {
		super.setStartY(y);
		setEndY(getStartY() + _heightOffset);
		setMiddleY(getStartY() + (getEndY() - getStartY()) / 2);
	}

	@Override
	public void setCoordinate(int startX, int startY, int endX, int endY) {
		super.setCoordinate(startX, startY, startX + _widthOffset, startY + _heightOffset);
		setMiddleX(getStartX() + (getEndX() - getStartX()) / 2);
		setMiddleY(getStartY() + (getEndY() - getStartY()) / 2);
	}
}
