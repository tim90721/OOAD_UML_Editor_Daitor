package ooad.model.shape;

import ooad.model.DrawMode;

public class ShapeFactory {
	public IShape getShape(DrawMode mode) {
		switch (mode) {
		case SELECT:
			return new SelectShape();
		case ASSOCIATION_LINE:
			return new AssociationLine();
		case GENERAL_LINE:
			return new GeneralLine();
		case COMPOSITIONLINE:
			return new CompositionLine();
		case CLASS_MODE:
			return new ClassGraph();
		case USECASE_MODE:
			return new UseCaseShape();
		case GROUP:
			return new GroupShape();
		default:
			return new NoneShape();
		}
	}
}
