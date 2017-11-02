package ooad.model.Shape;

import java.util.ArrayList;

public class GroupShape extends AbstractAreaShape{
	private ArrayList<IShape> _groupShapes;
	
	public GroupShape() {
		_groupShapes = new ArrayList<IShape>();
	}
	
	@Override
	public void addShapeString(IStringField stringField, String name) {
	}
	
	public void addShapeToGroup(IShape shape){
		_groupShapes.add(shape);
	}
}
