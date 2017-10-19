package ooad;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class PaintPanel extends JPanel{
	private int squareX = 50;
	private int squareY = 50;
	private int squareW = 20;
	private int squareH = 20;
	
	public PaintPanel() {
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setBackground(Color.WHITE);
		
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				moveSquare(e.getX(), e.getY());
			}
		});
		
		addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				moveSquare(e.getX(), e.getY());
			}
		});
	}
	
	private void moveSquare(int x, int y) {
		int OFFSET = 1;
		if((squareX != x) || (squareY != y)) {
			repaint(squareX, squareY, squareW + OFFSET, squareH + OFFSET);
			squareX = x;
			squareY = y;
			repaint(squareX, squareY, squareW + OFFSET, squareH + OFFSET);
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		g.fillRect(squareX, squareY, squareW, squareH);
	}

}
