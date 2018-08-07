package day2.part2.backpressure;

import java.util.concurrent.TimeUnit;

import day2.part1.concurrency.Utility;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

//To handle back Pressure Exception we have 3 options
//1. Use BackPressureBuffer
//2. Use BackPressureDrop - elements of producer will be lost, when we do not care much about data
//3. Use BackPressureLatest
public class BackPressureTest6 {
	
	public static void main(String[] args) {

		Flowable.interval(1, TimeUnit.MILLISECONDS)
		.onBackpressureDrop()
		.doOnNext(
				s->{//System.out.println("pushing "+s);
				})
		.observeOn(Schedulers.io())
		.map(s->{
			Thread.sleep(100);
			return s;
		}).subscribe(s->System.out.println("receiving "+s));

		Utility.sleep(Integer.MAX_VALUE);
	}

}
