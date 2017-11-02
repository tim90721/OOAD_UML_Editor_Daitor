package ooad.model.mode;

import java.awt.Graphics;
import java.util.ArrayList;

import ooad.model.DrawMode;
import ooad.model.IModel;
import ooad.model.shape.IShape;
import ooad.model.shape.IStringField;
import ooad.model.shape.NoneShape;

public class MovingMode extends AbstractMode{
	
	public MovingMode(IModel model) {
		super(model);
	}

	@Override
	public void addShapeString(IStringField stringField, String name) {
	}

	@Override
	public void setMode() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see ooad.model.mode.AbstractMode#drawing(java.awt.Graphics, ooad.model.Shape.IShape, int, int, int)
	 */
	@Override
	public void drawing(Graphics g, IShape shape, int mouseX, int mouseY,
			int closeOffset) {
		if(_model.isMousePressed()){
			int difX = _model.getPrevMouseX() - mouseX;
			int difY = _model.getPrevMouseY() - mouseY;
			for (IShape selectShape : _model.getSelectShapes()) 
				selectShape.movePos(difX, difY);
			for (IShape storeShape : _model.getStoreShapes())
				storeShape.drawShape(g);
			_model.setPrevMousePos(mouseX, mouseY);
		}
		else {
			_model.setUserMode(DrawMode.SELECT);
			_model.newShape(DrawMode.NONE);
			_model.setMouseDragging(false);
		}
	}
}
