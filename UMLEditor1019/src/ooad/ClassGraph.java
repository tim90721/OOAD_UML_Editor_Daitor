package ooad;

import java.awt.Graphics;

public class ClassGraph extends AbstractShape{
	private int x, y;
	
	public ClassGraph(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public void drawShape(Graphics g){
		g.drawRect(x, y, 60, 100);
	}
}
