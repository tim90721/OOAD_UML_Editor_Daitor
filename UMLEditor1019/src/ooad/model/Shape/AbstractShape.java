package ooad.model.Shape;


public abstract class AbstractShape implements IShape{
	int _depth;
	private int _startX, _startY;
	private int _endX, _endY;

	@Override
	public void setStartX(int x) {
		_startX = x;
	}

	@Override
	public void setEndX(int x) {
		_endX = x;
	}

	@Override
	public void setStartY(int y) {
		_startY = y;
	}

	@Override
	public void setEndY(int y) {
		_endY = y;
	}

	@Override
	public int getStartX() {
		return _startX;
	}

	@Override
	public int getEndX() {
		return _endX;
	}

	@Override
	public int getStartY() {
		return _startY;
	}

	@Override
	public int getEndY() {
		return _endY;
	}
}
