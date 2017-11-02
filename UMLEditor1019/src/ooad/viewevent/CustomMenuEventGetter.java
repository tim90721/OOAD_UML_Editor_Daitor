package ooad.viewevent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import ooad.model.IMenuItemChangeObserver;
import ooad.model.IMenuItemChangeSubject;
import ooad.model.IModel;
import ooad.model.IPresentationModel;

public class CustomMenuEventGetter implements IMenuItemChangeSubject{
	private IPresentationModel _presentationModel;
	private IModel _model;
	private ArrayList<IMenuItemChangeObserver> _observers;
	
	public CustomMenuEventGetter(IPresentationModel presentationModel) {
		_presentationModel = presentationModel;
		_model = _presentationModel.getModel();
		_observers = new ArrayList<IMenuItemChangeObserver>();
	}
	
	public CustomMenuEvent getGroupMenuEvent(){
		return new MenuItemGroupEvent(_presentationModel);
	}
	
	public CustomMenuEvent getUnGroupMenuEvent(){
		return new MenuItemUnGroupEvent(_presentationModel);
	}
	
	@Override
	public void registerMenuItemObserver(IMenuItemChangeObserver observer) {
		_observers.add(observer);
	}

	@Override
	public void notifyMenuItemChange() {
		for (IMenuItemChangeObserver observer : _observers) 
			observer.updateItem();
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
			notifyMenuItemChange();
		}
	}
	
	private class MenuItemUnGroupEvent extends CustomMenuEvent{
		public MenuItemUnGroupEvent(IPresentationModel presentationModel) {
			super(presentationModel);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			_model.unGroupShapes();
			notifyMenuItemChange();
		}
	}
}
