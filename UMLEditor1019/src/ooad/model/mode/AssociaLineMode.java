package ooad.model.mode;

import java.awt.Graphics;

import ooad.model.DrawMode;
import ooad.model.IModel;
import ooad.model.shape.IShape;

public class AssociaLineMode extends BasicLineMode{
	
	public AssociaLineMode(IModel model) {
		super(model);
	}

	@Override
	public void setMode() {
		_model.setDrawMode(DrawMode.ASSOCIATION_LINE);
	}
}
