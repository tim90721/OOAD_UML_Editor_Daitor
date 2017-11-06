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

/**
 * custom menu event handler getter
 * @author Daitor
 *
 */
public class CustomMenuEventGetter implements IMenuItemGroupSubject, IEditNameSubject{
	private IPresentationModel _presentationModel;
	private IModel _model;
	private ArrayList<IMenuItemGroupObserver> _groupObservers;
	private ArrayList<IEditNameObserver> _editNameObservers;
	
	/**
	 * constructor
	 * @param presentationModel presentation model
	 */
	public CustomMenuEventGetter(IPresentationModel presentationModel) {
		_presentationModel = presentationModel;
		_model = _presentationModel.getModel();
		_groupObservers = new ArrayList<IMenuItemGroupObserver>();
		_editNameObservers = new ArrayList<IEditNameObserver>();
	}
	
	/**
	 * get group menu event handler
	 * @return group menu event handler
	 */
	public CustomMenuEvent getGroupMenuEvent(){
		return new MenuItemGroupEvent(_presentationModel);
	}
	
	/**
	 * get ungroup menu event handler
	 * @return ungroup menu event handler
	 */
	public CustomMenuEvent getUnGroupMenuEvent(){
		return new MenuItemUnGroupEvent(_presentationModel);
	}
	
	/**
	 * get menu item edit name event handler
	 * @return menu item edit name event handler
	 */
	public CustomMenuEvent getEditNameEvent(){
		return new MenuItemEditNameEvent(_presentationModel);
	}
	
	/**
	 * register menu item group click event listener
	 */
	@Override
	public void registerMenuItemGroupObserver(IMenuItemGroupObserver observer) {
		_groupObservers.add(observer);
	}

	/**
	 * notify observer for menu item group click
	 */
	@Override
	public void notifyMenuItemGroupChange() {
		for (IMenuItemGroupObserver observer : _groupObservers) 
			observer.updateItem();
	}

	/**
	 * register menu item edit name click event listener
	 */
	@Override
	public void registerEditNameObserver(IEditNameObserver observer) {
		_editNameObservers.add(observer);
	}

	/**
	 * notify menu item edit name click event
	 */
	@Override
	public void notifyEditName() {
		for (IEditNameObserver observer : _editNameObservers) 
			observer.updateEditName();
	}

	/**
	 * general operation for custom menu event handler
	 * @author Daitor
	 *
	 */
	abstract class CustomMenuEvent implements ActionListener{
		private IPresentationModel _presentationModel;
		private IModel _model;
		
		public CustomMenuEvent(IPresentationModel presentationModel) {
			_presentationModel = presentationModel;
			_model = _presentationModel.getModel();
		}
	}
	
	/**
	 * menu item group click event handler
	 * @author Daitor
	 *
	 */
	private class MenuItemGroupEvent extends CustomMenuEvent{
		public MenuItemGroupEvent(IPresentationModel presentationModel) {
			super(presentationModel);
		}

		/**
		 * handle menu item group click event
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			_model.groupShapes();;
			notifyMenuItemGroupChange();
		}
	}
	
	/**
	 * menu item ungroup click event handler
	 * @author Daitor
	 *
	 */
	private class MenuItemUnGroupEvent extends CustomMenuEvent{
		public MenuItemUnGroupEvent(IPresentationModel presentationModel) {
			super(presentationModel);
		}

		/**
		 * handle menu item ungroup click event
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			_model.unGroupShapes();
			notifyMenuItemGroupChange();
		}
	}
	
	/**
	 * menu item edit name event handler
	 * @author Daitor
	 *
	 */
	private class MenuItemEditNameEvent extends CustomMenuEvent{
		public MenuItemEditNameEvent(IPresentationModel presentationModel) {
			super(presentationModel);
		}

		/**
		 * handle menu item edit name event
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			notifyEditName();
		}
	}
}
