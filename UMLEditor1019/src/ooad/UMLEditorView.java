package ooad;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ooad.model.DrawMode;
import ooad.model.IEditNameObserver;
import ooad.model.IMenuItemGroupSubject;
import ooad.model.IModel;
import ooad.model.IPopMsgObserver;
import ooad.model.IPresentationModel;
import ooad.model.Model;
import ooad.model.PresentationModel;
import ooad.viewevent.ButtonEnable;
import ooad.viewevent.CustomButtonEventGetter;
import ooad.viewevent.CustomMenuEventGetter;
import ooad.viewevent.CustomMouseEvent;
import ooad.viewevent.MenuItemEnable;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.IOException;
import java.util.jar.Attributes.Name;
import java.awt.Canvas;
import java.awt.Font;

public class UMLEditorView extends JFrame implements IPopMsgObserver,
		IEditNameObserver {

	private JPanel _panelContentPane;
	private JMenuBar _menuBar;
	private JMenu _menuFile;
	private JMenu _menuEdit;
	private JMenuItem _itemEditName;
	private JMenuItem _itemAddNewName;
	private JMenuItem _itemGroup;
	private JMenuItem _itemUnGroup;
	private JButton _btnSelect;
	private JButton _btnAssociaLine;
	private JButton _btnGeneralLine;
	private JButton _btnCompositionLine;
	private JButton _btnClass;
	private JButton _btnUseCase;
	private PaintPanel _pPanel;
	private IPresentationModel _presentationModel;
	private IModel _model;
	private final String MOUSE_IMAGE = "Mouse.jpg";
	private final String ASSOCIATIONLINE_IMAGE = "AssociationLine.jpg";
	private final String GENERALLINE_IMAGE = "GernalizationLine.jpg";
	private final String COMPOSITIONLINE_IMAGE = "CompositionLine.jpg";
	private final String CLASS_IMAGE = "Class.jpg";
	private final String USECASE_IMAGE = "UseCase.jpg";
	private final int IMAGE_SIZE = 40;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UMLEditorView frame = new UMLEditorView(
							new PresentationModel(new Model()));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UMLEditorView(IPresentationModel presentationModel) {
		this._presentationModel = presentationModel;
		this._model = this._presentationModel.getModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("UMLEditor");
		setBounds(100, 100, 1000, 800);

		_panelContentPane = new JPanel();
		_panelContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(_panelContentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0,
				Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		_panelContentPane.setLayout(gbl_contentPane);

		initiateComponent();

		CustomMouseEvent mouseEvent = new CustomMouseEvent(_presentationModel);
		mouseEvent.registerPopMsgObserver(this);

		_pPanel = new PaintPanel(_model, mouseEvent);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 7;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		gbc_panel.fill = GridBagConstraints.BOTH;
		_panelContentPane.add(_pPanel, gbc_panel);
	}

	private void initiateComponent() {
		initiateMenu();
		initiateButtons();
		initiateButtonIcon();
	}

	private void initiateMenu() {
		CustomMenuEventGetter menuEventGetter = new CustomMenuEventGetter(
				_presentationModel);
		_menuBar = new JMenuBar();
		setJMenuBar(_menuBar);

		_menuFile = new JMenu("File");
		_menuFile.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		_menuBar.add(_menuFile);

		_menuEdit = new JMenu("Edit");
		_menuEdit.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		_menuBar.add(_menuEdit);

		_itemEditName = new JMenuItem("Edit Name");
		_itemEditName.addActionListener(menuEventGetter.getEditNameEvent());
		_menuEdit.add(_itemEditName);

		_itemAddNewName = new JMenuItem("Add New Name");
		_menuEdit.add(_itemAddNewName);

		_menuEdit.addSeparator();

		_itemGroup = new JMenuItem("Group");
		_itemGroup.addActionListener(menuEventGetter.getGroupMenuEvent());
		_menuEdit.add(_itemGroup);

		_itemUnGroup = new JMenuItem("UnGroup");
		_itemUnGroup.addActionListener(menuEventGetter.getUnGroupMenuEvent());
		_menuEdit.add(_itemUnGroup);

		MenuItemEnable menuItemEnable = new MenuItemEnable(_itemGroup,
				_itemUnGroup, _itemEditName, _itemAddNewName, _presentationModel);
		((IMenuItemGroupSubject) _model)
				.registerMenuItemGroupObserver(menuItemEnable);
		menuEventGetter.registerMenuItemGroupObserver(menuItemEnable);
		menuEventGetter.registerEditNameObserver(this);
	}

	private void initiateButtons() {
		CustomButtonEventGetter buttonEvent = new CustomButtonEventGetter(
				_presentationModel);

		_btnSelect = new JButton();
		configButton(_btnSelect, 0);
		_btnSelect.addActionListener(buttonEvent.getSelectClickEvent());

		_btnAssociaLine = new JButton();
		configButton(_btnAssociaLine, 1);
		_btnAssociaLine.addActionListener(buttonEvent
				.getAssociaLineClickEvent());

		_btnGeneralLine = new JButton();
		configButton(_btnGeneralLine, 2);
		_btnGeneralLine.addActionListener(buttonEvent
				.getGeneralLineClickEvent());

		_btnCompositionLine = new JButton();
		configButton(_btnCompositionLine, 3);
		_btnCompositionLine.addActionListener(buttonEvent
				.getCompositionLineClickEvent());

		_btnClass = new JButton();
		configButton(_btnClass, 4);
		_btnClass.addActionListener(buttonEvent.getClassModeClickEvent());

		_btnUseCase = new JButton();
		configButton(_btnUseCase, 5);
		_btnUseCase.addActionListener(buttonEvent.getUseCaseModeClickEvent());

		ButtonEnable btnEnable = new ButtonEnable(_btnSelect, _btnAssociaLine,
				_btnGeneralLine, _btnCompositionLine, _btnClass, _btnUseCase,
				_presentationModel);

		buttonEvent.registerBtnEnableObserver(btnEnable);
	}

	private void configButton(JButton button, int index) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = index;
		_panelContentPane.add(button, gbc);
		button.setContentAreaFilled(false);
		button.setFocusPainted(true);
		button.setMargin(new Insets(0, 0, 0, 0));
	}

	private void initiateButtonIcon() {
		setButtonIcon(_btnSelect, MOUSE_IMAGE);
		setButtonIcon(_btnAssociaLine, ASSOCIATIONLINE_IMAGE);
		setButtonIcon(_btnGeneralLine, GENERALLINE_IMAGE);
		setButtonIcon(_btnCompositionLine, COMPOSITIONLINE_IMAGE);
		setButtonIcon(_btnClass, CLASS_IMAGE);
		setButtonIcon(_btnUseCase, USECASE_IMAGE);
	}

	private void setButtonIcon(JButton button, String IconName) {
		String path = "img/" + IconName;
		try {
			Image image = ImageIO.read(getClass().getResource(path));
			Image scaleImage = image.getScaledInstance(IMAGE_SIZE, IMAGE_SIZE,
					Image.SCALE_REPLICATE);
			button.setIcon(new ImageIcon(scaleImage));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("!!Image NOT FOUND!!");
		}
	}

	@Override
	public void updatePopMsg() {
		if (_model.getDrawMode() == DrawMode.CLASS_MODE
				|| _model.getDrawMode() == DrawMode.USECASE_MODE) {
			String name = showMsgBox();
			_model.addShapeString(name);
		}
	}

	@Override
	public void updateEditName() {
		String name = showMsgBox();
		_model.editShapeName(name);
	}

	private String showMsgBox() {
		String name = (String) JOptionPane.showInputDialog(this, "class name:",
				"Set Name", JOptionPane.PLAIN_MESSAGE, null, null, null);
		if(name == null)
			name = " ";
		return name;
	}
}
