package ooad.model.mode;

import java.awt.Graphics;

import ooad.model.DrawMode;
import ooad.model.IModel;

public class CompositionLineMode extends BasicLineMode{
	
	public CompositionLineMode(IModel model) {
		super(model);
	}

	@Override
	public void draw(Graphics g) {
	}

	@Override
	public void setMode() {
		_model.setDrawMode(DrawMode.COMPOSITIONLINE);
	}
}
