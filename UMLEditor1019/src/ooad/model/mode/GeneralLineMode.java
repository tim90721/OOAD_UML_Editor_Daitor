package ooad.model.mode;

import java.awt.Graphics;

import ooad.model.DrawMode;
import ooad.model.IModel;

public class GeneralLineMode extends BasicLineMode {

	public GeneralLineMode(IModel model) {
		super(model);
	}

	@Override
	public void setMode() {
		_model.setDrawMode(DrawMode.GENERAL_LINE);
	}
}
