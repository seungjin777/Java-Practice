package practice10;
import java.util.Scanner;

public class WordGame {
	private String str[];
	private String correct;
	private long startTime, enterTime, timeCounter;
	private static void SWAP(char alps[], int ia, int ib, char tmp) {
		tmp = alps[ia];
		alps[ia] = alps[ib];
		alps[ib] = tmp;
	}
	
	public WordGame() {
		str = new String[4];
		str[0] = "pokemon";
		str[1] = "master";
		str[2] = "javascript";
		str[3] = "nodejs";
	}
	
	private void randWord() {
		int index = (int)(Math.random()*4);
		correct = str[index];
		char alps[] = str[index].toCharArray();
		char tmp = 0;
		
		for(int i=0; i<alps.length; i++) {
			int ia = (int)(Math.random()*(alps.length));
			int ib = (int)(Math.random()*(alps.length));
			SWAP(alps, ia, ib, tmp);
		}
		
		for(int i=0; i<alps.length; i++) {
			System.out.print(alps[i]);
		}
		System.out.println();
	}
	
	private void scoring(String ans) {
		if(correct.equals(ans) == true && timeCounter <= 10000) //10초 정답경우
			System.out.println("성공!!!");
		else if(correct.equals(ans) != true && timeCounter <= 10000) //10초 오답경우
			System.out.println("실패... " + correct + "입니다");
		else if(timeCounter > 10) //10초 초과
			System.out.println("시간초과 : " + ((double)timeCounter/1000) + " 정답은 "+correct + "입니다");
	}
	
	public void run() {
		String ans = new String();
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("10초 안에 단어를 맞추세요!!");
			startTime = System.currentTimeMillis();
			
			randWord();
			System.out.print(">>");
			ans = scanner.next(); //답 입력
			enterTime = System.currentTimeMillis();
			timeCounter = enterTime - startTime; //걸린 시간
			
			if(ans.equals("그만")) break; //종료
			scoring(ans); //채점
			System.out.println("");
		}
		System.out.println("프로그램을 종료합니다..");
		scanner.close();
	}
	
	public static void main(String[] args) {
		WordGame wg = new WordGame();
		wg.run();
	}
}
