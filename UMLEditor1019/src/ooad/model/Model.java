package ooad.model;

import java.awt.Graphics;
import java.util.ArrayList;

import ooad.model.Shape.ClassGraph;
import ooad.model.Shape.IShape;

public class Model implements IModel{
	private ArrayList<IShape> _shapes;
	private ArrayList<IObserver> _observers;
	private int _mouseX, _mouseY;
	private boolean _isPressed = false;
	private DrawMode _mode;
	
	public Model(){
		_shapes = new ArrayList<IShape>();
		_observers = new ArrayList<IObserver>();
		setState(DrawMode.SELECT);
	}

	public void draw(Graphics g) {
		for (IShape shape : _shapes) 
			shape.drawShape(g);
		IShape shape = new ClassGraph();
		shape.drawShape(g);
		if(!getMousePressed())
			_shapes.add(shape);
	}

	@Override
	public void registerObserver(IObserver observer) {
		_observers.add(observer);
	}

	@Override
	public void unregisterObserver(IObserver observer) {
		int i = _observers.indexOf(observer);
		_observers.remove(i);
	}

	@Override
	public void notifyChange() {
		for (IObserver observer : _observers) 
			observer.update();
	}

	@Override
	public void setMouseXY(int x, int y) {
		this._mouseX = x;
		this._mouseY = y;
		notifyChange();
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
	public boolean getMousePressed() {
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
}
