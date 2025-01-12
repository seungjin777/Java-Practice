package OpenChallenge;
import javax.swing.*;
import java.awt.*;

public class WordGame extends JFrame {
	private String text;
	
	public WordGame() {
		text = "I can't help falling in love with you";
		
		setTitle("wordGame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		c.add(new NorthPanel(), BorderLayout.NORTH);
		c.add(new CenterPanel(), BorderLayout.CENTER);
		c.add(new SouthPanel(), BorderLayout.SOUTH);
		
		setSize(400,300);
		setVisible(true);
	}
	
	class NorthPanel extends JPanel {
		public NorthPanel() {
			setBackground(Color.LIGHT_GRAY);
			setLayout(new FlowLayout());
			add(new JLabel("단어 조합 게임! 순서대로 단어를 클릭하세요~~"));
			add(new JButton("New Text"));
		}
	}
	
	class CenterPanel extends JPanel{
		public CenterPanel() {
			int x, y;
			String [] words = text.split(" ");
			
			setLayout(null);
			for(int i=0; i<words.length; i++) {
				x = (int)(Math.random()*351);
				y = (int)(Math.random()*181);
				JLabel jb = new JLabel(words[i]);
				jb.setLocation(x, y);
				jb.setSize(100,20);
				add(jb);
			}
		}
	}
	
	class SouthPanel extends JPanel{
		public SouthPanel() {
			setBackground(Color.yellow);
			setLayout(new FlowLayout());
			add(new JLabel("name"));
			add(new JTextField(10));
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new WordGame();
	}
}
