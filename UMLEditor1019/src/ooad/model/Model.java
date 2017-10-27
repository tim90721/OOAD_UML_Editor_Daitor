package ooad.model;

import java.awt.Graphics;
import java.awt.Shape;
import java.util.ArrayList;

import javax.jws.WebParam.Mode;

import ooad.model.Shape.AbstractAreaShape;
import ooad.model.Shape.ClassGraph;
import ooad.model.Shape.IShape;
import ooad.model.Shape.ShapeFactory;
import ooad.model.Shape.StringField;
import ooad.model.mode.IMode;
import ooad.model.mode.ModeFactory;

public class Model implements IModel, IPaintSubject{
	private ArrayList<IShape> _shapes;
	private ArrayList<IPaintObserver> _observers;
	private int _mouseX, _mouseY;
	private int _closeOffset = 30;
	private boolean _isPressed = false;
	private boolean _isDragging = false;
	private DrawMode _mode;
	private ShapeFactory _shapeFactory;
	private ModeFactory _modeFactory;
	private IShape _shape;
	private IMode _userMode;

	public Model() {
		_shapes = new ArrayList<IShape>();
		_observers = new ArrayList<IPaintObserver>();
		_shapeFactory = new ShapeFactory();
		_modeFactory = new ModeFactory(this);
		setState(DrawMode.NONE);
		_shape = _shapeFactory.getShape(getState());
	}

	@Override
	public void draw(Graphics g) {
		_userMode.setCoordinate(_shape, _mouseX, _mouseY);
		_userMode.isLineEnclose(_shape, _mouseX, _mouseY, _closeOffset);
		if (isMousePressed())
			_shape.drawShape(g);
		if (!isMousePressed()) {
			_userMode.checkIsSelect(_shape);
			_userMode.storeShape(_shape);
			setMouseDragging(false);
		}
		for (IShape shape : _shapes)
			shape.drawShape(g);
	}

	@Override
	public void registerPaintObserver(IPaintObserver observer) {
		_observers.add(observer);
	}

	@Override
	public void unregisterPaintObserver(IPaintObserver observer) {
		int i = _observers.indexOf(observer);
		_observers.remove(i);
	}

	@Override
	public void notifyPaintChange() {
		for (IPaintObserver observer : _observers)
			observer.updatePaint();
	}

	@Override
	public void setMouseXY(int x, int y) {
		this._mouseX = x;
		this._mouseY = y;
		notifyPaintChange();
	}

	@Override
	public int getMouseX() {
		return _mouseX;
	}

	@Override
	public int getMouseY() {
		return _mouseY;
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
	public void setState(DrawMode mode) {
		this._mode = mode;
		setUserMode(mode);
		refreshShapeState();
	}

	@Override
	public DrawMode getState() {
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
	public void newShape() {
		_shape = _shapeFactory.getShape(getState());
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

	@Override
	public void addShapeString(String name) {
		_userMode.addShapeString(_shape, name);
	}

	@Override
	public ArrayList<IShape> getStoreShapes() {
		return _shapes;
	}

	@Override
	public void setUserMode(DrawMode mode) {
		_userMode = _modeFactory.getMode(mode);
	}
}
