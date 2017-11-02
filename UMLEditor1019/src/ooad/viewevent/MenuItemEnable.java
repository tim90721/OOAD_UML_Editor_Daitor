package ooad.viewevent;

import javax.swing.JMenuItem;

import ooad.model.IMenuItemChangeObserver;
import ooad.model.IPresentationModel;

public class MenuItemEnable implements IMenuItemChangeObserver{
	private JMenuItem _itemGroup;
	private JMenuItem _itemUngroup;
	private IPresentationModel _presentationModel;

	public MenuItemEnable(JMenuItem itemGroup, JMenuItem itemUngroup,
			IPresentationModel presentationModel) {
		_itemGroup = itemGroup;
		_itemUngroup = itemUngroup;
		_presentationModel = presentationModel;
	}

	@Override
	public void updateItem() {
		_presentationModel.setCanGroup();
		_presentationModel.setCanUngroup();
		refreshControl();
	}
	
	private void refreshControl() {
		_itemGroup.setEnabled(_presentationModel.canGroup()); 
		_itemUngroup.setEnabled(_presentationModel.canUngroup());
	}
}
