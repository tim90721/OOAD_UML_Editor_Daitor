package ooad.model;

import java.awt.Graphics;
import java.awt.Shape;
import java.util.ArrayList;

import javax.jws.WebParam.Mode;

import ooad.model.Shape.AbstractAreaShape;
import ooad.model.Shape.ClassGraph;
import ooad.model.Shape.IShape;
import ooad.model.Shape.NoneShape;
import ooad.model.Shape.ShapeFactory;
import ooad.model.Shape.StringField;
import ooad.model.mode.IMode;
import ooad.model.mode.ModeFactory;

public class Model implements IModel, IPaintSubject {
	private ArrayList<IShape> _shapes;
	private ArrayList<IShape> _selectShapes;
	private ArrayList<IPaintObserver> _observers;
	private int _mouseX, _mouseY;
	private int _prevMouseX, _prevMouseY;
	private int _closeOffset = 30;
	private boolean _isPressed = false;
	private boolean _isDragging = false;
	private boolean _isMouseMoving = false;
	private boolean _hasSelectShape = false;
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
		setDrawMode(DrawMode.NONE);
		_shape = _shapeFactory.getShape(getDrawMode());
	}

	@Override
	public void draw(Graphics g) {
		_userMode.drawing(g, _shape, _mouseX, _mouseY, _closeOffset);
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
	public void setMousePos(int x, int y) {
		this._mouseX = x;
		this._mouseY = y;
		notifyPaintChange();
	}

	/* (non-Javadoc)
	 * set mouse previous position
	 */
	@Override
	public void setPrevMousePos(int x, int y) {
		//TODO set mouse previous position
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

	/* (non-Javadoc)
	 * get previous mouse x
	 */
	@Override
	public int getPrevMouseX() {
		// TODO Auto-generated method stub
		return _prevMouseX;
	}

	/* (non-Javadoc)
	 * get previous mouse y
	 */
	@Override
	public int getPrevMouseY() {
		// TODO Auto-generated method stub
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

	/* (non-Javadoc)
	 * set select shapes
	 */
	@Override
	public void setSelectShapes(ArrayList<IShape> selectShapes) {
		// TODO Auto-generated method stub
		_selectShapes = selectShapes;
	}

	/* (non-Javadoc)
	 * get select shapes
	 */
	@Override
	public ArrayList<IShape> getSelectShapes() {
		// TODO Auto-generated method stub
		return _selectShapes;
	}

	@Override
	public void addShapeString(String name) {
		IShape shape = _shapes.get(_shapes.size() - 1);
		_userMode.addShapeString(shape, name);
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
}
