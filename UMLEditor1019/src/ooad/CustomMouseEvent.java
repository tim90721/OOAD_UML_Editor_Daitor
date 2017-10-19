package ooad;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import ooad.model.Model;

public class CustomMouseEvent {
	private Model _model;
	
	public CustomMouseEvent(Model model) {
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
	
}

class CustomMousePressedEvent extends MouseAdapter{
	private Model _model;
	
	public CustomMousePressedEvent(Model model) {
		this._model = model;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO
	}
}

class CustomMouseDraggedEvent extends MouseAdapter{
	private Model _model;
	
	public CustomMouseDraggedEvent(Model model) {
		this._model = model;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
	}
}

class CustomMouseReleaseEvent extends MouseAdapter{
	private Model _model;
	
	public CustomMouseReleaseEvent(Model model) {
		this._model = model;
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}
}