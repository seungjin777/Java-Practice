package practice06;
import javax.swing.*;
import java.awt.*;

public class RandRect extends JFrame{
	
	public RandRect() {
		setTitle("randRect");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		
		int x, y, r, g, b;
		
		for(int i=0; i<20; i++) {
			r = (int)(Math.random()*256);
			g = (int)(Math.random()*256);
			b = (int)(Math.random()*256);
			
			x = (int)(Math.random()*241 + 10);
			y = (int)(Math.random()*241 + 10);
			
			JLabel jb = new JLabel();
			jb.setOpaque(true);
			jb.setBackground(new Color(r,g,b));
			jb.setSize(10, 10);
			jb.setLocation(x, y);
			
			c.add(jb);
		}
		
		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new RandRect();
	}
}
