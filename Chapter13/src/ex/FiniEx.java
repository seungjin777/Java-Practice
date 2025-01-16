package ex;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class RandomThread extends Thread{
	private Container c;
	private boolean flag = false;
	
	public RandomThread(Container c) {
		this.c = c;
	}
	
	public void finish() {
		flag = true;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				//뭐 기능 암거나 귀찮노 쓰기
				Thread.sleep(300);
				if(flag == true) {
					c.removeAll();
					
					JLabel jl = new JLabel("finish");
					jl.setLocation(100, 100);
					jl.setSize(80, 30);
					c.add(jl);
					c.repaint();
					return;
				}
			}catch(InterruptedException e) {return;}
		}
	}
}

public class FiniEx extends JFrame{
	private RandomThread th;
	public FiniEx() {
		setTitle("a");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null);
		
		c.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				th.finish();
			}
		});
		
		setSize(300, 200);
		setVisible(true);
		
		th = new RandomThread(c);
		th.start();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FiniEx();
	}
}
