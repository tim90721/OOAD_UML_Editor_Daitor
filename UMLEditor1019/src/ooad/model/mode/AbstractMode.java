package ooad.model.mode;

import ooad.model.IModel;
import ooad.model.Shape.IShape;

public abstract class AbstractMode implements IMode{
	protected IModel _model;
	
	public AbstractMode(IModel model) {
		this._model = model;
	}
	
	@Override
	public void storeShape(IShape shape) {
		_model.storeShape(shape);
	}

	@Override
	public void checkIsSelect(IShape selectArea) {
		setShapesSelected(false);
	}

	@Override
	public void isLineEnclose(IShape line, int mouseX, int mouseY, int closeOffset) {
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
}
