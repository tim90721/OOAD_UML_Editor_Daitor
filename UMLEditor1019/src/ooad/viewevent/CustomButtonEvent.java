package ooad.viewevent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observer;

import ooad.model.IModeSwitchObserver;
import ooad.model.IModeSwitchSubject;
import ooad.model.IModel;
import ooad.model.IPaintObserver;
import ooad.model.IPresentationModel;

public class CustomButtonEvent implements IModeSwitchSubject{
	private IPresentationModel _presentationModel;
	private IModel _model;
	private IModeSwitchObserver _oBtnEnable;
	
	public CustomButtonEvent(IPresentationModel presentationModel){
		this._presentationModel = presentationModel;
		this._model = this._presentationModel.getModel();
	}
	
	@Override
	public void registerBtnEnableObserver(IModeSwitchObserver observer){
		_oBtnEnable = observer;
	}
	
	@Override
	public void notifyModeChange(){
		_oBtnEnable.updateMode();;
	}
	
	public BtnSelectClickEvent getSelectClickEvent(){
		return new BtnSelectClickEvent(_presentationModel);
	}
	
	public BtnAssociaLineClickEvent getAssociaLineClickEvent(){
		return new BtnAssociaLineClickEvent(_presentationModel);
	}
	
	public BtnGeneralLineClickEvent getGeneralLineClickEvent(){
		return new BtnGeneralLineClickEvent(_presentationModel);
	}
	
	public BtnCompositionLineClickEvent getCompositionLineClickEvent(){
		return new BtnCompositionLineClickEvent(_presentationModel);
	}
	
	public BtnClassModeClickEvent getClassModeClickEvent(){
		return new BtnClassModeClickEvent(_presentationModel);
	}
	
	public BtnUseCaseModeClickEvent getUseCaseModeClickEvent(){
		return new BtnUseCaseModeClickEvent(_presentationModel);
	}
	
	class CustomBtnEvent implements ActionListener{
		private IPresentationModel _presentationModel;
		private IModel _model;
		
		public CustomBtnEvent(IPresentationModel presentationModel){
			this._presentationModel = presentationModel;
			this._model = this._presentationModel.getModel();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			_presentationModel.refreshState();
		}
	}
	
	private class BtnSelectClickEvent extends CustomBtnEvent{
		
		public BtnSelectClickEvent(IPresentationModel presentationModel) {
			super(presentationModel);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			super.actionPerformed(e);
			_presentationModel.setSelectMode(true);
			notifyModeChange();
		}
	}
	
	private class BtnAssociaLineClickEvent extends CustomBtnEvent{
		
		public BtnAssociaLineClickEvent(IPresentationModel presentationModel){
			super(presentationModel);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			super.actionPerformed(e);
			_presentationModel.setAssociaLineMode(true);
			notifyModeChange();
		}
	}
	
	private class BtnGeneralLineClickEvent extends CustomBtnEvent{
		
		public BtnGeneralLineClickEvent(IPresentationModel presentationModel){
			super(presentationModel);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			super.actionPerformed(e);
			_presentationModel.setGeneralLineMode(true);
			notifyModeChange();
		}
	}
	
	private class BtnCompositionLineClickEvent extends CustomBtnEvent{
		
		public BtnCompositionLineClickEvent(IPresentationModel presentationModel){
			super(presentationModel);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			super.actionPerformed(e);
			_presentationModel.setCompositionLineMode(true);
			notifyModeChange();
		}
	}
	
	private class BtnClassModeClickEvent extends CustomBtnEvent{
		
		public BtnClassModeClickEvent(IPresentationModel presentationModel){
			super(presentationModel);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			super.actionPerformed(e);
			_presentationModel.setClassMode(true);
			notifyModeChange();
		}
	}
	
	private class BtnUseCaseModeClickEvent extends CustomBtnEvent{
		
		public BtnUseCaseModeClickEvent(IPresentationModel presentationModel){
			super(presentationModel);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			super.actionPerformed(e);
			_presentationModel.setUseCaseMode(true);
			notifyModeChange();
		}
	}
}

