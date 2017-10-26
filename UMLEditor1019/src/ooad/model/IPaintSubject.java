package ooad.model;

public interface IPaintSubject {
	void registerPaintObserver(IPaintObserver observer);
	void unregisterPaintObserver(IPaintObserver observer);
	void notifyPaintChange();
}
