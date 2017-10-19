package ooad.model;

import java.awt.Graphics;
import java.util.ArrayList;

public class Model {
	private ArrayList<AbstractShape> _shapes;
	
	public Model(){
		_shapes = new ArrayList<AbstractShape>();
	}
	
	public void draw(Graphics g) {
		IShape shape = new ClassGraph(50, 50);
		shape.drawShape(g);
	}
}
