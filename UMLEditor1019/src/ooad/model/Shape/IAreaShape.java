package ooad.model.Shape;

public interface IAreaShape {
	void setWidth(int width);
	void setHeight(int height);
	int getWidth();
	int getHeight();
	void setCloseSide(CloseSide side);
	CloseSide getCloseSide();
}
