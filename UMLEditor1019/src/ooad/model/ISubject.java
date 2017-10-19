package ooad.model;

public interface ISubject {
	void registerObserver(IObserver observer);
	void unregisterObserver(IObserver observer);
	void notifyChange();
}
