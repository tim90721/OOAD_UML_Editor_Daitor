package ooad.model.Shape;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class ClassGraph extends AbstractShape{
	public ClassGraph(){
	}
	
	public void drawShape(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(1));
		g2.drawRect(getEndX(), getEndY(), 60, 100);
	}
}
