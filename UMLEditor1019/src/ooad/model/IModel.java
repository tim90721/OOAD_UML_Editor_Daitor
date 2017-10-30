package ooad.model;

import java.awt.Graphics;
import java.util.ArrayList;

import ooad.model.Shape.IShape;
import ooad.model.mode.IMode;

public interface IModel {
	void draw(Graphics g);
	void registerPaintObserver(IPaintObserver observer);
	void unregisterPaintObserver(IPaintObserver observer);
	void notifyPaintChange();
	void setMouseXY(int x, int y);
	int getMouseX();
	int getMouseY();
	void setMousePressed(boolean isPressed);
	boolean isMousePressed();
	void setMouseDragging(boolean isDragging);
	boolean isMouseDragging();
	void setMouseMoving(boolean isMoving);
	boolean isMouseMoving();
	void setDrawMode(DrawMode mode);
	DrawMode getDrawMode();
	void refreshShapeState();
	void newShape();
	void newShape(DrawMode mode);
	void storeShape(IShape shape);
	void setShapeSelectStatus(boolean selected);
	void addShapeString(String name);
	ArrayList<IShape> getStoreShapes();
	void setUserMode(DrawMode mode);
	void checkMouseEnclose(int mouseX, int mouseY);
}
