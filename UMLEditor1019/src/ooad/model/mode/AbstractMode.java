package ooad.model.mode;

import java.awt.Graphics;

import ooad.model.DrawMode;
import ooad.model.IModel;
import ooad.model.Model;
import ooad.model.Shape.IShape;

public abstract class AbstractMode implements IMode{
	protected IModel _model;
	protected boolean _hasSelectShape;
	
	public AbstractMode(IModel model) {
		this._model = model;
		_hasSelectShape = false;
	}
	
	@Override
	public void storeShape(IShape shape) {
//		if(_model.getDrawMode() != DrawMode.NONE)
		if(shape.getShapeName() != "None")
			_model.storeShape(shape);
	}

	@Override
	public boolean checkIsSelect(IShape selectArea) {
		setShapesSelected(false);
		return false;
	}

	@Override
	public void isLineEnclose(IShape line, int mouseX, int mouseY, int closeOffset) {
		if(!_model.isMouseMoving())
			setShapesSelected(false);
	}
	
	@Override
	public void setCoordinate(IShape shape, int mouseX, int mouseY) {
		if(!_model.isMouseDragging())
			shape.setCoordinate(mouseX, mouseY, mouseX, mouseY);
	}
	
	private void setShapesSelected(boolean select){
		for (IShape shape : _model.getStoreShapes())
			shape.setSelected(false);
	}

	@Override
	public void drawing(Graphics g, IShape shape, int mouseX, int mouseY,
			int closeOffset) {
		setCoordinate(shape, mouseX, mouseY);
		isLineEnclose(shape, mouseX, mouseY, closeOffset);
		if (_model.isMousePressed())
			shape.drawShape(g);
		if (!_model.isMousePressed() && !_model.isMouseMoving()) {
			System.out.println("111");
			_hasSelectShape = checkIsSelect(shape);
			storeShape(shape);
			_model.setMouseDragging(false);
		}
		if(_model.isMouseMoving()){
			
		}
	}

	@Override
	public boolean moveSelectShape(int mouseX, int mouseY) {
		return false;
	}
	
}
