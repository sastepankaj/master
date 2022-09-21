package threads.thread;

public class PrintNumberTask implements Runnable{
	private int val;
	public PrintNumberTask(int number) {
		val = number;
	}
	public void run() {
		System.out.println(Thread.currentThread().getName() + " : " + val);
	}
}
