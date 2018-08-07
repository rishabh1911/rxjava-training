package day2.part1.concurrency;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class ThreadTest4 {

	public static void main(String[] args) {
		
		Observable<Integer> source=Observable.range(1, 10);
		source.observeOn(Schedulers.computation())
		.map(x->{
			//After first observeOn will be on new Thread
			System.out.println("mapping "+x+" "+Thread.currentThread().getName());
			return Utility.longRunningComputation(x*2);
		}).observeOn(Schedulers.computation())
		.subscribe(s->{
			//After second observeOn will be on other Thread
			System.out.println(Thread.currentThread().getName()+" "+s);
		});
		
		Utility.sleep(10000);
	}	
}
