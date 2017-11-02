package ooad.model.mode;

import java.awt.Graphics;

import ooad.model.shape.IShape;
import ooad.model.shape.IStringField;
import ooad.model.shape.NoneShape;

public class NoneMode implements IMode{

	@Override
	public void drawing(Graphics g, IShape shape, int mouseX, int mouseY,
			int closeOffset) {
	}

	@Override
	public void storeShape(IShape shape) {
	}

	@Override
	public void setCoordinate(IShape shape, int x, int y) {
	}

	@Override
	public boolean checkIsSelect(IShape selectArea) {
		return false;
	}

	@Override
	public void isLineEnclose(IShape line, int mouseX, int mouseY,
			int closeOffset) {
	}

	@Override
	public void addShapeString(IStringField stringField, String name) {
	}

	@Override
	public void setMode() {
	}

	@Override
	public boolean moveSelectShape(int mouseX, int mouseY) {
		// TODO Auto-generated method stub
		return false;
	}
}
