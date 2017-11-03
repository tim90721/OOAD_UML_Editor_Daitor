package ooad.model;

public interface IEditNameSubject {
	void registerEditNameObserver(IEditNameObserver observer);
	void notifyEditName();
}
