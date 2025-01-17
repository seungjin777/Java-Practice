package OpenChallenge;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class MonsterThread extends Thread{
	private JLabel monster;
	private JLabel avata;
	public MonsterThread(JLabel monster, JLabel avata) {
		this.monster = monster; this.avata = avata;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(100);
				chasing(); //추격
				monster.getParent().repaint();
			}catch(InterruptedException e) { return; }
		}
	}
	
	public void chasing() {
		int x = monster.getX();
		int y = monster.getY();
		
		if(avata.getX() < monster.getX())
			x -= MoveGame.MOVE;
		if(avata.getX() > monster.getX())
			x += MoveGame.MOVE;
		if(avata.getY() < monster.getY())
			y -= MoveGame.MOVE;
		if(avata.getY() > monster.getY())
			y += MoveGame.MOVE;
		
		monster.setLocation(x, y);
	}
}

public class MoveGame extends JFrame{
	public static final int MOVE = 10;
	private JLabel avata;
	private JLabel monster;
	
	public MoveGame() {
		setTitle("OP13");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null);
		c.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				
				if(keyCode == KeyEvent.VK_Q)
					System.exit(0);
				
				switch(keyCode) {
					case KeyEvent.VK_UP:
						avata.setLocation(avata.getX(), avata.getY() - MOVE); break;
					case KeyEvent.VK_DOWN:
						avata.setLocation(avata.getX(), avata.getY() + MOVE); break;
					case KeyEvent.VK_LEFT:
						avata.setLocation(avata.getX() - MOVE, avata.getY()); break;
					case KeyEvent.VK_RIGHT:
						avata.setLocation(avata.getX() + MOVE, avata.getY()); break;
				}
			}
		});
		
		avata = new JLabel("@");
		avata.setForeground(Color.red);
		avata.setSize(15, 15);
		avata.setLocation(100, 50);
		c.add(avata);
		
		monster = new JLabel("M");
		monster.setSize(15, 15);
		monster.setLocation(50, 50);
		c.add(monster);
		
		c.setFocusable(true);
		c.requestFocus();
		
		setSize(500, 500);
		setVisible(true);
		
		MonsterThread th = new MonsterThread(monster, avata);
		th.start();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MoveGame();
	}
}
