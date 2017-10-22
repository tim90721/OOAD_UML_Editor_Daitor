package ooad.model.Shape;

import ooad.model.DrawMode;

public class ShapeFactory {
	public IShape getShape(DrawMode mode) {
		switch (mode) {
		case SELECT:
			return new NoneShape();
		case ASSOCIATION_LINE:
		case CLASS_MODE:
			return new ClassGraph();
		default:
			return new NoneShape();
		}
	}
}
