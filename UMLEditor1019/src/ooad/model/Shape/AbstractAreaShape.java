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
	}

	public void setHeight(int height) {
		_heightOffset = height;
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
	public void checkLineEnclose(IShape line, int closeOffset) {
		super.checkLineEnclose(line, closeOffset);
		if(isSelected()){
			findCloseSide(line, closeOffset);
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

	private void findCloseSide(IShape line, int closeOffset){
		ArrayList<Double> distances = new ArrayList<Double>();
		double difNorth = getDistance(line.getEndX(), line.getEndY(), getMiddleX(), getStartY());
		double difSouth = getDistance(line.getEndX(), line.getEndY(), getMiddleX(), getEndY());
		double difWest = getDistance(line.getEndX(), line.getEndY(), getStartX(), getMiddleY());
		double difEast = getDistance(line.getEndX(), line.getEndY(), getEndX(), getMiddleY());
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
	
	private double getDistance(int x1, int y1, int x2, int y2) {
		return Math.sqrt(Math.pow(x1 - x2, 2)
				+ Math.pow(y1 - y2, 2));
	}
	
	private void setAssociationLinePos(IShape line){
		switch (getCloseSide()) {
		case North:
			line.setEndX(getMiddleX());
			line.setEndY(getStartY());
			break;
		case South:
			line.setEndX(getMiddleX());
			line.setEndY(getEndY());
			break;
		case West:
			line.setEndX(getStartX());
			line.setEndY(getMiddleY());
			break;
		case East:
			line.setEndX(getEndX());
			line.setEndY(getMiddleY());
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
