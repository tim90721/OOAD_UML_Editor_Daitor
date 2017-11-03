package ooad.model;

public interface IMenuItemGroupSubject {
	void registerMenuItemGroupObserver(IMenuItemGroupObserver observer);
	void notifyMenuItemGroupChange();
}
