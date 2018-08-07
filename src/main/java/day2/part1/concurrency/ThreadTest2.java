package day2.part1.concurrency;

import java.util.concurrent.ThreadLocalRandom;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class ThreadTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Observable<Integer> source=Observable.range(1, 30);
		
		source.map(x->{
			System.out.println("mapping "+x+" "+Thread.currentThread().getName());
			return longRunningComputation(x*2);
		}).subscribeOn(Schedulers.computation())
		.subscribe(s->{
			System.out.println(Thread.currentThread().getName()+" "+s);
		});
			System.out.println("first");
		source.map(x->{
			System.out.println("mapping "+x+" "+Thread.currentThread().getName());
			return longRunningComputation(x*3);
		}).subscribeOn(Schedulers.computation())
		.subscribe(s->{
			System.out.println(Thread.currentThread().getName()+" "+s);
		});
		System.out.println("second");
		sleep(Integer.MAX_VALUE);

	}

	private static Integer longRunningComputation(Integer x) {
		// TODO Auto-generated method stub
		sleep(ThreadLocalRandom.current().nextInt(100));
		return x;
		
	}

	private static void sleep(int nextInt) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(nextInt);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
