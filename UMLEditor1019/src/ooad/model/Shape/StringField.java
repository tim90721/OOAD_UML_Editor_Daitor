package ooad.model.Shape;

import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class StringField extends AbstractAreaShape{
	private AbstractAreaShape _parent;
	private String _name;
	
	public StringField(AbstractAreaShape shape, String name){
		_parent = shape;
		_name = name;
	}

	@Override
	public void drawShape(Graphics g) {
		_parent.drawShape(g);
		super.drawShape(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setFont(new Font("Arial Black", Font.PLAIN, 20));
		g2.drawString(_name, getStartX(), getStartY());
	}
}
