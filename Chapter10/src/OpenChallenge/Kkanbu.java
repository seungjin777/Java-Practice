package OpenChallenge;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class Kkanbu extends JFrame {
	private JButton btn[] = new JButton[4];
	private JLabel viewer = new JLabel("?", SwingConstants.CENTER);
	private int answer, key, value;
	private String evenORodd[] = {"짝", "홀"};
	private JLabel talker = new JLabel("무엇일까요?", SwingConstants.CENTER);
	
	public Kkanbu() {
		setTitle("KkanbuGame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null);
		
		btn[0] = new JButton("홀");
		btn[1] = new JButton("짝");
		btn[2] = new JButton("확인");
		btn[3] = new JButton("다시");
		
		for(int i=0; i<btn.length; i++) {
			btn[i].addActionListener(new MyListener());
			btn[i].setSize(60,30);
			btn[i].setLocation(60*i + (i+1)*9, 145);
			c.add(btn[i]);
		}
		
		answer = (int)(Math.random()*10 + 1);
		
		viewer.setSize(70, 70);
		viewer.setLocation(115, 30);
		viewer.setOpaque(true);
		viewer.setBackground(Color.darkGray);
		viewer.setForeground(Color.yellow);
		c.add(viewer);
		
		talker.setSize(100, 20);
		talker.setLocation(100, 110);
		c.add(talker);
		
		setSize(300,230);
		setVisible(true);
	}
	
	private class MyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton jbt = (JButton)e.getSource();
			String option = jbt.getText();
			
			switch(option) {
			case "홀": key = 1; break;
			case "짝": key = 0; break;
			case "확인": 
				value = answer %2;
				if(key == value) {
					viewer.setText(Integer.toString(answer));
					talker.setText( evenORodd[value] + "! 맞았어요.");
				}
				else {
					viewer.setText(Integer.toString(answer));
					talker.setText( evenORodd[value] + "! 아쉽군요.");
				}
				break;
			case "다시": 
				viewer.setText("?");
				talker.setText("무엇일까요?");
				answer = (int)(Math.random()*10 + 1);
				break;
			default: break;
			}
		}
	}
	
	public static void main(String[] args) {
		new Kkanbu();
	}
}
