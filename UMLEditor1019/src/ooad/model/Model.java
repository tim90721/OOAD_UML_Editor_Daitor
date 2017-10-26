package ooad.model;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.jws.WebParam.Mode;

import ooad.model.Shape.ClassGraph;
import ooad.model.Shape.IShape;
import ooad.model.Shape.ShapeFactory;

public class Model implements IModel {
	private ArrayList<IShape> _shapes;
	private ArrayList<IObserver> _observers;
	private int _mouseX, _mouseY;
	private int _closeOffset = 30;
	private boolean _isPressed = false;
	private boolean _isDragging = false;
	private DrawMode _mode;
	private ShapeFactory _shapeFactory;
	private IShape _shape;

	public Model() {
		_shapes = new ArrayList<IShape>();
		_observers = new ArrayList<IObserver>();
		_shapeFactory = new ShapeFactory();
		setState(DrawMode.NONE);
		_shape = _shapeFactory.getShape(getState());
	}

	@Override
	public void draw(Graphics g) {
		setCoordinate(_shape, _mouseX, _mouseY);
		checkIsLineEnclose(_shape);
		if (isMousePressed())
			_shape.drawShape(g);
		if (!isMousePressed()) {
			if (getState() == DrawMode.SELECT)
				checkIsSelect(_shape);
			storeShape(_shape);
			setMouseDragging(false);
		}
		for (IShape shape : _shapes)
			shape.drawShape(g);
	}

	@Override
	public void registerPaintObserver(IObserver observer) {
		_observers.add(observer);
	}

	@Override
	public void unregisterPaintObserver(IObserver observer) {
		int i = _observers.indexOf(observer);
		_observers.remove(i);
	}

	@Override
	public void notifyPaintChange() {
		for (IObserver observer : _observers)
			observer.update();
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
		if (getState() != DrawMode.SELECT)
			_shapes.add(shape);
	}

	@Override
	public void setCoordinate(IShape shape, int x, int y) {
		if (!isMouseDragging()) {
			shape.setCoordinate(_mouseX, _mouseY, _mouseX, _mouseY);
		} else if (isMouseDragging()) {
			if (getState() == DrawMode.CLASS_MODE
					|| getState() == DrawMode.USECASE_MODE) {
				shape.setStartX(x);
				shape.setStartY(y);
			} else {
				shape.setEndX(x);
				shape.setEndY(y);
			}
		}
	}

	@Override
	public void checkIsSelect(IShape selectArea) {
		int areaStartX = selectArea.getStartX();
		int areaStartY = selectArea.getStartY();
		int endX = selectArea.getEndX();
		int endY = selectArea.getEndY();
		for (IShape shape : _shapes) {
			if (shape.getStartX() > areaStartX && shape.getStartY() > areaStartY
					&& shape.getEndX() < endX && shape.getEndY() < endY) {
				shape.setSelected(true);
			} else {
				shape.setSelected(false);
			}
		}
	}

	@Override
	public void checkIsLineEnclose(IShape line) {
		for (IShape shape : _shapes)
			if (getState() == DrawMode.ASSOCIATION_LINE
					|| getState() == DrawMode.GENERAL_LINE
					|| getState() == DrawMode.COMPOSITIONLINE)
				if (isMousePressed())
					shape.checkLineEnclose(line, _closeOffset);
				else
					shape.setSelected(false);
	}
}
