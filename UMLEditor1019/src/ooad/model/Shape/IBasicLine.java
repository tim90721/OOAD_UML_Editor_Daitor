package ooad.model.Shape;

public interface IBasicLine {
	void setMiddle();
	void setDirection(Direction direction);
	Direction getDirection();
	void setDifX(int difX);
	void setDifY(int difY);
	int getDifX();
	int getDifY();
	void setAngle(double angle);
	void setAngle(int difX, int difY);
	double getAngle();
}
