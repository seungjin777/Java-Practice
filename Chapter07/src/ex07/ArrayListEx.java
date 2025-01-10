package ex07;
import java.util.Scanner;
import java.util.ArrayList;

public class ArrayListEx {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		ArrayList<String> a = new ArrayList<String>();
		
		for(int i=0; i<4; i++) {
			System.out.print("name >> ");
			a.add(scanner.next());
		}
		
		for(int i=0; i<4; i++) {
			System.out.print(a.get(i) + " ");
		}
		System.out.println();
	
		int longindex = 0;
		for(int i=1; i<a.size(); i++) {
			if(a.get(longindex).length() < a.get(i).length()) {
				longindex = i;
			}
		}
		System.out.println("\n가장 긴 이름은: " + a.get(longindex));
		
		scanner.close();
	}
}
