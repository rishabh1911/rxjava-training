package day2.part2.backpressure;

import day2.part1.concurrency.Utility;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public class BackPressureTest2 {

public static void main(String[] args) throws InterruptedException {
		
		//Flowable Stops producer if it out-paces too much
		Flowable.range(1, 999_999_999)
		.observeOn(Schedulers.computation())
		.map(s->{
			Utility.sleep(10);
			return s;
		})
		.doOnNext(x->Utility.printx(x))
		.observeOn(Schedulers.io())
		.subscribe(s->{
			Utility.sleep(100);
			System.out.println("Consumed:" + s);
		});
		
		Thread.sleep(100000);
	}
}
