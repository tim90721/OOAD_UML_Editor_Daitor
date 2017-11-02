package ooad.model.Shape;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;

public abstract class AbstractAreaShape extends AbstractShape implements
		IAreaShape {
	protected int _widthOffset;
	protected int _heightOffset;
	protected CloseSide _side;
	protected ArrayList<StoredLine> _startLines;
	protected ArrayList<StoredLine> _endLines;

	public AbstractAreaShape() {
		_side = CloseSide.None;
		_startLines = new ArrayList<StoredLine>();
		_endLines = new ArrayList<StoredLine>();
	}
	
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
	public void setStart(int startX, int startY) {
		super.setStart(startX, startY);
		StoredLine storedLine;
		for(int i = 0; i < _startLines.size(); i++){
			storedLine = _startLines.get(i);
			IShape line = storedLine.getLine();
			_side = storedLine.getCloseSide();
			_startLines.remove(i);
			setLineStartPos(line);
		}
		for(int i = 0; i < _endLines.size(); i++){
			storedLine = _endLines.get(i);
			IShape line = storedLine.getLine();
			_side = storedLine.getCloseSide();
			_endLines.remove(i);
			setLineEndPos(line);
		}
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
			setLineEndPos(line);
		}
		else
			_side = CloseSide.None;
	}

	@Override
	public boolean isLineEnclose(int mouseLineX, int mouseLineY, int closeOffset) {
		super.isLineEnclose(mouseLineX, mouseLineY, closeOffset);
		if(isSelected()){
			findCloseSide(mouseLineX, mouseLineY, closeOffset);
			return true;
		}
		else{
			_side = CloseSide.None;
			return false;
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
	
	@Override
	public void setLineStartPos(IShape line) {
		System.out.println(((IBasicLine)line).getMouseEndX());
		switch (getCloseSide()) {
		case North:
			line.setStart(getMiddleX(), getStartY());
			break;
		case South:
			line.setStart(getMiddleX(), getEndY());
			break;
		case West:
			line.setStart(getStartX(), getMiddleY());
			break;
		case East:
			line.setStart(getEndX(), getMiddleY());
			break;
		default:
			break;
		}
		if(getCloseSide() != CloseSide.None) {
			System.out.println(((IBasicLine)line).getMouseEndX());
//			System.out.println(line.getEndX());
			line.setEnd(((IBasicLine)line).getMouseEndX(), ((IBasicLine)line).getMouseEndY());
			storeStartLine(line, getCloseSide());
		}
	}

	@Override
	public void setLineEndPos(IShape line) {
		switch (getCloseSide()) {
		case North:
			((IBasicLine)line).setMouseEndXY(getMiddleX(), getStartY());
			line.setEnd(getMiddleX(), getStartY());
			break;
		case South:
			((IBasicLine)line).setMouseEndXY(getMiddleX(), getEndY());
			line.setEnd(getMiddleX(), getEndY());
			break;
		case West:
			((IBasicLine)line).setMouseEndXY(getStartX(), getMiddleY());
			line.setEnd(getStartX(), getMiddleY());
			break;
		case East:
			((IBasicLine)line).setMouseEndXY(getEndX(), getMiddleY());
			line.setEnd(getEndX(), getMiddleY());
			break;
		default:
			break;
		}
		if(getCloseSide() != CloseSide.None) {
			storeEndLine(line, getCloseSide());
		}
	}
	
	private void storeStartLine(IShape line, CloseSide closeSide) {
		_startLines.add(new StoredLine(line, closeSide));
	}
	
	private void storeEndLine(IShape line, CloseSide closeSide) {
		_endLines.add(new StoredLine(line, closeSide));
	}

	@Override
	public void drawShape(Graphics g) {
		super.drawShape(g);
		g.setColor(Color.red);
		if(isSelected()) {
			switch (_side) {
			case North:
				g.fillRect(getMiddleX() - _selectRectwidth / 2, getStartY() - _selectRectwidth, _selectRectwidth, _selectRectwidth);
				break;
			case South:
				g.fillRect(getMiddleX() - _selectRectwidth / 2, getEndY(), _selectRectwidth, _selectRectwidth);
				break;
			case West:
				g.fillRect(getStartX() - _selectRectwidth, getMiddleY() - _selectRectwidth / 2, _selectRectwidth, _selectRectwidth);
				break;
			case East:
				g.fillRect(getEndX(), getMiddleY() - _selectRectwidth / 2, _selectRectwidth, _selectRectwidth);
				break;
			default:
				break;
			}
		}
		g.setColor(Color.BLACK);
	}

	@Override
	public void movePos(int difX, int difY) {
		setStart(_startX - difX, _startY - difY);
	}
}

enum CloseSide{
	North,
	South,
	West,
	East,
	None
}
