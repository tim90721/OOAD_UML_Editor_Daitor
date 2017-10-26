package ooad.viewevent;

import javax.swing.JButton;

import ooad.model.IPaintObserver;
import ooad.model.IPresentationModel;

public class ButtonEnable implements IPaintObserver{
	private JButton _btnSelect;
	private JButton _btnAssociaLine;
	private JButton _btnGeneralLine;
	private JButton _btnCompositionLine;
	private JButton _btnClass;
	private JButton _btnUseCase;
	private IPresentationModel _presentationModel;
	
	public ButtonEnable(JButton btnSelect, JButton btnAssociaLine, JButton btnGeneralLine,
			JButton btnCompositionLine, JButton btnClass, JButton btnUseCase, IPresentationModel presentationModel) {
		_btnSelect = btnSelect;
		_btnAssociaLine = btnAssociaLine;
		_btnGeneralLine = btnGeneralLine;
		_btnCompositionLine = btnCompositionLine;
		_btnClass = btnClass;
		_btnUseCase = btnUseCase;
		_presentationModel = presentationModel;
		RefreshControl();
	}

	@Override
	public void updatePaint() {
		RefreshControl();
	}

	public void RefreshControl(){
		_btnSelect.setEnabled(!_presentationModel.isSelectMode());
		_btnAssociaLine.setEnabled(!_presentationModel.isAssociaLineMode());
		_btnGeneralLine.setEnabled(!_presentationModel.isGeneralLineMode());
		_btnCompositionLine.setEnabled(!_presentationModel.isCompositionLineMode());
		_btnClass.setEnabled(!_presentationModel.isClassMode());
		_btnUseCase.setEnabled(!_presentationModel.isUseCaseMode());
	}
}
