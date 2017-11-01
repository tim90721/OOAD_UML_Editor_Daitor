package ooad.model.Shape;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;

public class StringField extends AbstractAreaShape implements IStringField{
	private AbstractAreaShape _parent;
	private String _nameField;
	private Font _font;
	private int _fontSize = 20;
	private int _fontPixelWidth;
	private int _fontPixelHeight;
	
	public StringField(AbstractAreaShape shape, String name){
		_name = "StringField";
		_parent = shape;
		_nameField = name;
		_font = new Font("Arial Black", Font.PLAIN, _fontSize);
		AffineTransform affineTransform = _font.getTransform();
		FontRenderContext context = new FontRenderContext(affineTransform, true, true);
		_fontPixelWidth = (int)(_font.getStringBounds(_nameField, context).getWidth());
		_fontPixelHeight = (int)(_font.getStringBounds(_nameField, context).getHeight());
		_parent.setWidth(2 * _fontSize + _fontPixelWidth);
		_parent.setHeight(2 * _fontSize + _fontPixelHeight);
	}

	@Override
	public void drawShape(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setFont(new Font("Arial Black", Font.PLAIN, _fontSize));
		_parent.drawShape(g);
		g2.drawString(_nameField, _startX, _startY);
	}

	@Override
	public void isLineEnclose(IShape line, int mouseLineX, int mouseLineY, int closeOffset) {
		_parent.isLineEnclose(line, mouseLineX, mouseLineY, closeOffset);
	}
	
	@Override
	public boolean isLineEnclose(int mouseLineX, int mouseLineY, int closeOffset) {
		return _parent.isLineEnclose(mouseLineX, mouseLineY, closeOffset);
	}

	@Override
	public int getFontSize(){
		return _fontSize;
	}
	
	@Override
	public void setName(String name) {
		_nameField = name;
	}

	@Override
	public String getName() {
		return _nameField;
	}

	@Override
	public void setFontSize(int fontSize) {
		_fontSize = fontSize;
	}

	@Override
	public int getFontPixelWidth() {
		return _fontPixelWidth;
	}

	@Override
	public int getFontPixelHeight() {
		return _fontPixelHeight;
	}

	@Override
	public void setLineStartPos(IShape line) {
		_parent.setLineStartPos(line);
	}

	@Override
	public void setLineEndPos(IShape line) {
		_parent.setLineEndPos(line);
	}

	@Override
	public int getStartX() {
		return _parent.getStartX();
	}

	@Override
	public int getEndX() {
		return _parent.getEndX();
	}

	@Override
	public int getStartY() {
		return _parent.getStartY();
	}

	@Override
	public int getEndY() {
		return _parent.getEndY();
	}

	@Override
	public void setSelected(boolean isSelect) {
		_parent.setSelected(isSelect);
	}

	@Override
	public boolean isSelected() {
		return _parent.isSelected();
	}

	@Override
	public void addShapeString(IStringField stringField, String name) {
		// TODO Auto-generated method stub
		
	}
}
