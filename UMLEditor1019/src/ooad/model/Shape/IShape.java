package ooad.model.Shape;

import java.awt.Graphics;

public interface IShape {
	void drawShape(Graphics g);
	void setStartX(int x);
	void setEndX(int x);
	void setStartY(int y);
	void setEndY(int y);
	void setCoordinate(int startX, int startY, int endX, int endY);
	int getStartX();
	int getEndX();
	int getStartY();
	int getEndY();
}
