package practice13;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

class WordThread extends Thread{
	private JLabel dropWord;
	private JLabel checker;
	private int x, y;
	
	public WordThread(JLabel dropWord, JLabel checker) {
		this.dropWord = dropWord;
		this.checker = checker;
		x = dropWord.getX();
		y = dropWord.getY();
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				if(y >= 600) {
					dropWord.getParent().remove(dropWord);
					checker.setText("time Out");
					return; //시간초과
				}
				dropWord.setLocation(x, y += 10);
				Thread.sleep(200);
				dropWord.getParent().repaint();//리페인트
			}catch(InterruptedException e) {
				return;
			}
		}
	}
}

public class RainGame extends JFrame{
	private JLabel checker;
	private JLabel dropWord;
	private JTextField inputer;
	private Vector <String> v;
	private WordThread th;
	
	public RainGame() {
		
		v = new Vector<String>();
		try {
			Scanner scanner = new Scanner(new FileReader("words.txt"));
			while(scanner.hasNext()) {
				String word = scanner.nextLine();
				v.add(word);
			}
			scanner.close();
		}catch(FileNotFoundException e) {
			System.out.println("파일 입출력 오류");
			return;
		}
		
		
		setTitle("rainGame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		c.add(new CenterArea(), BorderLayout.CENTER);
		c.add(new SouthArea(), BorderLayout.SOUTH);
		
		setSize(500, 700);
		setVisible(true);
	}
	
	public JLabel getChecker() {
		return checker;
	}
	
	class CenterArea extends JPanel{
		public CenterArea() {
			this.setLayout(null);
			checker = new JLabel("time out");
			checker.setLocation(5, 5);
			checker.setSize(50,20);
			this.add(checker);
			
			dropping();
			
		}
	}
	
	class SouthArea extends JPanel{
		public SouthArea() {
			this.setBackground(Color.gray);
			inputer = new JTextField(20);
			this.add(inputer);
			
			inputer.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent e) {
					if(e.getKeyCode() == KeyEvent.VK_ENTER) {
						System.out.println("enter");
						//떨어지는 단어와 비교
						if(inputer.getText().equals(dropWord.getText()) == true) {
							checker.setText("success"); //성공 출력
							dropEnd();//드롭 텍스트 지우기
							dropping();//새로 드롭하기
						}
						inputer.setText(""); //창 비우기
					}
				}
			});
			
			this.setFocusable(true); //포커스 주기
		}
	}
	
	public void dropping() { //드롭
		int i = (int)(Math.random()*v.size());
		dropWord = new JLabel(v.get(i));
		dropWord.setFont(new Font("Tahoma", Font.ITALIC, 20));
		dropWord.setForeground(Color.magenta);
		dropWord.setSize(200, 30);
		dropWord.setLocation(300, 0);
		this.add(dropWord);
		th = new WordThread(dropWord, checker);
		th.start();
	}
	
	public void dropEnd() { //드롭 중단
		System.out.println("end");
		dropWord.getParent().remove(dropWord);
		th.interrupt();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RainGame();
	}
}
