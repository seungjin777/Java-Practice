package ex;
import java.awt.*;
import javax.swing.*;

class FlickeringLabel extends JLabel implements Runnable{
	private long delay;
	
	public FlickeringLabel(String text, long delay) {
		super(text);
		this.delay = delay;
		setOpaque(true);
		
		Thread th = new Thread(this);
		th.start();
	}
	
	@Override
	public void run() {
		int n=0;
		while(true) {
			if(n==0)
				setBackground(Color.yellow);
			else
				setBackground(Color.GREEN);
			if(n ==0) n = 1;
			else n = 0;
			try {
				Thread.sleep(delay);
			}catch(InterruptedException e) {
				return;
			}
		}
	}
}

public class Flickering extends JFrame {
	public Flickering() {
		setTitle("thread");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		FlickeringLabel fLabel1 = new FlickeringLabel("깜박", 500);
		JLabel label = new JLabel("안깜빡");
		FlickeringLabel fLabel2 = new FlickeringLabel("여기도 깜박", 300);
	
		c.add(fLabel1);
		c.add(label);
		c.add(fLabel2);
		
		setSize(300, 170);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Flickering();
	}
}
