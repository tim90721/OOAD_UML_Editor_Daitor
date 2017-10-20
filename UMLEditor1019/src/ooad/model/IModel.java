package ooad.model;

import java.awt.Graphics;

public interface IModel {
	void draw(Graphics g);
	void registerObserver(IObserver observer);
	void unregisterObserver(IObserver observer);
	void notifyChange();
	void setMouseXY(int x, int y);
	int getMouseX();
	int getMouseY();
	void setMousePressed(boolean isPressed);
	boolean getMousePressed();
	void setState(DrawMode mode);
	DrawMode GetState();
}
