package practice15;
//import java.util.

interface Shape{
	final double PI = 3.14;
	void draw();
	double getArea();
	default public void redraw() {
		System.out.println("--- 다시 그립니다. ");
		draw();
	}
}

class Circle implements Shape{
	int r;
	public Circle(int r) {this.r = r;}
	public void draw() {
		System.out.println("반지름이 " + r + "인 원");
	}
	public double getArea() {return r*r*PI; }
}

class Oval implements Shape{
	int a, b;
	public Oval(int a, int b) {this.a = a; this.b = b;}
	public void draw() {
		System.out.println(a + "x" + b + "에 내접하는 타원");
	}
	public double getArea() {return a*b*PI;}
}

class Rect implements Shape{
	int a, b;
	public Rect(int a, int b) {this.a = a; this.b = b;}
	public void draw() {
		System.out.println(a + "x" + b + "크기의 사각형");
	}
	public double getArea() {return a*b;}
}


public class ShapeEx {
	public static void main(String[] args) {
		Shape [] list = new Shape[3];
		list[0] = new Circle(5);
		list[1] = new Oval(20, 30);
		list[2] = new Rect(10, 40);
		for(int i = 0; i < list.length; i++) list[i].redraw();
		for(int i = 0; i < list.length; i++) 
			System.out.println("면적은 " + list[i].getArea());
	}
}
