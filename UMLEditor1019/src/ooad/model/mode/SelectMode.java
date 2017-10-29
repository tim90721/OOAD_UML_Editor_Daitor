package ooad.model.mode;

import java.awt.Graphics;

import ooad.model.IModel;
import ooad.model.Shape.IShape;
import ooad.model.Shape.SelectShape;

public class SelectMode extends AbstractMode{
	private int _startX;
	private int _startY;
	private int _endX;
	private int _endY;
	
	public SelectMode(IModel model) {
		super(model);
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void storeShape(IShape shape) {
	}

	@Override
	public void checkIsSelect(IShape selectArea) {
		super.checkIsSelect(selectArea);
		if(_model.isMouseDragging()) {
			configCoordinate(selectArea);
			for (IShape shape : _model.getStoreShapes())
				if (shape.getStartX() > _startX
						&& shape.getStartY() > _startY 
						&& shape.getEndX() < _endX
						&& shape.getEndY() < _endY)
					shape.setSelected(true);
		}
		else {
			for (IShape shape : _model.getStoreShapes()) {
				if(shape.getStartX() < selectArea.getStartX()
						&& shape.getEndX() > selectArea.getStartX()
						&& shape.getStartY() < selectArea.getStartY()
						&& shape.getEndY() > selectArea.getStartY())
					shape.setSelected(true);
			}
		}
	}

	private void configCoordinate(IShape selectArea){
		_startX = selectArea.getStartX();
		_startY = selectArea.getStartY();
		int selectStartX = _startX;
		int selectStartY = _startY;
		_endX = selectArea.getEndX();
		_endY = selectArea.getEndY();
		int temp;
		if(_startX > _endX){
			temp = _endX;
			_endX = selectStartX;
			selectStartX = temp;
		}
		if(_startY > _endY){
			temp = _endY;
			_endY = selectStartY;
			selectStartY = temp;
		}
		_startX = selectStartX;
		_startY = selectStartY;
	}
	
	@Override
	public void isLineEnclose(IShape line, int mouseX, int mouseY, int closeOffset) {
		super.isLineEnclose(line, mouseX, mouseY, closeOffset);
	}

	@Override
	public void addShapeString(IShape shape, String name) {
	}

	@Override
	public void setCoordinate(IShape shape, int mouseX, int mouseY) {
		super.setCoordinate(shape, mouseX, mouseY);
		if(_model.isMouseDragging())
			shape.setEnd(mouseX, mouseY);
	}
	
}
