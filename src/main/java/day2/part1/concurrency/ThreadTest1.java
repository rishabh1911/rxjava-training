package day2.part1.concurrency;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;


//Scheduler.io -> for non CPU intensive operations -> like IO, DB connection, Reading from file.
//Scheduler.computation -> for CPU intensive operations -> thread pool size equals no of cores.
public class ThreadTest1 {
	
	public static void main(String[] args) throws InterruptedException{
		
		Observable<Integer> source1 = Observable.range(1, 10);
		
		// when we have Scheduler.computation or Scheduler.io both,
		//upstream and downstream work on separate thread than the calling thread.
		source1.map(x->mapLocal(x))
				.subscribeOn(Schedulers.computation())
				.subscribe(x -> System.out.println(Thread.currentThread().getName()+" "+ x));
		
		Thread.sleep(1000);
	}
	
	private static int mapLocal(int x) {
		System.out.print(Thread.currentThread().getName()+" "+ x+"  ");
		return x*2;
	}
}
