package ooad.model.Shape;

import java.awt.Graphics;
import java.awt.Graphics2D;

public abstract class AbstractShape implements IShape{
	int _depth;
	protected int _startX, _startY;
	protected int _endX, _endY;
	private int _middelX, _middelY;
	private boolean _isSelected = false;
	private int _selectRectwidth = 10;
	
	@Override
	public void setSelected(boolean isSelect) {
		_isSelected = isSelect;
	}

	@Override
	public boolean isSelected() {
		return _isSelected;
	}

	@Override
	public void setStartX(int x) {
		_startX = x;
	}

	@Override
	public void setEndX(int x) {
		_endX = x;
	}

	@Override
	public void setStartY(int y) {
		_startY = y;
	}

	@Override
	public void setEndY(int y) {
		_endY = y;
	}

	@Override
	public int getStartX() {
		return _startX;
	}

	@Override
	public int getEndX() {
		return _endX;
	}

	@Override
	public int getStartY() {
		return _startY;
	}

	@Override
	public int getEndY() {
		return _endY;
	}

	@Override
	public void setMiddleX(int x) {
		_middelX = x;
	}

	@Override
	public void setMiddleY(int y) {
		_middelY = y;
	}

	@Override
	public int getMiddleX() {
		return _middelX;
	}

	@Override
	public int getMiddleY() {
		return _middelY;
	}

	@Override
	public void setCoordinate(int startX, int startY, int endX, int endY) {
		setStartX(startX);
		setStartY(startY);
		setEndX(endX);
		setEndY(endY);
	}
	
	@Override
	public void drawShape(Graphics g) {
		if(isSelected()){
			g.drawRect(getMiddleX() - _selectRectwidth / 2, getStartY() - _selectRectwidth, _selectRectwidth, _selectRectwidth);
			g.drawRect(getMiddleX() - _selectRectwidth / 2, getEndY(), _selectRectwidth, _selectRectwidth);
			g.drawRect(getStartX() - _selectRectwidth, getMiddleY() - _selectRectwidth / 2, _selectRectwidth, _selectRectwidth);
			g.drawRect(getEndX(), getMiddleY() - _selectRectwidth / 2, _selectRectwidth, _selectRectwidth);
		}
	}
}
