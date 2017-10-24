package ooad.viewevent;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import ooad.model.IModel;
import ooad.model.Model;

public class CustomMouseEvent {
	private IModel _model;
	
	public CustomMouseEvent(IModel model) {
		this._model = model;
	}
	
	public CustomMousePressedEvent getPressedEvent() {
		return new CustomMousePressedEvent(_model);
	}
	
	public CustomMouseDraggedEvent getDraggedEvent() {
		return new CustomMouseDraggedEvent(_model);
	}
	
	public CustomMouseReleaseEvent getReleasedEvent() {
		return new CustomMouseReleaseEvent(_model);
	}
	
	private class CustomMousePressedEvent extends MouseAdapter{
		private IModel _model;
		
		public CustomMousePressedEvent(IModel model) {
			this._model = model;
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			_model.setMousePressed(true);
			_model.newShape();
			_model.setMouseXY(e.getX(), e.getY());
		}
	}

	private class CustomMouseDraggedEvent extends MouseAdapter{
		private IModel _model;
		
		public CustomMouseDraggedEvent(IModel model) {
			this._model = model;
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			_model.setMouseXY(e.getX(), e.getY());
			_model.setMouseDragging(true);
		}
	}

	private class CustomMouseReleaseEvent extends MouseAdapter{
		private IModel _model;
		
		public CustomMouseReleaseEvent(IModel model) {
			this._model = model;
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			_model.setMousePressed(false);
			_model.setMouseXY(e.getX(), e.getY());
		}
	}
}

