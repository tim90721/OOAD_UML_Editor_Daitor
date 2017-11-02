package ooad.model;

public interface IMenuItemChangeSubject {
	void registerMenuItemObserver(IMenuItemChangeObserver observer);
	void notifyMenuItemChange();
}
