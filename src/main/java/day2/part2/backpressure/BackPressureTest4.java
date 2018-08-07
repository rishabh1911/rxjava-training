package day2.part2.backpressure;

import java.util.concurrent.TimeUnit;

import day2.part1.concurrency.Utility;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;



//example of missing BackPressureException
public class BackPressureTest4 {

	public static void main(String[] args) {

		Flowable.interval(1, TimeUnit.MILLISECONDS)
		.doOnNext(
				s->{System.out.println("pushing "+s);
				})
		.observeOn(Schedulers.io())
		.map(s->{
			Thread.sleep(100);
			return s;
		}).subscribe(s->System.out.println("receiving "+s));

		Utility.sleep(Integer.MAX_VALUE);
	}
}