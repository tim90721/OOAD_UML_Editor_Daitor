package ooad.model.shape;

public class StoredLine {
	private IShape _line;
	private CloseSide _closeSide;
	
	public StoredLine(IShape line, CloseSide closeSide) {
		_line = line;
		_closeSide = closeSide;
	}
	
	public IShape getLine() {
		return _line;
	}
	
	public CloseSide getCloseSide() {
		return _closeSide;
	}
}
