package ooad.model.shape;

import java.awt.Graphics;
import java.awt.Graphics2D;

public abstract class AbstractShape implements IShape, IGroupable{
	int _depth;
	protected int _startX, _startY;
	protected int _endX, _endY;
	private int _middelX, _middelY;
	protected boolean _isSelected = false;
	protected int _selectRectwidth = 10;
	protected boolean _isLine = false;
	protected String _name;
	
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
	public void setStart(int startX, int startY) {
		setStartX(startX);
		setStartY(startY);
	}

	@Override
	public void setEnd(int endX, int endY) {
		setEndX(endX);
		setEndY(endY);
	}

	@Override
	public void setMiddle(int middleX, int middleY) {
		setMiddleX(middleX);
		setMiddleY(middleY);
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
			g.fillRect(getMiddleX() - _selectRectwidth / 2, getStartY() - _selectRectwidth, _selectRectwidth, _selectRectwidth);
			g.fillRect(getMiddleX() - _selectRectwidth / 2, getEndY(), _selectRectwidth, _selectRectwidth);
			g.fillRect(getStartX() - _selectRectwidth, getMiddleY() - _selectRectwidth / 2, _selectRectwidth, _selectRectwidth);
			g.fillRect(getEndX(), getMiddleY() - _selectRectwidth / 2, _selectRectwidth, _selectRectwidth);
		}
	}

	@Override
	public void isLineEnclose(IShape line, int mouseLineX, int mouseLineY, int closeOffset) {
		isLineEnclose(mouseLineX, mouseLineY, closeOffset);
	}
	
	@Override
	public boolean isLineEnclose(int mouseLineX, int mouseLineY, int closeOffset) {
		if((getStartX() - closeOffset) < mouseLineX && 
				getEndX() + closeOffset > mouseLineX &&
				getStartY() - closeOffset < mouseLineY &&
				getEndY() + closeOffset > mouseLineY){
			setSelected(true);
			return true;
		}
		else{
			setSelected(false);
			return false;
		}
	}

	@Override
	public double getDistance(int x1, int y1, int x2, int y2) {
		return Math.sqrt(Math.pow(x1 - x2, 2)
				+ Math.pow(y1 - y2, 2));
	}

	@Override
	public boolean isLine() {
		return _isLine;
	}

	@Override
	public String getShapeName() {
		return _name;
	}

	@Override
	public boolean equals(Object obj) {
		IShape shape = (IShape)obj;
		if(shape.getStartX() == getStartX()
				&& shape.getStartY() == getStartY()
				&& shape.getEndX() == getEndX()
				&& shape.getEndY() == getEndY()){
			return true;
		}
		return false;
	}

	@Override
	public boolean checkIsSelect(int x1, int y1, int x2, int y2) {
		return false;
	}

	@Override
	public boolean checkIsSelect(IShape selectArea) {
		return false;
	}

	@Override
	public void setDepth(int depth) {
		_depth = depth;
	}

	@Override
	public int getDepth() {
		return _depth;
	}
}
