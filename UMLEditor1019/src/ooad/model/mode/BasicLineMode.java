package ooad.model.mode;

import ooad.model.DrawMode;
import ooad.model.IModel;
import ooad.model.Shape.IShape;

public abstract class BasicLineMode extends AbstractMode {

	public BasicLineMode(IModel model) {
		super(model);
	}

	@Override
	public void isLineEnclose(IShape line, int mouseX, int mouseY,
			int closeOffset) {
		super.isLineEnclose(line, mouseX, mouseY, closeOffset);
		for (IShape shape : _model.getStoreShapes())
			if (_model.isMouseDragging())
				shape.isLineEnclose(line, mouseX, mouseY, closeOffset);
			else if (!_model.isMouseDragging() && _model.isMousePressed()) {
				boolean isClose = false;
				isClose = shape.isLineEnclose(mouseX, mouseY, closeOffset);
				if (isClose) {
					line.setCoordinate(mouseX, mouseY, mouseX, mouseY);
					shape.setLineStartPos(line);
				} 
				else if(!isClose && !shape.isLine()){
					_model.newShape(DrawMode.NONE);
					System.out.println("not");
				}
			} else
				shape.isLineEnclose(mouseX, mouseY, closeOffset);
	}

	@Override
	public void setCoordinate(IShape shape, int mouseX, int mouseY) {
		super.setCoordinate(shape, mouseX, mouseY);
		if (_model.isMouseDragging())
			shape.setEnd(mouseX, mouseY);
	}

	@Override
	public void addShapeString(IShape shape, String name) {
	}
}
