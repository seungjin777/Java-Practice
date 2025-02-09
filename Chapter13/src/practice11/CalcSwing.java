package practice11;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalcSwing extends JFrame{
	private InputPanel inp = new InputPanel();
	private BtnPanel btnp = new BtnPanel();
	private OutputPanel outp = new OutputPanel();
	
	public CalcSwing() {
		setTitle("calcswing");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		c.add(inp, BorderLayout.NORTH);
		c.add(btnp, BorderLayout.CENTER);
		c.add(outp, BorderLayout.SOUTH);
		
		setSize(400,400);
		setVisible(true);
	}
	
	private class InputPanel extends JPanel{
		private JTextField inJtf = new JTextField(20);
		public InputPanel() {
			setBackground(Color.LIGHT_GRAY);
			
			add(new JLabel("수식"));
			add(inJtf);
		}
		
		public void setNumsTxt(String key) {
			//숫자 설정
			if(key.equals("UN")) { //언두
				if(inJtf.getText().length() > 0) {
					inJtf.setText(inJtf.getText().substring(0, inJtf.getText().length() - 1));
				}
			}
			else if(key.equals("C")) { //초기화
				inJtf.setText("");
			}
			else if(key.equals("BK")) {
				//아직 기능 없음
			}
			else { //삽입
				inJtf.setText(inJtf.getText() + key);
			}
		}
		
		public String getNumsTxt() {
			return inJtf.getText();
		}
	}
	
	private class BtnPanel extends JPanel{
		private int posX = 9;
		private int posY = 20;
		public BtnPanel() {
			setBackground(Color.white);
			setLayout(null);
			
			JButton btn_arr[] = new JButton[20];
			for(int i=0; i<btn_arr.length; i++) {
				btn_arr[i] = new JButton();
				btn_arr[i].setSize(90,50);
				btn_arr[i].setLocation(posX, posY);
				if((i+1) % 4 == 0) {
					posY += 52;
					posX = 9;
				}
				else {
					posX += 92;
				}
				btn_arr[i].addActionListener(new BtnListener());//리스너 추가
				add(btn_arr[i]);
			}
			
			btn_arr[0].setText("C"); btn_arr[1].setText("UN"); btn_arr[2].setText("BK");
			btn_arr[3].setText("/"); btn_arr[4].setText("7"); btn_arr[5].setText("8");
			btn_arr[6].setText("9"); btn_arr[7].setText("x"); btn_arr[8].setText("4");
			btn_arr[9].setText("5"); btn_arr[10].setText("6"); btn_arr[11].setText("-");
			btn_arr[12].setText("1"); btn_arr[13].setText("2"); btn_arr[14].setText("3");
			btn_arr[15].setText("+"); btn_arr[16].setText("0"); btn_arr[17].setText(".");
			btn_arr[18].setText("="); btn_arr[18].setBackground(Color.cyan); btn_arr[19].setText("%");
		}
		
		private class BtnListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				JButton btn = (JButton)e.getSource();
				
				if(btn.getText().equals("=")) {
					outp.calcOut(inp.getNumsTxt());
				}else
					inp.setNumsTxt(btn.getText());
			}
		}
	}
	
	private class OutputPanel extends JPanel{
		private JTextField outJtf = new JTextField(20);
		private double calcValue;
		private double a, b;
		private String option;
		
		public OutputPanel() {
			setBackground(Color.yellow);
			
			add(new JLabel("계산 결과"));
			add(outJtf);
		}
		
		public void calcOut(String text) { //계산후 결과 출력
			StringTokenizer textSt = new StringTokenizer(text, "+-x/%", true);
			if(textSt.countTokens() != 3) {
				outJtf.setText("잘못된 수식입니다.");
				return;
			}
			
			try {
				a =  Double.parseDouble(textSt.nextToken());
				option = textSt.nextToken();
				b = Double.parseDouble(textSt.nextToken());
			}catch(ClassCastException e) {
				outJtf.setText("잘못된 수식입니다.");
				return;
			}
			
			switch(option) {
				case "+": calcValue = a + b; break;
				case "-": calcValue = a - b; break;
				case "x": calcValue = a * b; break;
				case "/": calcValue = a / b; break;
				case "%": calcValue = a % b; break;
			}
			
			outJtf.setText(Double.toString(calcValue));
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CalcSwing();
	}

}
