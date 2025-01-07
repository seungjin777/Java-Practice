package practice14;
import java.util.Scanner;

abstract class Shape{
	private Shape next;
	public Shape() {next = null;}
	public void setNext(Shape obj) {next = obj;}
	public Shape getNext() {return next;}
	public abstract void draw();
}

class Line extends Shape{
	public void draw() {System.out.println("Line");}
}

class Rect extends Shape{
	public void draw() {System.out.println("Rect");}
}

class Circle extends Shape{
	public void draw() {System.out.println("Circle");}
}

public class GraphicEditor {
	Scanner scanner = new Scanner(System.in);
	Shape start, obj;
	
	public GraphicEditor() {
		int op;

		System.out.println("-- start Graphic Editor --");
		while(true) {
			System.out.print("input(1), delete(2), see(3), exit(4) >> ");
			op = scanner.nextInt();
			
			switch(op) {
				case 1: insertGraphic(); break;
				case 2: deleteGraphic(); break;
				case 3: seeAll(); break;
				case 4: return;
				default: break;
			}
		}
	}
	
	void insertGraphic() { //삽입
		int op;
		Shape p;
		System.out.print("Line(1), Rect(2), Circle(3) >> ");
		op = scanner.nextInt();
		switch(op) {
			case 1: obj = new Line(); break;
			case 2: obj = new Rect(); break;
			case 3: obj = new Circle(); break;
			default: System.out.println("error retry"); return;
		}
		
		if(start == null) {
			start = obj;
		} else {
			p = start;
			while(p.getNext() != null) {
				p = p.getNext();
			}
			p.setNext(obj);
		}
	}
	
	void deleteGraphic() { //삭제
		int n;
		Shape firP, nexP, tmpP = null;
		System.out.print("delete index >> ");
		n = scanner.nextInt();
		
		firP = start;
		
		if(n == 1) {
			if(firP == null) {
				System.out.println("do not delete"); return;
			} else
				firP = firP.getNext(); return;
		}
		
		for(int i=1; i<n; i++) {
			if(firP.getNext() == null) {
				System.out.println("do not delete"); return;
			}
			tmpP = firP;
			firP = firP.getNext(); 
		}
	
		tmpP.setNext(firP);	 //----------이부분 수정 필요-------/
	}
	
	void seeAll() {
		Shape p = start;
		while(p != null){
			p.draw();
			p = p.getNext();
		}
	}
	
	
	public static void main(String[] args) {
		new GraphicEditor();
		System.out.println("end");
	}
}
