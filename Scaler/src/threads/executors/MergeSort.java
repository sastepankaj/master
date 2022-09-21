package threads.executors;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MergeSort {
	public static void main(String[] args) {
		ExecutorService exe = Executors.newCachedThreadPool();
		List<Integer> numbers = Arrays.asList(5, 6, 3, 2, 6, 4);
		SortTask task = new SortTask(numbers,exe);
		Future<List<Integer>> fut = exe.submit(task);
		try {
			numbers = fut.get();
			System.out.println(numbers);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

}
