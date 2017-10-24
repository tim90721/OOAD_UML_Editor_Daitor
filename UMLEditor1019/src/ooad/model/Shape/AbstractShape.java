package ooad.model.Shape;


public abstract class AbstractShape implements IShape{
	int _depth;
	protected int _startX, _startY;
	protected int _endX, _endY;
	private int _middelX, _middelY;

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

	@Override
	public void setMiddleX(int x) {
		_middelX = x;
	}

	@Override
	public void setMiddleY(int y) {
		_middelY = y;
	}

	@Override
	public int getMiddleX() {
		return _middelX;
	}

	@Override
	public int getMiddleY() {
		return _middelY;
	}

	@Override
	public void setCoordinate(int startX, int startY, int endX, int endY) {
		setStartX(startX);
		setStartY(startY);
		setEndX(endX);
		setEndY(endY);
	}
}
