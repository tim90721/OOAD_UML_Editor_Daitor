package ooad.model;

public interface IPresentationModel {
	void setSelectMode(boolean isSelect);
	void setAssociaLineMode(boolean isAssociaLine);
	void setGeneralLineMode(boolean isGeneralLine);
	void setCompositionLineMode(boolean isCompositionLine);
	void setClassMode(boolean isClassMode);
	void setUseCaseMode(boolean isUseCaseMode);
	void refreshState();
	IModel getModel();
	boolean isSelectMode();
	boolean isAssociaLineMode();
	boolean isGeneralLineMode();
	boolean isCompositionLineMode();
	boolean isClassMode();
	boolean isUseCaseMode();
}
