package ooad.model.shape;

import java.awt.Graphics;
import java.util.ArrayList;

public class GroupShape extends AbstractAreaShape implements IGroupShape{
	private ArrayList<IShape> _groupShapes;
	
	public GroupShape() {
		_groupShapes = new ArrayList<IShape>();
		_name = "GroupShape";
	}
	
	@Override
	public void addShapeString(IStringField stringField, String name) {
	}

	@Override
	public void addShapeToGroup(IShape shape) {
		_groupShapes.add(shape);		
	}

	@Override
	public IShape getStoredShape(int index) {
		return _groupShapes.get(index);
	}

	@Override
	public int getShapeCount() {
		return _groupShapes.size();
	}

	@Override
	public void movePos(int difX, int difY) {
		for (IShape shape : _groupShapes) 
			shape.movePos(difX, difY);
	}

	@Override
	public void drawShape(Graphics g) {
		for (IShape shape : _groupShapes) 
			shape.drawShape(g);
	}

	@Override
	public void setWidth(int width) {
	}

	@Override
	public void setHeight(int height) {
	}

	@Override
	public int getWidth() {
		return 0;
	}

	@Override
	public int getHeight() {
		return 0;
	}

	@Override
	public void setStartX(int x) {
	}

	@Override
	public void setStartY(int y) {
	}

	@Override
	public void setStart(int startX, int startY) {
	}

	@Override
	public void setCoordinate(int startX, int startY, int endX, int endY) {
	}

	@Override
	public void isLineEnclose(IShape line, int mouseLineX, int mouseLineY, int closeOffset) {
	}

	@Override
	public boolean isLineEnclose(int mouseLineX, int mouseLineY, int closeOffset) {
		return false;
	}

	@Override
	public void setCloseSide(CloseSide side) {
	}

	@Override
	public CloseSide getCloseSide() {
		return CloseSide.None;
	}

	@Override
	public void setLineStartPos(IShape line) {
	}

	@Override
	public void setLineEndPos(IShape line) {
	}

	@Override
	public void setSelected(boolean isSelect) {
		for (IShape shape : _groupShapes) 
			shape.setSelected(isSelect);
	}

	@Override
	public boolean isSelected() {
		return _groupShapes.get(0).isSelected();
	}

	@Override
	public void setEndX(int x) {
	}

	@Override
	public void setEndY(int y) {
	}

	@Override
	public void setEnd(int endX, int endY) {
	}

	@Override
	public void setMiddle(int middleX, int middleY) {
	}

	@Override
	public int getStartX() {
		return 0;
	}

	@Override
	public int getEndX() {
		return 0;
	}

	@Override
	public int getStartY() {
		return 0;
	}

	@Override
	public int getEndY() {
		return 0;
	}

	@Override
	public void setMiddleX(int x) {
	}

	@Override
	public void setMiddleY(int y) {
	}

	@Override
	public int getMiddleX() {
		return 0;
	}

	@Override
	public int getMiddleY() {
		return 0;
	}

	@Override
	public double getDistance(int x1, int y1, int x2, int y2) {
		return super.getDistance(x1, y1, x2, y2);
	}

	@Override
	public boolean isLine() {
		return false;
	}

	@Override
	public String getShapeName() {
		return super.getShapeName();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public boolean checkIsSelect(int x1, int y1, int x2, int y2) {
		boolean hasSelectShape = false;
		for (IShape shape : _groupShapes) 
			if(shape.checkIsSelect(x1, y1, x2, y2)){
				hasSelectShape = true;
				break;
			}
		return hasSelectShape;
	}

	@Override
	public boolean checkIsSelect(IShape selectArea) {
		boolean hasSelectShape = false;
		for (IShape shape : _groupShapes) 
			if(shape.checkIsSelect(selectArea)){
				hasSelectShape = true;
				break;
			}
		return hasSelectShape;
	}

	@Override
	public boolean isGrouped() {
		return true;
	}
}
