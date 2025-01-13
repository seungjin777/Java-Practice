package ex;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyListenerEx extends JFrame{
	private JLabel [] keyMassage;
	
	public KeyListenerEx() {
		setTitle("key");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.addKeyListener(new MyListener());

		keyMassage = new JLabel[3];
		keyMassage[0] = new JLabel(" getKeyCode() ");
		keyMassage[1] = new JLabel(" getKeyChar() ");
		keyMassage[2] = new JLabel(" getKeyText() ");
		
		for(int i=0; i<keyMassage.length; i++) {
			c.add(keyMassage[i]);
			keyMassage[i].setOpaque(true);
			keyMassage[i].setBackground(Color.yellow);
		}
		
		setSize(300, 150);
		setVisible(true);
		
		c.setFocusable(true);
		c.requestFocus();
	}
	
	private class MyListener extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			char keyChar = e.getKeyChar();
			keyMassage[0].setText(Integer.toString(keyCode));
			keyMassage[1].setText(Character.toString(keyChar));
			keyMassage[2].setText(KeyEvent.getKeyText(keyCode));
			
			System.out.println("KeyPressed");
		}
		public void keyReleased(KeyEvent e) {
			System.out.println("KeyReleased");
		}
		public void keyTyped(KeyEvent e) {
			System.out.println("KeyTyped");
		}
	}
	
	public static void main(String[] args) {
		new KeyListenerEx();
	}
}
