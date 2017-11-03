package ooad.viewevent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import ooad.model.IEditNameObserver;
import ooad.model.IEditNameSubject;
import ooad.model.IMenuItemGroupObserver;
import ooad.model.IMenuItemGroupSubject;
import ooad.model.IModel;
import ooad.model.IPresentationModel;

public class CustomMenuEventGetter implements IMenuItemGroupSubject, IEditNameSubject{
	private IPresentationModel _presentationModel;
	private IModel _model;
	private ArrayList<IMenuItemGroupObserver> _groupObservers;
	private ArrayList<IEditNameObserver> _editNameObservers;
	
	public CustomMenuEventGetter(IPresentationModel presentationModel) {
		_presentationModel = presentationModel;
		_model = _presentationModel.getModel();
		_groupObservers = new ArrayList<IMenuItemGroupObserver>();
		_editNameObservers = new ArrayList<IEditNameObserver>();
	}
	
	public CustomMenuEvent getGroupMenuEvent(){
		return new MenuItemGroupEvent(_presentationModel);
	}
	
	public CustomMenuEvent getUnGroupMenuEvent(){
		return new MenuItemUnGroupEvent(_presentationModel);
	}
	
	public CustomMenuEvent getEditNameEvent(){
		return new MenuItemEditNameEvent(_presentationModel);
	}
	
	@Override
	public void registerMenuItemGroupObserver(IMenuItemGroupObserver observer) {
		_groupObservers.add(observer);
	}

	@Override
	public void notifyMenuItemGroupChange() {
		for (IMenuItemGroupObserver observer : _groupObservers) 
			observer.updateItem();
	}

	@Override
	public void registerEditNameObserver(IEditNameObserver observer) {
		_editNameObservers.add(observer);
	}

	@Override
	public void notifyEditName() {
		for (IEditNameObserver observer : _editNameObservers) 
			observer.updateEditName();
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
			notifyMenuItemGroupChange();
		}
	}
	
	private class MenuItemUnGroupEvent extends CustomMenuEvent{
		public MenuItemUnGroupEvent(IPresentationModel presentationModel) {
			super(presentationModel);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			_model.unGroupShapes();
			notifyMenuItemGroupChange();
		}
	}
	
	private class MenuItemEditNameEvent extends CustomMenuEvent{
		public MenuItemEditNameEvent(IPresentationModel presentationModel) {
			super(presentationModel);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			notifyEditName();
		}
	}
}
