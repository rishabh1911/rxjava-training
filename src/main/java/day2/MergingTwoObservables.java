package day2;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class MergingTwoObservables {

	public static void main(String[] args) throws InterruptedException {
		
		Observable<String> source1 = Observable.fromIterable(Arrays.asList("aa","bbbb","ccc"));
		Observable<Long> source2 = Observable.interval(1, TimeUnit.SECONDS);
		
		source1.zipWith(source2, (s,i)->s+" "+i).subscribe(System.out::println);
		//By default Rx Java is synchronous
		//To make it a synchronous we can use observables like interval.
		//Interval starts a new Thread.
		
		Thread.sleep(5000);
	}

}
