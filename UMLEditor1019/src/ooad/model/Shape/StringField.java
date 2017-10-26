package ooad.model.Shape;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class StringField extends AbstractAreaShape{
	private AbstractAreaShape _parent;
	private String _name;
	private int _fontSize = 20;
	private Font _font;
	private int _fontPixelSize;
	
	public StringField(AbstractAreaShape shape, String name){
		_parent = shape;
		_name = name;
		_font = new Font("Arial Black", Font.PLAIN, _fontSize);
		_fontPixelSize = _font.getSize();
		setStart(_parent.getStartX() + _fontSize, _parent.getStartY() + _fontSize);
	}

	@Override
	public void drawShape(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		super.drawShape(g);
		g2.setFont(new Font("Arial Black", Font.PLAIN, _fontSize));
		_parent.setWidth(_fontSize + _name.length() * _fontPixelSize);
		_parent.drawShape(g);
		g2.drawString(_name, getStartX(), getStartY());
	}

	@Override
	public void isLineEnclose(IShape line, int mouseLineX, int mouseLineY, int closeOffset) {
	}
}
