package ooad.model.mode;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import ooad.model.DrawMode;
import ooad.model.IModel;
import ooad.model.shape.IShape;
import ooad.model.shape.IStringField;
import ooad.model.shape.NoneShape;

public class SelectMode extends AbstractMode {
	private int _startX;
	private int _startY;
	private int _endX;
	private int _endY;
	private ArrayList<IShape> _selectShapes;

	public SelectMode(IModel model) {
		super(model);
		_selectShapes = new ArrayList<IShape>();
		_hasSelectShape = false;
	}

	@Override
	public void storeShape(IShape shape) {
	}

	@Override
	public boolean checkIsSelect(IShape selectArea) {
		super.checkIsSelect(selectArea);
		_hasSelectShape = false;
		_selectShapes.removeAll(_selectShapes);
		if (_model.isMouseDragging()) {
			configCoordinate(selectArea);
			for (IShape shape : _model.getStoreShapes())
				if (shape.checkIsSelect(_startX, _startY, _endX, _endY)) {
					shape.setSelected(true);
					_selectShapes.add(shape);
					_hasSelectShape = true;
				}
		} else{
			for (IShape shape : _model.getStoreShapes())
				if (shape.checkIsSelect(selectArea)) {
					shape.setSelected(true);
					_selectShapes.add(shape);
					_hasSelectShape = true;
				}
			if(_selectShapes.size() > 0){
				checkShapeDepth();
				System.out.println("aa");
			}
		}
		if (_hasSelectShape)
			return true;
		return false;
	}
	
	private void checkShapeDepth(){
		IShape shape = _selectShapes.get(0);
		for(int i = 0; i < _selectShapes.size(); i++){
			IShape compareShape = _selectShapes.get(i);
			if(compareShape.getDepth() > shape.getDepth()){
				shape.setSelected(false);
				shape = compareShape;
			}
			System.out.println(_selectShapes.size());
		}
		_selectShapes.removeAll(_selectShapes);
		System.out.println(_selectShapes.size());
		_selectShapes.add(shape);
		System.out.println(_selectShapes.size());
	}

	private void configCoordinate(IShape selectArea) {
		_startX = selectArea.getStartX();
		_startY = selectArea.getStartY();
		int selectStartX = _startX;
		int selectStartY = _startY;
		_endX = selectArea.getEndX();
		_endY = selectArea.getEndY();
		int temp;
		if (_startX > _endX) {
			temp = _endX;
			_endX = selectStartX;
			selectStartX = temp;
		}
		if (_startY > _endY) {
			temp = _endY;
			_endY = selectStartY;
			selectStartY = temp;
		}
		_startX = selectStartX;
		_startY = selectStartY;
	}

	@Override
	public void isLineEnclose(IShape line, int mouseX, int mouseY,
			int closeOffset) {
		super.isLineEnclose(line, mouseX, mouseY, closeOffset);
	}

	@Override
	public void addShapeString(IStringField stringField, String name) {
//		stringField.setName(name);
	}

	@Override
	public void setCoordinate(IShape shape, int mouseX, int mouseY) {
		super.setCoordinate(shape, mouseX, mouseY);
		if (_model.isMouseDragging())
			shape.setEnd(mouseX, mouseY);
	}

	@Override
	public void setMode() {
		_model.setDrawMode(DrawMode.SELECT);
	}

	@Override
	public boolean moveSelectShape(int mouseX, int mouseY) {

		return false;
	}

	@Override
	public void drawing(Graphics g, IShape shape, int mouseX, int mouseY,
			int closeOffset) {
		if (_model.isMousePressed() && !_model.isMouseDragging()){
			boolean isClickInSelectArea = false;
			setCoordinate(shape, mouseX, mouseY);
			for (IShape selectShape : _selectShapes) {
				if(selectShape.checkIsSelect(shape)){
					_model.setPrevMousePos(mouseX, mouseY);
					_model.setSelectShapes(_selectShapes);
					_model.setUserMode(DrawMode.MOVING);
					isClickInSelectArea = true;
					return;
				}
			}
			if(!isClickInSelectArea)
				_selectShapes = new ArrayList<IShape>();
		}
		super.drawing(g, shape, mouseX, mouseY, closeOffset);
		_model.setSelectShapes(_selectShapes);
	}
}
