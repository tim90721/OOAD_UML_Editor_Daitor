package ooad.model.Shape;

import ooad.model.DrawMode;

public class ShapeFactory {
	public IShape getShape(DrawMode mode) {
		switch (mode) {
		case SELECT:
			return new NoneShape();
		case CLASS_MODE:
			return new ClassGraph(10, 10);
		default:
			return new NoneShape();
		}
	}
}
