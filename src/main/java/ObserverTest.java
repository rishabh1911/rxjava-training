import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ObserverTest{
	
	public static void main(String[] args) {
	
		
		Observer<String> observer = new Observer<String>() {

			@Override
			public void onSubscribe(Disposable d) {
				System.out.println("Subscribed");
				
			}

			@Override
			public void onNext(String t) {
				System.out.println("Received: "+t);
				
			}

			@Override
			public void onError(Throwable e) {
				System.err.println(e.getMessage());
				
			}

			@Override
			public void onComplete() {
				System.out.println("Complete");
				
			}
		};
		
		Observable<String> source = Observable.just("first","sec","third");
		
		System.out.println("Starting subscription");
		source.subscribe(observer);
		System.out.println("Done");
		
	}
}
