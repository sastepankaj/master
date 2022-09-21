package threads.thread;

public class Print100 {
	public static void main(String[] args) {
		for(int i=1; i<=100; ++i) {
			PrintNumberTask task = new PrintNumberTask(i);
			Thread t = new Thread(task);
			t.start();
		}
	}
}
