package ooad.model.Shape;

import java.awt.Graphics;

public class NoneShape extends AbstractShape{
	@Override
	public void drawShape(Graphics g) {
	}

	@Override
	public void setLineStartPos(IShape line) {
	}

	@Override
	public void setLineEndPos(IShape line) {
	}

	@Override
	public boolean isLine() {
		return true;
	}
}
