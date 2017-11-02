package ooad.viewevent;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import ooad.model.DrawMode;
import ooad.model.IModel;
import ooad.model.IPopMsgObserver;
import ooad.model.IPopMsgSubject;
import ooad.model.IPresentationModel;

public class CustomMouseEvent implements IPopMsgSubject{
	private IPresentationModel _presentationModel;
	private IModel _model;
	private ArrayList<IPopMsgObserver> _observers;
	
	public CustomMouseEvent(IPresentationModel presentationModel) {
		_presentationModel = presentationModel;
		this._model = _presentationModel.getModel();
		this._observers = new ArrayList<IPopMsgObserver>();
	}
	
	public CustomMousePressedEvent getPressedEvent() {
		return new CustomMousePressedEvent(_presentationModel);
	}
	
	public CustomMouseDraggedEvent getDraggedEvent() {
		return new CustomMouseDraggedEvent(_presentationModel);
	}
	
	public CustomMouseReleaseEvent getReleasedEvent() {
		return new CustomMouseReleaseEvent(_presentationModel);
	}
	
	@Override
	public void registerPopMsgObserver(IPopMsgObserver observer) {
		_observers.add(observer);
	}

	@Override
	public void unregisterPopMsgObserver(IPopMsgObserver observer) {
		_observers.remove(observer);
	}

	@Override
	public void notifyPopMsgObserver() {
		for (IPopMsgObserver observer : _observers) 
			observer.updatePopMsg();
	}

	private class CustomMousePressedEvent extends MouseAdapter{
		private IPresentationModel _presentationModel;
		private IModel _model;
		
		public CustomMousePressedEvent(IPresentationModel presentationModel) {
			_presentationModel = presentationModel;
			this._model = _presentationModel.getModel();
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			_model.setMousePressed(true);
			_model.setMouseMoving(false);
			_model.newShape();
			_model.setMousePos(e.getX(), e.getY());
		}
	}

	private class CustomMouseDraggedEvent extends MouseAdapter{
		private IPresentationModel _presentationModel;
		private IModel _model;
		
		public CustomMouseDraggedEvent(IPresentationModel presentationModel) {
			_presentationModel = presentationModel;
			this._model = _presentationModel.getModel();
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			_model.setMousePos(e.getX(), e.getY());
			_model.setMouseDragging(true);
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			super.mouseMoved(e);
			if(!_model.isMouseDragging()){
				if(!_model.isMouseMoving())
					_model.newShape(DrawMode.NONE);
				_model.setMouseMoving(true);
				_model.setMousePos(e.getX(), e.getY());
			}
		}
	}

	private class CustomMouseReleaseEvent extends MouseAdapter{
		private IPresentationModel _presentationModel;
		private IModel _model;
		
		public CustomMouseReleaseEvent(IPresentationModel presentationModel) {
			_presentationModel = presentationModel;
			this._model = _presentationModel.getModel();
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			_model.setMousePressed(false);
			_model.setMousePos(e.getX(), e.getY());
			notifyPopMsgObserver();
//			_presentationModel.
		}
	}
}

