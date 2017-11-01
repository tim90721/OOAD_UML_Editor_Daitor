package ooad.model.Shape;

import java.awt.Graphics;

public class NoneShape extends AbstractShape{
	
	public NoneShape() {
		_name = "None";
	}
	
	@Override
	public void drawShape(Graphics g) {
	}

	@Override
	public void setLineStartPos(IShape line) {
	}

	@Override
	public void setLineEndPos(IShape line) {
	}

	@Override
	public boolean isLine() {
		return true;
	}

	@Override
	public void setSelected(boolean isSelect) {
	}

	@Override
	public boolean isSelected() {
		return false;
	}

	@Override
	public void setStartX(int x) {
	}

	@Override
	public void setEndX(int x) {
	}

	@Override
	public void setStartY(int y) {
	}

	@Override
	public void setEndY(int y) {
	}

	@Override
	public void setStart(int startX, int startY) {
	}

	@Override
	public void setEnd(int endX, int endY) {
	}

	@Override
	public void setMiddle(int middleX, int middleY) {
	}

	@Override
	public int getStartX() {
		return super.getStartX();
	}

	@Override
	public int getEndX() {
		return super.getEndX();
	}

	@Override
	public int getStartY() {
		return super.getStartY();
	}

	@Override
	public int getEndY() {
		return super.getEndY();
	}

	@Override
	public void setMiddleX(int x) {
		super.setMiddleX(x);
	}

	@Override
	public void setMiddleY(int y) {
		super.setMiddleY(y);
	}

	@Override
	public int getMiddleX() {
		return super.getMiddleX();
	}

	@Override
	public int getMiddleY() {
		return super.getMiddleY();
	}

	@Override
	public void setCoordinate(int startX, int startY, int endX, int endY) {
	}

	@Override
	public void isLineEnclose(IShape line, int mouseLineX, int mouseLineY,
			int closeOffset) {
	}

	@Override
	public boolean isLineEnclose(int mouseLineX, int mouseLineY, int closeOffset) {
		return false;
	}

	@Override
	public double getDistance(int x1, int y1, int x2, int y2) {
		return super.getDistance(x1, y1, x2, y2);
	}
}
