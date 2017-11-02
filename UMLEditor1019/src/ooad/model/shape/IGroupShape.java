package ooad.model.shape;

public interface IGroupShape extends IAreaShape{
	void addShapeToGroup(IShape shape);
	int getShapeCount();
	IShape getStoredShape(int index);
}
