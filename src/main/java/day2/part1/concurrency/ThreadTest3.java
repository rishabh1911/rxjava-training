package day2.part1.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

//Example of Scheduler.from(ExecutorService)
//this takes threads from the thread pools

//Thus instead of using Scheduler provided thread pool we are using user provided thread pool
public class ThreadTest3 {

	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		
		Observable<Integer> source = Observable.range(1, 10);
		source.map(x->Utility.longRunningComputation(x)).subscribeOn(Schedulers.from(executorService))
			.subscribe(x->Utility.printx(x));
		
		source.map(x->Utility.longRunningComputation(x)).subscribeOn(Schedulers.from(executorService))
		.subscribe(x->Utility.printx(x));
		
		executorService.shutdown();
		//both run on different thread of same thread pool.
	}
}
