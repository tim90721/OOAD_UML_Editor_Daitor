package ooad.model;

import java.awt.Graphics;

import ooad.model.Shape.IShape;

public interface IModel {
	void draw(Graphics g);
	void registerPaintObserver(IObserver observer);
	void unregisterPaintObserver(IObserver observer);
	void notifyPaintChange();
	void setMouseXY(int x, int y);
	int getMouseX();
	int getMouseY();
	void setMousePressed(boolean isPressed);
	boolean isMousePressed();
	void setMouseDragging(boolean isDragging);
	boolean isMouseDragging();
	void setState(DrawMode mode);
	DrawMode getState();
	void newShape();
	void storeShape(IShape shape);
	void setCoordinate(IShape shape, int x, int y);
	void checkIsSelect(IShape selectArea);
	void checkIsLineEnclose(IShape line);
}
