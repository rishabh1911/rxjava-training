package day2.part4.subscribers;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class ObservableToFlowableTest {
	
	public static void main(String[] args) {
		Observable<Integer> source = Observable.range(1, 100);
		Flowable<Integer> flowableSource = source.toFlowable(BackpressureStrategy.BUFFER);
		flowableSource.observeOn(Schedulers.computation())
			.subscribe(System.out::println);
		
		//similarly
		Flowable<String> flowableSource2 = Flowable.just("aaa","bbbb","cccc","ddddd");
		flowableSource2.toObservable().subscribe(System.out::println);
		
	}

}
