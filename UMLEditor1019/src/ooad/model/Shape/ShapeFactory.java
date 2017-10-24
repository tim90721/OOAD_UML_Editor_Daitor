package ooad.model.Shape;

import ooad.model.DrawMode;

public class ShapeFactory {
	public IShape getShape(DrawMode mode) {
		switch (mode) {
		case SELECT:
			return new NoneShape();
		case ASSOCIATION_LINE:
			return new AssociationLine();
		case GENERAL_LINE:
		case COMPOSITIONLINE:
		case CLASS_MODE:
			return new ClassGraph();
		case USECASE_MODE:
		default:
			return new NoneShape();
		}
	}
}
