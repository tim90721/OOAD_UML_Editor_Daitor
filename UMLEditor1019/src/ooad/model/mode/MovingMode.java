package ooad.model.mode;

import java.awt.Graphics;
import java.util.ArrayList;

import ooad.model.DrawMode;
import ooad.model.IModel;
import ooad.model.Shape.IShape;

public class MovingMode extends AbstractMode{
	private int _prevMouseX;
	private int _prevMouseY;
	
	public MovingMode(IModel model) {
		super(model);
	}

	@Override
	public void addShapeString(IShape shape, String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMode() {
		// TODO Auto-generated method stub
		
	}

//	public void setPrevMousePos(int mouseX, int mouseY){
//		_prevMouseX = mouseX;
//		_prevMouseY = mouseY;
//	}
//	
//	public int getPrevMouseX(){
//		return _prevMouseX;
//	}
//	
//	public int getPrevMouseY(){
//		return _prevMouseY;
//	}
//	
//	public void setSelectShapes(ArrayList<IShape> selectShapes){
//		_selectShapes = selectShapes;
//	}

	/* (non-Javadoc)
	 * @see ooad.model.mode.AbstractMode#drawing(java.awt.Graphics, ooad.model.Shape.IShape, int, int, int)
	 */
	@Override
	public void drawing(Graphics g, IShape shape, int mouseX, int mouseY,
			int closeOffset) {
		if(_model.isMousePressed()){
			int difX = _prevMouseX - mouseX;
			int difY = _prevMouseY - mouseY;
			for (IShape selectShape : _model.getSelectShapes()) 
				selectShape.setStart(shape.getStartX() - difX, shape.getStartY() - difY);
			for (IShape storeShape : _model.getStoreShapes())
				storeShape.drawShape(g);
		}
		else
			_model.setUserMode(DrawMode.SELECT);
	}
}
