package ex;
import javax.swing.*;
import java.awt.*;

class TThread extends Thread{
	private JLabel timerLabel;
	
	public TThread(JLabel timerLabel) {
		this.timerLabel = timerLabel;
	}
	
	@Override
	public void run() {
		int n = 0;
		while(true) {
			timerLabel.setText(Integer.toString(n));
			n++;
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e){
				return;
			}
		}
	};
}

public class ThreadTiemrEx extends JFrame{
	public ThreadTiemrEx() {
		setTitle("thread");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		JLabel timerLabel = new JLabel();
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80));
		c.add(timerLabel);
		
		TThread th = new TThread(timerLabel);
		
		setSize(300, 170);
		setVisible(true);
		
		th.start();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ThreadTiemrEx();
	}
}
