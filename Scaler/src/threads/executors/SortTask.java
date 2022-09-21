package threads.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class SortTask implements Callable<List<Integer>>{
	private List<Integer> list;
	ExecutorService executor;
	public SortTask(List<Integer> sortList, ExecutorService exe){
		list = sortList;
		executor = exe;
	}
	@Override
	public List<Integer> call() throws Exception {
		System.out.println(Thread.currentThread().getName() + " sorting list " + list);
		if(list.size()==1)
			return list;
	
		int end = list.size()-1;
		int mid = end/2;
		SortTask leftTask = new SortTask(getList(0, mid), executor);
		SortTask rightTask = new SortTask(getList(mid+1, end), executor);
		Future<List<Integer>> leftSorted = executor.submit(leftTask);
		Future<List<Integer>> rightSorted = executor.submit(rightTask);
		list = mergeLists(leftSorted.get(), rightSorted.get());
		return list;
	}
	
	private List<Integer> getList(int start, int end){
		List<Integer> lst = new ArrayList<>();
		for(int i=start; i<=end; i++) {
			lst.add(list.get(i));
		}
		return lst;
	}
	
	private List<Integer> mergeLists(List<Integer> left, List<Integer> right){
		List<Integer> lst = new ArrayList<>();
		int i=0;
		int j=0;
		while(i<left.size() && j<right.size()){
			if(left.get(i)<=right.get(j)) {
				lst.add(left.get(i));
				++i;
			}
			else if(left.get(i)>right.get(j)) {
				lst.add(right.get(j));
				++j;
			}
		}
		while(i<left.size()){
			lst.add(left.get(i));
			++i;
		}
		while(j<right.size()){
			lst.add(right.get(j));
			++j;
		}
		return lst;
	}
}
