package day2.part4.subscribers;

import java.util.concurrent.atomic.AtomicInteger;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import day2.part1.concurrency.Utility;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;


//Till now we had been using consumers
//we can use subscribers as well
//which consumes on different thread.


class MySubscriber implements Subscriber<Integer>{
	private Subscription subscription;
	private AtomicInteger counter=new AtomicInteger();
	@Override
	public void onComplete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onError(Throwable arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onNext(Integer i) {
		// TODO Auto-generated method stub
		Utility.sleep(50);
		System.out.println("consuming "+i+" Thread: "+Thread.currentThread().getName());
		int value=counter.incrementAndGet();
		//System.out.println("value="+);
		if(value%20==0&&value>=40){
			System.out.println("requesting 20 more items");
			subscription.request(20);
		}
		else if(value==390)
			subscription.cancel();
	}

	@Override
	public void onSubscribe(Subscription subscription) {
		// TODO Auto-generated method stub
		this.subscription=subscription;
		System.out.println("subscribed");
		System.out.println("requesting 40 items");
		subscription.request(40);
	}
	
}

public class SubscriberTest1 {
	
	public static void main(String[] args) {
		Flowable<Integer> source = Flowable.range(1, 1000);
		source.doOnNext(x->System.out.println("pushing: "+x+" Thread: "+Thread.currentThread().getName()))
			.observeOn(Schedulers.computation())
			.subscribe(new MySubscriber());
		
		Utility.sleep(1000000);
	}

}
