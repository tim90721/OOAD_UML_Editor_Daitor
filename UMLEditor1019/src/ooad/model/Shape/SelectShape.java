package ooad.model.Shape;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class SelectShape extends AbstractShape{
	private int _selectStartX, _selectStartY;
	
	@Override
	public void drawShape(Graphics g) {
		configCoordinate();
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(1));
		g2.drawRect(_selectStartX, _selectStartY, getEndX() - _selectStartX,
				getEndY() - _selectStartY);
	}
	
	public int getSelectStartX(){
		return _selectStartX;
	}
	
	public int getSelectStartY(){
		return _selectStartY;
	}
	
	private void configCoordinate(){
		_selectStartX = _startX;
		_selectStartY = _startY;
		int temp;
		if(_startX > _endX){
			temp = _endX;
			_endX = _selectStartX;
			_selectStartX = temp;
		}
		if(_startY > _endY){
			temp = _endY;
			_endY = _selectStartY;
			_selectStartY = temp;
		}
	}

	@Override
	public void setLineStartPos(IShape line) {
	}

	@Override
	public void setLineEndPos(IShape line) {
	}
}
