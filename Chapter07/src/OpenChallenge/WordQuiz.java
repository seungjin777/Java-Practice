package OpenChallenge;
import java.util.*;

class Word{ //단어 객체
	private String Kor;
	private String Eng;
	
	public Word(String Kor, String Eng) {
		this.Eng = Eng; this.Kor = Kor;
	}
	
	public String getEng() {
		return this.Eng;
	}
	
	public String getKor() {
		return this.Kor;
	}
}


public class WordQuiz { //퀴즈 객체
	private Vector<Word> v;
	private int ansNum;
	
	public WordQuiz() {
		v = new Vector<Word>();
		v.add(new Word("사과", "apple"));
		v.add(new Word("개", "dog"));
		v.add(new Word("고양이", "cat"));
		v.add(new Word("사랑", "love"));
		v.add(new Word("물고기", "fish"));
		v.add(new Word("바나나", "banana"));
	}
	
	private void printQZ() { //문제 출력 함수
		int list[] = new int[7];
		int idx, count = 0;
		
		for(int i=0; i<7; i++) {
			list[i] = 0;
		} 
		
		//4지선다 답들
		while(count < 4) {
			idx = (int)(Math.random()*v.size());
			if(list[idx] == 0) {
				list[idx] = 1;
				count++;
			}
		}
		
		ansNum = (int)(Math.random()*4) + 1; //답 고름
		
		int j = 0, c = 1;
		while(true) {
			if(c > count) break;
			if(list[j] == 1) {
				if(c == ansNum) 
					System.out.println(v.get(j).getEng() + "?");
				c++;
			}
			j++;
		}
		
		j = 0; c = 1; 
		while(true) {
			if(c > count) break;
			if(list[j] == 1) {
				System.out.print("(" + c + ")" + v.get(j).getKor() + ">> ");
				c++;
			}
			j++;
		}
	}
	
	private void isCollect(int op) { //채점함수
		if(op == ansNum)
			System.out.println("Excellent!!");
		else
			System.out.println("No...");
	}
	
	public void run() { //게임 실행
		Scanner scanner = new Scanner(System.in);
		int op;
		
		System.out.println("start WordQZ. <end: -1>");
		System.out.println("now Words 7s");
		while(true) {
			printQZ(); //문제 출력
			op = scanner.nextInt(); //답 입력
			if(op == -1) break; //종료
			isCollect(op); //정답 판별
		}
		System.out.println("Game off..");
		scanner.close();
	}
	
	public static void main(String[] args) {
		WordQuiz qz = new WordQuiz();
		qz.run();
	}
}
