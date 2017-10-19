package ooad;

import java.awt.Graphics;

public class ClassGraph extends AbstractShape{
	private int x, y;
	
	public ClassGraph(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void SetX(int x){
		this.x = x;
	}
	
	public void SetY(int y){
		this.y = y;
	}
	
	public int GetX(){
		return this.x;
	}
	
	public int GetY(){
		return this.y;
	}
	
	public void Draw(Graphics g){
		g.drawRect(x, y, 60, 100);
	}
}
