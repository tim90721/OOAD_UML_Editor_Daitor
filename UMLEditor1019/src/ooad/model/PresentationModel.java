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
	}
	
	public IModel getModel(){
		return this._model;
	}

	@Override
	public void setSelectMode(boolean isSelect) {
		_isSelect = isSelect;
	}

	@Override
	public void setAssociaLineMode(boolean isAssociaLine) {
		_isAssociationLine = isAssociaLine;
	}

	@Override
	public void setGeneralLineMode(boolean isGeneralLine) {
		_isGeneralLine = isGeneralLine;
	}

	@Override
	public void setCompositionLineMode(boolean isCompositionLine) {
		_isCompositionLine = isCompositionLine;
	}

	@Override
	public void setClassMode(boolean isClassMode) {
		_isClassMode = isClassMode;
	}

	@Override
	public void setUseCaseMode(boolean isUseCaseMode) {
		_isUseCaseMode = isUseCaseMode;
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
