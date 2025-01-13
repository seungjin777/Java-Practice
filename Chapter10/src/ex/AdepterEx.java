package ex;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AdepterEx extends JFrame{
	private JLabel lb;
	
	public AdepterEx() {
		setTitle("Mouse");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null);
		
		c.addMouseListener(new MyListener());
		
		lb = new JLabel("Hello");
		lb.setSize(50, 20);
		lb.setLocation(30, 30);
		c.add(lb);
		
		setSize(250, 250);
		setVisible(true);
	}
	
	private class MyListener extends MouseAdapter{
		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			lb.setLocation(x,y);
		}
	}
	
	public static void main(String[] args) {
		new AdepterEx();
	}
}
