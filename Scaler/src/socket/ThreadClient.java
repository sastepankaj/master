package socket;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadClient {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		for(int i=1; i<=10; ++i) {
			 RequestSender sender = new RequestSender(i);
			 executor.submit(sender);
		}
		executor.shutdown();
		while(!executor.isTerminated());
		System.out.println("Finished all request. Closing client");
	}
}
