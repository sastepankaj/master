package threads.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Print100 {
	public static void main(String[] args) {
		ExecutorService exe = Executors.newCachedThreadPool();
		//ExecutorService exe = Executors.newFixedThreadPool(10);
		for(int i=1; i<=100; ++i) {
			PrintNumberTask task = new PrintNumberTask(i);
			exe.execute(task);
		}
	}
}
