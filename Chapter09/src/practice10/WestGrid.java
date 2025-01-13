package practice10;
import javax.swing.*;
import java.awt.*;

public class WestGrid extends JFrame{
	public WestGrid() {
		setTitle("westGrid");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setLayout(new BorderLayout());
		c.add(new WestArea(), BorderLayout.WEST);
		c.add(new CenterArea(), BorderLayout.CENTER);
		
		setSize(300,300);
		setVisible(true);
	}
	
	class WestArea extends JPanel{
		public WestArea() {
			this.setLayout(new GridLayout(10, 1));
			for(int i=0; i<10; i++) {
				
				JButton btn = new JButton();
				btn.setSize(10,20);
				
				int r = (int)(Math.random()*256);
				int g = (int)(Math.random()*256);
				int b = (int)(Math.random()*256);
				btn.setOpaque(true);
				btn.setBackground(new Color(r,g,b));
				
				add(btn);
			}
		}
	}
	
	class CenterArea extends JPanel{
		public CenterArea() {
			this.setLayout(null);
			
			for(int i=0; i<10; i++) {
				JLabel jb = new JLabel(Integer.toString(i));
				jb.setForeground(Color.red);
				
				int x = (int)(Math.random()*151 + 50);
				int y = (int)(Math.random()*151 + 50);
				jb.setLocation(x, y);
				jb.setSize(10, 10);
				
				add(jb);
			}
		}
	}
	
	public static void main(String []args) {
		new WestGrid();
	}
}
