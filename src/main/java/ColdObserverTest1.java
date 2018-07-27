import io.reactivex.Observable;

public class ColdObserverTest1 {

	public static void main(String[] args) {
		Observable<Integer> source = Observable.range(1, 10);
		source.map(x->x*10).subscribe( x -> System.out.println("Subscriber 1: "+ x));
		source.subscribe( x -> System.out.println("Subscriber 2: "+ x));
	}
}
