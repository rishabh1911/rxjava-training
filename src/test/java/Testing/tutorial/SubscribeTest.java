package Testing.tutorial;

import org.junit.Test;

import io.reactivex.Observable;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

//for testing since we have asynchronous calls. we should use blocking subscribe for that.
//blocking subscribe should not be used in production. Only for unit testing. On make it single Threaded.
public class SubscribeTest {
	
	private int takeCount = 5;
	
	@Test
	public void testInterval() {
		Observable<Long> source1 = Observable.interval(10, TimeUnit.MILLISECONDS);
		AtomicInteger count =new AtomicInteger();
		
		//The below code fails
		//source1.take(takeCount).subscribe(i->count.incrementAndGet());
		
		//but using blockingSubscribe it passes.
		source1.take(takeCount).blockingSubscribe(i->count.incrementAndGet());
		assertTrue(count.get()==takeCount);
	}

}
