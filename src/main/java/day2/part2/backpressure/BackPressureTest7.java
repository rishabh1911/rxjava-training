package day2.part2.backpressure;

import java.util.concurrent.TimeUnit;

import day2.part1.concurrency.Utility;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

//To handle back Pressure Exception we have 3 options
//1. Use BackPressureBuffer
//2. Use BackPressureDrop - 
//3. Use BackPressureLatest - When we need the latest Value only. Not concerned with older value.
public class BackPressureTest7 {
	
	public static void main(String[] args) {

		Flowable.interval(1, TimeUnit.MILLISECONDS)
		.onBackpressureLatest()
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
