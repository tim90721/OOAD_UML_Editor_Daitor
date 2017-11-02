package ooad.model;

public interface IPresentationModel {
	void setSelectMode(boolean isSelect);
	void setAssociaLineMode(boolean isAssociaLine);
	void setGeneralLineMode(boolean isGeneralLine);
	void setCompositionLineMode(boolean isCompositionLine);
	void setClassMode(boolean isClassMode);
	void setUseCaseMode(boolean isUseCaseMode);
	void setCanGroup();
	void setCanUngroup();
	void refreshButtonState();
	IModel getModel();
	boolean isSelectMode();
	boolean isAssociaLineMode();
	boolean isGeneralLineMode();
	boolean isCompositionLineMode();
	boolean isClassMode();
	boolean isUseCaseMode();
	boolean canGroup();
	boolean canUngroup();
}
