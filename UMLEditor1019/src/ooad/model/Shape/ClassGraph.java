package ooad.model.Shape;

import java.awt.Graphics;

public class ClassGraph extends AbstractShape{
	private int x, y;
	
	public ClassGraph(){
	}
	
	public void drawShape(Graphics g){
		g.drawRect(x, y, 60, 100);
	}
}
