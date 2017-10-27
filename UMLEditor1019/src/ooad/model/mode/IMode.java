package ooad.model.mode;

import java.awt.Graphics;

import ooad.model.Shape.IShape;

public interface IMode {
	void draw(Graphics g);
	void storeShape(IShape shape);
	void setCoordinate(IShape shape, int x, int y);
	void checkIsSelect(IShape selectArea);
	void isLineEnclose(IShape line, int mouseX, int mouseY, int closeOffset);
	void addShapeString(IShape shape, String name);
}
