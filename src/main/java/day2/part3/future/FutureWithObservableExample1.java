package day2.part3.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

import day2.part1.concurrency.Utility;
import io.reactivex.Observable;

class MyCallable implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {		
		//Some blocking operation like I/O
		Utility.sleep(2000);
		return ThreadLocalRandom.current().nextInt(100);
	}
	
}

public class FutureWithObservableExample1 {
	
	public static void main(String[] args) {
		Callable<Integer> callable = new MyCallable();
		ExecutorService executor = Executors.newFixedThreadPool(3);
		Future<Integer> future = executor.submit(callable);
		System.out.println("Waiting for future to complete");
		Observable.fromFuture(future).subscribe(x->System.out.println(Thread.currentThread().getName()+" "+x));
		System.out.println("Main Thread was blocked");
		executor.shutdown();
		
		
	}

}
