package ooad.model;

public interface IModeSwitchSubject {
	void registerBtnEnableObserver(IModeSwitchObserver observer);
	void notifyModeChange();
}
