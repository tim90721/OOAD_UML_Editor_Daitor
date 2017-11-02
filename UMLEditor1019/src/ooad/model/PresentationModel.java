package ooad.model;

public class PresentationModel implements IPresentationModel{
	private Model _model;
	private boolean _isSelect;
	private boolean _isAssociationLine;
	private boolean _isGeneralLine;
	private boolean _isCompositionLine;
	private boolean _isClassMode;
	private boolean _isUseCaseMode;
	private boolean _canGroup;
	private boolean _canUngroup;
	
	public PresentationModel(Model model){
		this._model = model;
		setSelectMode(true);
	}
	
	public IModel getModel(){
		return this._model;
	}

	@Override
	public void setSelectMode(boolean isSelect) {
		_isSelect = isSelect;
		_model.setDrawMode(DrawMode.SELECT);
	}

	@Override
	public void setAssociaLineMode(boolean isAssociaLine) {
		_isAssociationLine = isAssociaLine;
		_model.setDrawMode(DrawMode.ASSOCIATION_LINE);
	}

	@Override
	public void setGeneralLineMode(boolean isGeneralLine) {
		_isGeneralLine = isGeneralLine;
		_model.setDrawMode(DrawMode.GENERAL_LINE);
	}

	@Override
	public void setCompositionLineMode(boolean isCompositionLine) {
		_isCompositionLine = isCompositionLine;
		_model.setDrawMode(DrawMode.COMPOSITIONLINE);
	}

	@Override
	public void setClassMode(boolean isClassMode) {
		_isClassMode = isClassMode;
		_model.setDrawMode(DrawMode.CLASS_MODE);
	}

	@Override
	public void setUseCaseMode(boolean isUseCaseMode) {
		_isUseCaseMode = isUseCaseMode;
		_model.setDrawMode(DrawMode.USECASE_MODE);
	}

	@Override
	public void setCanGroup() {
		_canGroup = _model.checkCanGroup();
	}

	@Override
	public void setCanUngroup() {
		_canUngroup = _model.checkCanUnGroup();
	}

	@Override
	public void refreshButtonState() {
		_isSelect = false;
		_isAssociationLine = false;
		_isGeneralLine = false;
		_isCompositionLine = false;
		_isClassMode = false;
		_isUseCaseMode = false;
	}

	@Override
	public boolean isSelectMode() {
		return _isSelect;
	}

	@Override
	public boolean isAssociaLineMode() {
		return _isAssociationLine;
	}

	@Override
	public boolean isGeneralLineMode() {
		return _isGeneralLine;
	}

	@Override
	public boolean isCompositionLineMode() {
		return _isCompositionLine;
	}

	@Override
	public boolean isClassMode() {
		return _isClassMode;
	}

	@Override
	public boolean isUseCaseMode() {
		return _isUseCaseMode;
	}

	@Override
	public boolean canGroup() {
		return _canGroup;
	}

	@Override
	public boolean canUngroup() {
		return _canUngroup;
	}
}
