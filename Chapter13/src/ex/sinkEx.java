package ex;

public class sinkEx {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SharedBoard board = new SharedBoard(); 
		SThread th1 = new SThread("aa", board);
		SThread th2 = new SThread("bb", board);
		th1.start();
		th2.start();
	}
}

class SharedBoard extends Thread{
	private int sum = 0;
	synchronized public void add() {
		int n = sum;
		Thread.yield();
		n += 10;
		sum = n;
		System.out.println(Thread.currentThread().getName() + " : " + sum);
	}
	
	public int getSum() {return sum;}
	
}

class SThread extends Thread{
	private SharedBoard board;
	public SThread(String name, SharedBoard board) {
		super(name);
		this.board = board;
	}
	
	@Override
	public void run() {
		for(int i=0; i<10; i++);
		board.add();
	}

	
}