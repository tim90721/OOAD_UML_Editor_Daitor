package ooad.model.Shape;

public interface IStringField extends IShape{
	void setName(String name);
	String getName();
	void setFontSize(int fontSize);
	int getFontSize();
	int getFontPixelWidth();
	int getFontPixelHeight();
}
