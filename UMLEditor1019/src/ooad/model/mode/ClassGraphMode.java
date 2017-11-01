package ooad.model.mode;

import java.util.ArrayList;

import ooad.model.DrawMode;
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
	public void addShapeString(IStringField stringField, String name) {
		ArrayList<IShape> shapes = _model.getStoreShapes();
		AbstractAreaShape classGraph = (AbstractAreaShape)shapes.get(shapes.size() - 1);
		classGraph.addShapeString(stringField, name);
		System.out.println(stringField.getStartX());
		shapes.remove(classGraph);
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
		_model.setDrawMode(DrawMode.CLASS_MODE);
	}
}
