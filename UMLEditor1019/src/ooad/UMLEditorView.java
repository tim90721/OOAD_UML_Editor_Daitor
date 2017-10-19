package ooad;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ooad.model.Model;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.IOException;
import java.awt.Canvas;
import java.awt.Font;

public class UMLEditorView extends JFrame {

	private JPanel _panelContentPane;
	private JMenuBar _menuBar;
	private JMenu _menuFile;
	private JMenu _menuEdit;
	private JMenuItem _itemGroup;
	private JMenuItem _itemUnGroup;
	private JButton _btnSelect;
	private JButton _btnAssociaLine;
	private JButton _btnGeneralLine;
	private JButton _btnCompositionLine;
	private JButton _btnClass;
	private JButton _btnUseCase;
	private PaintPanel _pPanel;
	private Model _model;
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
					UMLEditorView frame = new UMLEditorView(new Model());
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
	public UMLEditorView(Model model) {
		this._model = model;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("UMLEditor");
		setBounds(100, 100, 1000, 800);

		_panelContentPane = new JPanel();
		_panelContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(_panelContentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0,Double.MIN_VALUE};
		_panelContentPane.setLayout(gbl_contentPane);
		
		initiateComponent();
		
		_pPanel = new PaintPanel(_model);
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
		_menuBar = new JMenuBar();
		setJMenuBar(_menuBar);
		
		_menuFile = new JMenu("File");
		_menuFile.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		_menuBar.add(_menuFile);
		
		_menuEdit = new JMenu("Edit");
		_menuEdit.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		_menuBar.add(_menuEdit);
		
		_itemGroup = new JMenuItem("Group");
		_menuEdit.add(_itemGroup);
		
		_itemUnGroup = new JMenuItem("UnGroup");
		_menuEdit.add(_itemUnGroup);
	}
	
	private void initiateButtons() {
		_btnSelect = new JButton();
		configButton(_btnSelect, 0);
		
		_btnAssociaLine = new JButton();
		configButton(_btnAssociaLine, 1);
		
		_btnGeneralLine = new JButton();
		configButton(_btnGeneralLine, 2);
		
		_btnCompositionLine = new JButton();
		configButton(_btnCompositionLine, 3);
		
		_btnClass = new JButton();
		configButton(_btnClass, 4);
		
		_btnUseCase = new JButton();
		configButton(_btnUseCase, 5);
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
			Image scaleImage = image.getScaledInstance(IMAGE_SIZE, IMAGE_SIZE, Image.SCALE_REPLICATE);
			button.setIcon(new ImageIcon(scaleImage));
		}catch (IOException e) {
			e.printStackTrace();
			System.out.println("!!Image NOT FOUND!!");
		}
	}
}
