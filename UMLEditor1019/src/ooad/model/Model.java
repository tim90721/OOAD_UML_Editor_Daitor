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
	private boolean _isPressed = false;
	private boolean _isDragging = false;
	private DrawMode _mode;
	private ShapeFactory _shapeFactory;
	private IShape _shape;

	public Model() {
		_shapes = new ArrayList<IShape>();
		_observers = new ArrayList<IObserver>();
		setState(DrawMode.NONE);
		_shapeFactory = new ShapeFactory();
		_shape = _shapeFactory.getShape(GetState());
	}

	@Override
	public void draw(Graphics g) {
		setCoordinate(_shape, _mouseX, _mouseY);
		if(isMousePressed())
			_shape.drawShape(g);
		if (!isMousePressed()) {
			if(GetState() == DrawMode.SELECT)
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
	}

	@Override
	public DrawMode GetState() {
		return this._mode;
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
		_shape = _shapeFactory.getShape(GetState());
	}

	@Override
	public void storeShape(IShape shape) {
		if (GetState() != DrawMode.SELECT)
			_shapes.add(shape);
	}

	@Override
	public void setCoordinate(IShape shape, int x, int y) {
		if (!isMouseDragging()){
			shape.setCoordinate(_mouseX, _mouseY, _mouseX, _mouseY);
		}
		else if (isMouseDragging()) {
			if (GetState() == DrawMode.CLASS_MODE || GetState() == DrawMode.USECASE_MODE) {
				shape.setStartX(x);
				shape.setStartY(y);
			} 
			else {
				shape.setEndX(x);
				shape.setEndY(y);
			}
		}
	}

	@Override
	public void checkIsSelect(IShape selectArea) {
		int startX = selectArea.getStartX();
		int startY = selectArea.getStartY();
		int endX = selectArea.getEndX();
		int endY = selectArea.getEndY();
		for (IShape shape : _shapes) {
			if(shape.getStartX() > startX && shape.getStartY() > startY &&
					shape.getEndX() < endX && shape.getEndY() < endY){
				shape.setSelected(true);
			}
			else {
				shape.setSelected(false);
			}
		}
	}
}
