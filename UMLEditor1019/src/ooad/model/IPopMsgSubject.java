package ooad.model;

public interface IPopMsgSubject {
	void registerPopMsgObserver(IPopMsgObserver observer);
	void unregisterPopMsgObserver(IPopMsgObserver observer);
	void notifyPopMsgObserver();
}
