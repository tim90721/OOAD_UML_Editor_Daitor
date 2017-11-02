package ooad.viewevent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ooad.model.IModel;
import ooad.model.IPresentationModel;

public class CustomMenuEventGetter {
	private IPresentationModel _presentationModel;
	private IModel _model;
	
	public CustomMenuEventGetter(IPresentationModel presentationModel) {
		_presentationModel = presentationModel;
		_model = _presentationModel.getModel();
	}
	
	public CustomMenuEvent getGroupMenuEvent(){
		return new MenuItemGroupEvent(_presentationModel);
	}
	
	public CustomMenuEvent getUnGroupMenuEvent(){
		return new MenuItemUnGroupEvent(_presentationModel);
	}
	
	abstract class CustomMenuEvent implements ActionListener{
		private IPresentationModel _presentationModel;
		private IModel _model;
		
		public CustomMenuEvent(IPresentationModel presentationModel) {
			_presentationModel = presentationModel;
			_model = _presentationModel.getModel();
		}
	}
	
	private class MenuItemGroupEvent extends CustomMenuEvent{
		public MenuItemGroupEvent(IPresentationModel presentationModel) {
			super(presentationModel);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			_model.groupShapes();;
		}
	}
	
	private class MenuItemUnGroupEvent extends CustomMenuEvent{
		public MenuItemUnGroupEvent(IPresentationModel presentationModel) {
			super(presentationModel);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			_model.unGroupShapes();
		}
	}
}
