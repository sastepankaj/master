package threads.executors;

public class PrintNumberTask implements Runnable{
	private int val;
	public PrintNumberTask(int number) {
		val = number;
	}
	public void run() {
		/*try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println(Thread.currentThread().getName() + " : " + val);
	}
}
