package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GraphicsPanel extends JPanel implements MouseListener, MouseMotionListener, KeyListener {
	private int x1 = 0, y1 = 0, x2 = 0, y2 = 0;

	// Constructor, adding mouse and keyboard listeneres
	public GraphicsPanel() {
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			x1--;
			x2--;
			repaint();
			break;
		case KeyEvent.VK_RIGHT:
			x1++;
			x2++;
			repaint();
			break;
		case KeyEvent.VK_UP:
			y1--;
			y2--;
			repaint();
			break;
		case KeyEvent.VK_DOWN:
			y1++;
			y2++;
			repaint();
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g); // limpa fundo ...
		g.setColor(Color.BLUE);
		g.fillOval(x1, y1, x2 - x1 + 1, y2 - y1 + 1);
		
		//jogo.mapping.charAt(charpos).
		
		
		
	}

	
	
}
