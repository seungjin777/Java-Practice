package ex07;

class GStack<T>{
	int tos;
	Object [] stck;
	public static <T> GStack<T> reverse(GStack<T> a){
		GStack<T> s = new GStack<T>();
		while(true) {
			T tmp;
			tmp = a.pop();
			if(tmp == null)
				break;
			else
				s.push(tmp);
		}
		return s;
	}
	
	public GStack() {
		tos = 0;
		stck = new Object [10];
	}
	public void push(T item) {
		if(tos == 10)
			return;
		stck[tos++] = item;
	}
	@SuppressWarnings("unchecked")
	public T pop() {
		if(tos == 0)
			return null;
		return (T)stck[--tos];
	}
}

public class MyStack {
	public static void main(String[] args) {
		GStack<String> stringStack = new GStack<String>();
		stringStack.push("aaa");
		stringStack.push("bbb");
		stringStack.push("ccc");
		
		stringStack = GStack.reverse(stringStack);
		for(int i=0; i<3; i++) {
			System.out.println(stringStack.pop());
		}
	}
}
