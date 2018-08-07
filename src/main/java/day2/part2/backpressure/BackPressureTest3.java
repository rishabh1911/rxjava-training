package day2.part2.backpressure;

import java.util.concurrent.TimeUnit;

import day2.part1.concurrency.Utility;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
//This will lead to Out of memory
public class BackPressureTest3 {
	
	public static void main(String[] args) {
		
		Observable.interval(1, TimeUnit.MICROSECONDS)
		.observeOn(Schedulers.computation())
			.doOnNext(s->System.out.println("Pushing "+s))
			.observeOn(Schedulers.computation())
			.subscribe(s->{
				Utility.sleep(1000);
				System.out.println("Consuming: "+s);
			});
		
		Utility.sleep(1000000);
	}

}
