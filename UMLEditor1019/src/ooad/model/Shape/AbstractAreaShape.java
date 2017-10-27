package ooad.model.Shape;

import java.util.ArrayList;
import java.util.Collections;

import javax.sound.sampled.Line;

public abstract class AbstractAreaShape extends AbstractShape implements
		IAreaShape {
	protected int _widthOffset;
	protected int _heightOffset;
	protected CloseSide _side;

	public void setWidth(int width) {
		_widthOffset = width;
		setStartX(getStartX());
	}

	public void setHeight(int height) {
		_heightOffset = height;
		setStartY(getStartY());
	}

	public int getWidth() {
		return _widthOffset;
	}

	public int getHeight() {
		return _heightOffset;
	}

	@Override
	public void setStartX(int x) {
		super.setStartX(x);
		setEndX(getStartX() + _widthOffset);
		setMiddleX(getStartX() + (getEndX() - getStartX()) / 2);
	}

	@Override
	public void setStartY(int y) {
		super.setStartY(y);
		setEndY(getStartY() + _heightOffset);
		setMiddleY(getStartY() + (getEndY() - getStartY()) / 2);
	}

	@Override
	public void setCoordinate(int startX, int startY, int endX, int endY) {
		super.setCoordinate(startX, startY, startX + _widthOffset, startY
				+ _heightOffset);
		setMiddleX(getStartX() + (getEndX() - getStartX()) / 2);
		setMiddleY(getStartY() + (getEndY() - getStartY()) / 2);
	}

	@Override
	public void isLineEnclose(IShape line, int mouseLineX, int mouseLineY, int closeOffset) {
		super.isLineEnclose(line, mouseLineX, mouseLineY, closeOffset);
		if(isSelected()){
			findCloseSide(mouseLineX, mouseLineY, closeOffset);
			setAssociationLinePos(line);
		}
	}

	@Override
	public void setCloseSide(CloseSide side) {
		_side = side;
	}

	@Override
	public CloseSide getCloseSide() {
		return _side;
	}

	private void findCloseSide(int mouseLineX, int mouseLineY, int closeOffset){
		ArrayList<Double> distances = new ArrayList<Double>();
		double difNorth = getDistance(mouseLineX, mouseLineY, getMiddleX(), getStartY());
		double difSouth = getDistance(mouseLineX, mouseLineY, getMiddleX(), getEndY());
		double difWest = getDistance(mouseLineX, mouseLineY, getStartX(), getMiddleY());
		double difEast = getDistance(mouseLineX, mouseLineY, getEndX(), getMiddleY());
		distances.add(difNorth);
		distances.add(difSouth);
		distances.add(difWest);
		distances.add(difEast);
		int minIndex = distances.indexOf(Collections.min(distances));
		switch (minIndex) {
		case 0:
			_side = CloseSide.North;
			break;
		case 1:
			_side = CloseSide.South;
			break;
		case 2:
			_side = CloseSide.West;
			break;
		case 3:
			_side = CloseSide.East;
		default:
			break;
		}
	}
	
	private void setAssociationLinePos(IShape line){
		switch (getCloseSide()) {
		case North:
			line.setEnd(getMiddleX(), getStartY());
			break;
		case South:
			line.setEnd(getMiddleX(), getEndY());
			break;
		case West:
			line.setEnd(getStartX(), getMiddleY());
			break;
		case East:
			line.setEnd(getEndX(), getMiddleY());
			break;
		}
	}
}

enum CloseSide{
	North,
	South,
	West,
	East
}
