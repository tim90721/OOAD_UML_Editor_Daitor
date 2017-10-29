package ooad.model.Shape;

import java.awt.Graphics;

public interface IShape {
	void drawShape(Graphics g);
	void setStartX(int x);
	void setEndX(int x);
	void setStartY(int y);
	void setEndY(int y);
	void setMiddleX(int x);
	void setMiddleY(int y);
	void setStart(int startX, int startY);
	void setEnd(int endX, int endY);
	void setMiddle(int middleX, int middleY);
	void setCoordinate(int startX, int startY, int endX, int endY);
	int getStartX();
	int getEndX();
	int getStartY();
	int getEndY();
	int getMiddleX();
	int getMiddleY();
	void setSelected(boolean isSelect);
	boolean isSelected();
	void isLineEnclose(IShape line, int mouseLineX, int mouseLineY, int closeOffset);
	void isLineEnclose(int mouseLineX, int mouseLineY, int closeOffset);
	double getDistance(int x1, int y1, int x2, int y2);
}
