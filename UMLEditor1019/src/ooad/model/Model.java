package ooad.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
import java.util.ArrayList;

import javax.jws.WebParam.Mode;

import ooad.model.mode.IMode;
import ooad.model.mode.ModeFactory;
import ooad.model.shape.AbstractAreaShape;
import ooad.model.shape.ClassGraph;
import ooad.model.shape.IGroupShape;
import ooad.model.shape.IGroupable;
import ooad.model.shape.IShape;
import ooad.model.shape.IStringField;
import ooad.model.shape.NoneShape;
import ooad.model.shape.ShapeFactory;
import ooad.model.shape.StringField;

public class Model implements IModel, IPaintSubject, IMenuItemChangeSubject{
	private ArrayList<IShape> _shapes;
	private ArrayList<IShape> _selectShapes;
	private ArrayList<IPaintObserver> _paintObservers;
	private ArrayList<IMenuItemChangeObserver> _menuObservers;
	private int _mouseX, _mouseY;
	private int _prevMouseX, _prevMouseY;
	private int _closeOffset = 30;
	private boolean _isPressed = false;
	private boolean _isDragging = false;
	private boolean _isMouseMoving = false;
	private DrawMode _mode;
	private ShapeFactory _shapeFactory;
	private ModeFactory _modeFactory;
	private IShape _shape;
	private IMode _userMode;

	public Model() {
		_shapes = new ArrayList<IShape>();
		_selectShapes = new ArrayList<IShape>();
		_paintObservers = new ArrayList<IPaintObserver>();
		_menuObservers = new ArrayList<IMenuItemChangeObserver>();
		_shapeFactory = new ShapeFactory();
		_modeFactory = new ModeFactory(this);
		setDrawMode(DrawMode.NONE);
		_shape = _shapeFactory.getShape(getDrawMode());
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		_userMode.drawing(g, _shape, _mouseX, _mouseY, _closeOffset);
		if (isMousePressed())
			_shape.drawShape(g);
		if (!isMousePressed() && !isMouseMoving()) 
			_userMode.storeShape(_shape);
		for (IShape shape : _shapes)
			shape.drawShape(g);
	}

	@Override
	public void registerPaintObserver(IPaintObserver observer) {
		_paintObservers.add(observer);
	}

	@Override
	public void unregisterPaintObserver(IPaintObserver observer) {
		int i = _paintObservers.indexOf(observer);
		_paintObservers.remove(i);
	}

	@Override
	public void notifyPaintChange() {
		for (IPaintObserver observer : _paintObservers)
			observer.updatePaint();
	}

	@Override
	public void setMousePos(int x, int y) {
		this._mouseX = x;
		this._mouseY = y;
		notifyPaintChange();
		notifyMenuItemChange();
	}

	/** 
	 * set mouse previous position
	 */
	@Override
	public void setPrevMousePos(int x, int y) {
		_prevMouseX = x;
		_prevMouseY = y;
	}

	@Override
	public int getMouseX() {
		return _mouseX;
	}

	@Override
	public int getMouseY() {
		return _mouseY;
	}

	/**
	 * get previous mouse x
	 */
	@Override
	public int getPrevMouseX() {
		return _prevMouseX;
	}

	/**
	 * get previous mouse y
	 */
	@Override
	public int getPrevMouseY() {
		return _prevMouseY;
	}

	@Override
	public void setMousePressed(boolean isPressed) {
		this._isPressed = isPressed;
	}

	@Override
	public boolean isMousePressed() {
		return this._isPressed;
	}

	@Override
	public void setDrawMode(DrawMode mode) {
		this._mode = mode;
		setUserMode(mode);
		refreshShapeState();
	}

	@Override
	public DrawMode getDrawMode() {
		return this._mode;
	}

	@Override
	public void refreshShapeState() {
		for (IShape shape : _shapes)
			shape.setSelected(false);
		_shape = _shapeFactory.getShape(DrawMode.NONE);
		notifyPaintChange();
	}

	@Override
	public void setMouseDragging(boolean isDragging) {
		this._isDragging = isDragging;
	}

	@Override
	public boolean isMouseDragging() {
		return this._isDragging;
	}

	@Override
	public void setMouseMoving(boolean isMoving) {
		_isMouseMoving = isMoving;
	}

	@Override
	public boolean isMouseMoving() {
		return _isMouseMoving;
	}

	@Override
	public void newShape() {
		_shape = _shapeFactory.getShape(getDrawMode());
	}

	@Override
	public void newShape(DrawMode mode) {
		_shape = _shapeFactory.getShape(mode);
	}

	@Override
	public void storeShape(IShape shape) {
		_shapes.add(shape);
	}
	
	@Override
	public void setShapeSelectStatus(boolean selected) {
		for (IShape shape : _shapes)
			shape.setSelected(selected);
	}

	/** 
	 * set select shapes
	 */
	@Override
	public void setSelectShapes(ArrayList<IShape> selectShapes) {
		_selectShapes = selectShapes;
	}

	@Override
	public ArrayList<IShape> getSelectShapes() {
		return _selectShapes;
	}

	@Override
	public void addShapeString(String name) {
		_shape = new StringField((AbstractAreaShape)_shape, name); 
		_userMode.addShapeString((IStringField)_shape, name);
		newShape(DrawMode.NONE);
	}

	@Override
	public ArrayList<IShape> getStoreShapes() {
		return _shapes;
	}

	@Override
	public void setUserMode(DrawMode mode) {
		_userMode = _modeFactory.getMode(mode);
	}

	@Override
	public void checkMouseEnclose(int mouseX, int mouseY) {
		boolean isClose = false;
		for (IShape shape : _shapes)
			if (shape.isLineEnclose(mouseX, mouseY, _closeOffset))
				isClose = true;
		if (isClose)
			setMousePos(mouseX, mouseY);
	}

	@Override
	public void groupShapes() {
		newShape(DrawMode.GROUP);
		for (IShape shape : _selectShapes) {
			((IGroupShape)_shape).addShapeToGroup(shape);
			_shapes.remove(shape);
		}
		_shapes.add(_shape);
		_selectShapes.removeAll(_selectShapes);
		_selectShapes.add(_shape);
	}

	@Override
	public void unGroupShapes() {
		if(_selectShapes.size() < 2) {
			IGroupShape groupShape = (IGroupShape)_selectShapes.get(0);
			for(int i = 0; i < groupShape.getShapeCount(); i++){
				IShape shape = groupShape.getStoredShape(i);
				_shapes.add(shape);
				_selectShapes.add(shape);
			}
			_shapes.remove((IShape)groupShape);
			_selectShapes.remove((IShape)groupShape);
		}
	}

	@Override
	public boolean checkCanGroup() {
		if(_selectShapes.size() > 1) 
			return true;
		return false;
	}

	@Override
	public boolean checkCanUnGroup() {
		if(_selectShapes.size() == 1) 
			for (IShape shape : _selectShapes) 
				if(((IGroupable)shape).isGrouped()) 
					return true;
		return false;
	}

	@Override
	public void registerMenuItemObserver(IMenuItemChangeObserver observer) {
		_menuObservers.add(observer);
	}

	@Override
	public void notifyMenuItemChange() {
		for (IMenuItemChangeObserver observer : _menuObservers) {
			observer.updateItem();
		}
	}
}
