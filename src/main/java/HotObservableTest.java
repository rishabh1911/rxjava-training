import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

import io.reactivex.CompletableObserver;
import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

public class HotObservableTest {
	
	public static void main(String[] args) {
		ConnectableObservable<Integer> source = Observable.range(1, 10).publish();
		source.map(x->x*10).subscribe( x -> System.out.println("Subscriber 1: "+ x));
		source.subscribe( x -> System.out.println("Subscriber 2: "+ x));
		
		
		//need to do connect which starts the subscription
		source.connect();
	}

}
