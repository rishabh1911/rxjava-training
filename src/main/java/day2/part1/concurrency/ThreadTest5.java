package day2.part1.concurrency;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class ThreadTest5 {

	public static void main(String[] args) {

		Observable<String> source=Observable.just("this is a test","rx java supports reactive programming");
		source
		.observeOn(Schedulers.computation())
		.doOnNext(s->System.out.println(Thread.currentThread().getName()))
		// two threads for above computation
		.flatMap(s->Observable.fromArray(s.split(" "))
				.observeOn(Schedulers.computation()))
		//new thread for each word
		.doOnNext(s->System.out.println(Thread.currentThread().getName()))
		.subscribe(System.out::println);
		
		/*source.flatMap(s->Observable.fromArray(s.split("")))
		.doOnNext(s->System.out.println(Thread.currentThread().getName()))
		.subscribe(System.out::println);*/
		Utility.sleep(10000);
	}	
}