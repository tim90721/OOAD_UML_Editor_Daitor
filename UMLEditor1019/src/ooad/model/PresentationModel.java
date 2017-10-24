package ooad.model;

public class PresentationModel implements IPresentationModel{
	private Model _model;
	private boolean _isSelect;
	private boolean _isAssociationLine;
	private boolean _isGeneralLine;
	private boolean _isCompositionLine;
	private boolean _isClassMode;
	private boolean _isUseCaseMode;
	
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
		_model.setState(DrawMode.SELECT);
	}

	@Override
	public void setAssociaLineMode(boolean isAssociaLine) {
		_isAssociationLine = isAssociaLine;
		_model.setState(DrawMode.ASSOCIATION_LINE);
	}

	@Override
	public void setGeneralLineMode(boolean isGeneralLine) {
		_isGeneralLine = isGeneralLine;
		_model.setState(DrawMode.GENERAL_LINE);
	}

	@Override
	public void setCompositionLineMode(boolean isCompositionLine) {
		_isCompositionLine = isCompositionLine;
		_model.setState(DrawMode.COMPOSITIONLINE);
	}

	@Override
	public void setClassMode(boolean isClassMode) {
		_isClassMode = isClassMode;
		_model.setState(DrawMode.CLASS_MODE);
	}

	@Override
	public void setUseCaseMode(boolean isUseCaseMode) {
		_isUseCaseMode = isUseCaseMode;
		_model.setState(DrawMode.USECASE_MODE);
	}

	@Override
	public void refreshState() {
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
}
