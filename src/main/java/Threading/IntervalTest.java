package Threading;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class IntervalTest {
	
	public static void main(String[] args) {
		
		//normally on main Thread
		Observable.just("aa","bbb").subscribe(x -> System.out.println(Thread.currentThread().getName()+ "  "+ x));
		
		//when we use interval it makes a new thread. as scheduler comes into picture
		// they are daemon threads and JVM do not wait for daemon threads to complete
		Observable.interval(1, TimeUnit.SECONDS).subscribe(x -> System.out.println(Thread.currentThread().getName()+ "  "+ x));
		
		//waiting main thread so that observable with interval can print
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
