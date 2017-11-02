package ooad.model.mode;

import java.awt.Graphics;
import java.util.ArrayList;

import ooad.model.DrawMode;
import ooad.model.IModel;
import ooad.model.shape.AbstractAreaShape;
import ooad.model.shape.IShape;
import ooad.model.shape.IStringField;
import ooad.model.shape.StringField;

public class UseCaseMode extends AbstractMode{

	public UseCaseMode(IModel model) {
		super(model);
	}

	@Override
	public void addShapeString(IStringField stringField, String name) {
		ArrayList<IShape> shapes = _model.getStoreShapes();
		AbstractAreaShape useCase = (AbstractAreaShape)shapes.get(shapes.size() - 1);
		useCase.addShapeString(stringField, name);
		shapes.remove(useCase);
		shapes.add(stringField);
		_model.notifyPaintChange();
	}

	@Override
	public void setCoordinate(IShape shape, int mouseX, int mouseY) {
		super.setCoordinate(shape, mouseX, mouseY);
		if(_model.isMouseDragging())
			shape.setStart(mouseX, mouseY);
	}

	@Override
	public void setMode() {
		_model.setDrawMode(DrawMode.USECASE_MODE);
	}
}
