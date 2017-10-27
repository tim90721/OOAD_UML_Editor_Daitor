package ooad.model.mode;

import java.awt.Graphics;

import ooad.model.IModel;
import ooad.model.Shape.IShape;

public class SelectMode extends AbstractMode{
	
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
		int areaStartX = selectArea.getStartX();
		int areaStartY = selectArea.getStartY();
		int endX = selectArea.getEndX();
		int endY = selectArea.getEndY();
		for (IShape shape : _model.getStoreShapes())
			if (shape.getStartX() > areaStartX
					&& shape.getStartY() > areaStartY && shape.getEndX() < endX
					&& shape.getEndY() < endY)
				shape.setSelected(true);
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
