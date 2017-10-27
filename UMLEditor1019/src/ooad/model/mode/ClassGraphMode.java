package ooad.model.mode;

import java.awt.Graphics;
import java.util.ArrayList;

import ooad.model.IModel;
import ooad.model.Shape.AbstractAreaShape;
import ooad.model.Shape.IShape;
import ooad.model.Shape.IStringField;
import ooad.model.Shape.StringField;

public class ClassGraphMode extends AbstractMode{
	
	public ClassGraphMode(IModel model) {
		super(model);
	}

	@Override
	public void draw(Graphics g) {
	}

	@Override
	public void addShapeString(IShape shape, String name) {
		ArrayList<IShape> shapes = _model.getStoreShapes();
		IStringField stringField = new StringField((AbstractAreaShape)shape, name);
		stringField.setStart(shape.getStartX() + stringField.getFontSize(),
				shape.getStartY() + stringField.getFontSize());
		shapes.remove(shape);
		shapes.add(stringField);
		_model.notifyPaintChange();
	}

	@Override
	public void setCoordinate(IShape shape, int mouseX, int mouseY) {
		super.setCoordinate(shape, mouseX, mouseY);
		if(_model.isMouseDragging())
			shape.setStart(mouseX, mouseY);
	}
}
