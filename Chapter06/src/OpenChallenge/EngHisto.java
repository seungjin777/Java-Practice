package OpenChallenge;
import java.util.*;

public class EngHisto {
	private String engText;
	private int alp[];
	
	public EngHisto() {
		alp = new int [26];
		for(int i =0 ; i< alp.length; i++) {
			alp[i] = 0;
		}
	}
	
	private void run() {
		System.out.println("영문 텍스트를 입력하고 세미콜론을 입력하세요. ");
		engText = readString().toUpperCase();
		drawHisto();
	}
	
	private String readString() {
		StringBuffer sb = new StringBuffer();
		Scanner scanner = new Scanner(System.in);
		while(true) {
			String line = scanner.nextLine();
			if(line.equals(";"))
				break;
			sb.append(line);
		}
		scanner.close();
		return sb.toString();
	}
	
	private void drawHisto() {
		System.out.println("히스토그램을 그립니다.");
		for(int i=0; i<engText.length(); i++) {
			
			int unico = engText.codePointAt(i);
			//System.out.println(unico);
			if( unico >= 65 && unico <= 90) {
				alp[unico - 65]++;
			}
		}
		
		for(int i=0; i<alp.length; i++) {
			
			System.out.print((char)(i+65));
			
			for(int j=0; j<alp[i]; j++) {
				System.out.print("-");
			}
			
			System.out.println();
		}
		
	}
	
	public static void main(String[] args) {
		EngHisto eh = new EngHisto();
		eh.run();
	}
}
