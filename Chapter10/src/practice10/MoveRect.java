package practice10;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MoveRect extends JFrame{
	private final static int WIDTH = 700;
	private final static int LENGTH = 700;
	private JLabel jlb;
	private int LocalX, LocalY;
	
	public MoveRect() {
		setTitle("moveRect");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null);
		
		c.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				int r, g, b;
				
				if(keyCode == KeyEvent.VK_M){
					System.out.println("pressed m");
					jlb = new JLabel();
					MyMouseListener ml = new MyMouseListener();
					jlb.addMouseListener(ml);
					jlb.addMouseMotionListener(ml);
					
					jlb.setSize(80, 80);
					jlb.setLocation(100, 100);
					
					r = (int)(Math.random()*256);
					g = (int)(Math.random()*256);
					b = (int)(Math.random()*256);
					jlb.setBackground(new Color(r, g, b));
					jlb.setOpaque(true);
					c.add(jlb);
					c.repaint();
				}
			}
		});
			
		setSize(WIDTH, LENGTH);
		setVisible(true);
	
		c.setFocusable(true);
		c.requestFocus();
	}
	
	private class MyMouseListener extends MouseAdapter{
		public void mousePressed(MouseEvent e) {
			jlb = (JLabel)e.getSource();
		}
		
		public void mouseDragged(MouseEvent e) {
			System.out.println("x:" + e.getXOnScreen() + ", y:" + e.getYOnScreen());
			jlb.setLocation(e.getXOnScreen()-50, e.getYOnScreen() - 70);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MoveRect();
	}
}
