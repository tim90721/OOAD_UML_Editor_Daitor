package ooad.model.shape;

public interface IAreaShape {
	void setWidth(int width);
	void setHeight(int height);
	int getWidth();
	int getHeight();
	void setCloseSide(CloseSide side);
	CloseSide getCloseSide();
	void addShapeString(IStringField stringField, String name);
}
