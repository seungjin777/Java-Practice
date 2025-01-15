package ex;
import java.awt.*;
import javax.swing.*;

class RThread implements Runnable{
	private JLabel timerLabel;
	
	public RThread(JLabel timerLabel) {
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
			}catch(InterruptedException e) {
				return;
			}
		}
	}
}

public class RunnableTimerEx extends JFrame {
	public RunnableTimerEx() {
		setTitle("thread");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		JLabel timerLabel = new JLabel();
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80));
		c.add(timerLabel);
		
		RThread tr = new RThread(timerLabel);
		Thread th = new Thread(tr);
		
		setSize(300, 170);
		setVisible(true);
		
		th.start();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RunnableTimerEx();
	}
}
