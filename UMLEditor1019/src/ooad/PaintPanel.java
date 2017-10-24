package ooad;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import ooad.model.IModel;
import ooad.model.IObserver;
import ooad.model.Model;
import ooad.viewevent.CustomMouseEvent;

public class PaintPanel extends JPanel implements IObserver{
	private IModel _model;
	
	/**
	 * 
	 */
	public PaintPanel(IModel model) {
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setBackground(Color.WHITE);
		
		_model = model;
		_model.registerPaintObserver(this);
		
		initiateMouseListener();
	}
	
	private void initiateMouseListener(){
		CustomMouseEvent mouseEvent = new CustomMouseEvent(_model);
		
		addMouseListener(mouseEvent.getPressedEvent());
		addMouseMotionListener(mouseEvent.getDraggedEvent());
		addMouseListener(mouseEvent.getReleasedEvent());
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		_model.draw(g);
	}

	@Override
	public void update() {
		repaint();
	}
}
