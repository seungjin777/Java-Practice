package ex;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Move extends JFrame {
	private final int UNIT = 10;
	private JLabel la = new JLabel(" >,< ");
	
	public Move() {
		setTitle("상하좌우");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null);
		
		c.addKeyListener(new MyKeyListener());
		la.setLocation(50, 50);
		la.setSize(100, 20);
		c.add(la);
		
		setSize(300, 300);
		setVisible(true);
	
		c.setFocusable(true);
		c.requestFocus();
		
		c.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Component com = (Component)e.getSource();
				com.setFocusable(true);
				com.requestFocus();
			}
		});
	}
	
	private class MyKeyListener extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			switch(keyCode) {
				case KeyEvent.VK_UP:
					la.setLocation(la.getX(), la.getY()-UNIT); break;
				case KeyEvent.VK_DOWN:
					la.setLocation(la.getX(), la.getY()+UNIT); break;
				case KeyEvent.VK_RIGHT:
					la.setLocation(la.getX()+UNIT, la.getY()); break;
				case KeyEvent.VK_LEFT:
					la.setLocation(la.getX()-UNIT, la.getY()); break;
			}
		}
	}
	
	public static void main(String[] args) {
		new Move();
	}
}
