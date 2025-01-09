package practice09;
import java.util.Scanner;

public class Puzzle {
	private final static int ROWS = 5;
	private final static int COLS = 5;
	private final static char BASE_CHAR = '-';
	private char[][] board = new char[ROWS][COLS];
	
	public Puzzle() { //생성자 
		clearBoard();
	}
	
	private void clearBoard() { //초기화
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				board[i][j] = BASE_CHAR;
			}
		}
	}
	
	private void printBoard() { //보드 출력
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	private void put(int row, int col, int dir, String word) {
		switch(dir) {
			case 0:
				for(int i=0; i<word.length(); i++) {
					board[row][col] = word.charAt(i);
					row--;
				}
				break;
			case 1: 
				for(int i=0; i<word.length(); i++) {
					board[row][col] = word.charAt(i);
					row--; col++;
				}
				break;
			case 2: 
				for(int i=0; i<word.length(); i++) {
					board[row][col] = word.charAt(i);
					col++;
				}
				break;
			case 3: 
				for(int i=0; i<word.length(); i++) {
					board[row][col] = word.charAt(i);
					row++; col++;
				}
				break;
			case 4: 
				for(int i=0; i<word.length(); i++) {
					board[row][col] = word.charAt(i);
					row++;
				}
				break;
			case 5: 
				for(int i=0; i<word.length(); i++) {
					board[row][col] = word.charAt(i);
					row++; col--;
				}
				break;
			case 6: 
				for(int i=0; i<word.length(); i++) {
					board[row][col] = word.charAt(i);
					col--;
				}
				break;
			case 7: 
				for(int i=0; i<word.length(); i++) {
					board[row][col] = word.charAt(i);
					row--; col--;
				}
				break;
		}
	}
	
	private boolean isPossible(int row, int col, int dir, int length) {
		int rowSpan = 0;
		int colSpan = 0;
		switch(dir) {
			case 0: //위
				rowSpan = row + 1;
				if(rowSpan < length) return false; 
				else return true;
			case 1: //위오
				rowSpan = row + 1;
				colSpan = board[row].length - col;
			case 2: 
				colSpan = board[row].length - col;
				if(colSpan < length) return false;
				else return true;			
			case 3: 
				rowSpan = board.length - row;
				colSpan = board[row].length - col;
				if(rowSpan < length || colSpan < length) return false;
				else return true;
			case 4: 			
				rowSpan = board.length - row;
				if(rowSpan < length) return false;
				else return true;
			case 5:
				rowSpan = board.length - row;
				colSpan = col + 1;
				if(rowSpan < length || colSpan < length) return false;
				else return true;
			case 6: 
				colSpan = col + 1;
				if(colSpan < length) return false;
				else return true;		
			case 7: 
				rowSpan = row + 1;
				colSpan = col + 1;
				if(rowSpan < length || colSpan < length) return false;
				else return true;
			default:
				return false;
		}
		
	}
	
	private void place(String word) { //단어 위치 랜덤지정
		int row = (int)(Math.random()*board.length);
		int col = (int)(Math.random()*board[row].length);
		
		int dir [] = new int[8];
		int index = (int)(Math.random()*8);
		for(int i=0; i<8; i++) {
			dir[index] = i;
			index++;
			index %= 8;
		}
		
		for(int i=0; i<8; i++) {
			if(isPossible(row, col, dir[i], word.length())) {
				put(row, col, dir[i], word);
				return;
			}
		}
	}
	
	private void fill() { //나머지 칸 랜덤 채워 넣기
		for(int i=0; i<board.length; i++) {
			for(int j = 0; j<board[i].length; j++) {
				if(board[i][j] == BASE_CHAR) {
					board[i][j] = (char)(Math.random()*26);
					board[i][j] += 'a';
				}
			}
		}
	}
	
	public void run() {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.print("단어>>");
			String word = scanner.next();
			if(word.equals("그만"))
				break;
			else if(word.length() > COLS || word.length() > ROWS) {
				System.out.println("단어가 보드 크기보다 깁니다.");
				continue; // 다시 입력
			}
			clearBoard(); // 보드 지우기
			place(word); // 빈 모드에 단어만 배치
			//printBoard(); // 보드 출력
			fill(); // 빈 칸에 랜덤한 글자 채우기. 바탕 문자를 빈 칸으로 인식 
			printBoard(); // 보드 출력
		}
		scanner.close();
	}
	
	public static void main(String[] args) {
		Puzzle pz = new Puzzle();
		pz.run();
	}
}
