package ooad.model.Shape;

import java.awt.Graphics;

public abstract class AbstractSelectableShape extends AbstractShape{
	private boolean _isSelected = false;
	private int _selectRectwidth = 10;
	
	public void setSelected(boolean isSelect) {
		_isSelected = isSelect;
	}

	public boolean isSelected() {
		return _isSelected;
	}

	@Override
	public void drawShape(Graphics g) {
		if(isSelected()){
			g.drawRect(getMiddleX() - _selectRectwidth, getStartY(), _selectRectwidth, _selectRectwidth);
			g.drawRect(getMiddleX() - _selectRectwidth, getEndY(), _selectRectwidth, _selectRectwidth);
			g.drawRect(getStartX(), getMiddleY() - _selectRectwidth / 2, _selectRectwidth, _selectRectwidth);
			g.drawRect(getEndX(), getMiddleY() - _selectRectwidth / 2, _selectRectwidth, _selectRectwidth);
		}
	}
}
